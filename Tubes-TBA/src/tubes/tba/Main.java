/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.tba;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;
/**
 *
 * @author trijakapam
 */
public class Main {
    public static FA subjek;
    public static FA predikat;
    public static FA objek;
    public static FA keterangan;
    private static CreateFA createFA = new CreateFA();
    public static void main(String[] args) {
        // Meminta Inputan User
        
        System.out.println("Masukan Sebuah Kalimat");
        System.out.println("!! WAJIB HURUF KECIL !!");
        Scanner scanner = new Scanner( System.in );
        String kalimat = scanner.nextLine();
        
        // Memecah Kalimat Menjadi Beberapa Kata
        PisahKata pisah = new PisahKata(kalimat);
        List<String> kata = pisah.getKata();
        
        // Membuat Push Down Automata
        Stack<Character> stack = new Stack<>();
            
        PDA init = new PDA("I");
        PDA s = new PDA("s");
        PDA q0 = new PDA("q0");
        PDA q1 = new PDA("q1");
        PDA q2 = new PDA("q2");
        PDA q3 = new PDA("q3",true);
        
        init.addTransition('-', '-', "S#", s);
        
        s.addTransition('-', 'S', "spX", q0);
        
        q0.addTransition('s', 's', "", q0);
        q0.addTransition('p', 'p', "", q0);
        q0.addTransition('o', 'X', "Y", q1);
        q0.addTransition('k', 'X', "", q2);
        q0.addTransition('-', 'X', "", q2);
        
        q1.addTransition('-', 'Y', "", q2);
        q1.addTransition('k', 'Y', "", q2);
        
        q2.addTransition('-', '#', "", q3);
        
        // Membuat Finite Automata
        
        subjek = createFA.subjek();
        predikat = createFA.predikat();
        objek = createFA.objek();
        keterangan = createFA.keterangan();
        
        // Menjalankan Mesin Automata
        PDA current = init;
        current = current.getNext(stack, '-', '-');
        current = current.getNext(stack, '-', stack.pop());
        
        System.out.println("Susunan kata: ");
        int i = 0;
        while(current!= null && i<kata.size()){
            current = current.getNext(stack, tokenRecognizer(kata.get(i)), stack.pop());
            i++;
        }
        
        while(current != null && !stack.isEmpty()){
            current = current.getNext(stack, '-', stack.pop()); 
        }
        
        // Mengeluarkan Hasil Apakah Kalimat Diterima Atau Tidak
        System.out.println("");
        try{   
            if(current.status()){
                System.out.print("Kata Diterima");
            }
            System.out.println("");
        } catch (Exception e){
            System.out.println("Kata Ditolak, kata-kata tidak sesuai");
        }
    }
    
    
    // Mendeteksi Sebuah Kata Adalah Subjek , Predikat , Objek atau Keterangan
    public static Character tokenRecognizer(String kata){
        if(isAccepted(kata , subjek)){
            System.out.print("s ");
            return 's';
        }
        else if(isAccepted(kata , predikat)){
            System.out.print("p ");
            return 'p';
        }
        else if(isAccepted(kata , objek)){
            System.out.print("o ");
            return 'o';
        }
        else if(isAccepted(kata , keterangan)){
            System.out.print("k ");
            return 'k';
        }
        return 'w';
    }
    
    public static boolean isAccepted(String kata , FA initialState){
            FA current = initialState;
            int i=0;
            while(current!=null && i<kata.length()){
                current = current.getNext(kata.charAt(i));
                i++;
            }
            return current !=null ? current.getIsFinal() : false;
    }
}
