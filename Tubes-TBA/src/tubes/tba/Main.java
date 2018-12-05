package tubes.tba;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static FA subjek;
    public static FA predikat;
    public static FA objek;
    public static FA keterangan;
    private static CreateFA createFA = new CreateFA();
    public static void main(String[] args) {
        
        System.out.println("Masukan Sebuah Kalimat");
        System.out.println("!! WAJIB HURUF KECIL !!");
        System.out.print("kalimat: ");
        Scanner scanner = new Scanner( System.in );
        String kalimat = scanner.nextLine();
        
        PisahKata pisah = new PisahKata(kalimat);
        List<String> kata = pisah.getKata();  
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
        
        subjek = createFA.subjek();
        predikat = createFA.predikat();
        objek = createFA.objek();
        keterangan = createFA.keterangan();
        TokenRecognizer token = new TokenRecognizer(subjek,predikat,objek,keterangan);

        PDA current = init;
        current = current.getNext(stack, '-', '-');
        current = current.getNext(stack, '-', stack.pop());
        
        System.out.print("Susunan kata: ");
        int i = 0;
        while(current!= null && i<kata.size()){
            current = current.getNext(stack, token.getState(kata.get(i)), stack.pop());
            i++;
        }
        
        while(current != null && !stack.isEmpty()){
            current = current.getNext(stack, '-', stack.pop()); 
        }

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
}
