/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.tba;

/**
 *
 * @author trijakapam
 */
public class TokenRecognizer {
    private FA subjek;
    private FA predikat;
    private FA objek;
    private FA keterangan;

    public TokenRecognizer(FA subjek, FA predikat, FA objek, FA keterangan) {
        this.subjek = subjek;
        this.predikat = predikat;
        this.objek = objek;
        this.keterangan = keterangan;
    }
    
    public Character getState(String kata){
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
        System.out.println("error");
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
