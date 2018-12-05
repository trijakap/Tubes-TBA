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
    public Character getState(String kata, FA subjek, FA predikat, FA objek, FA keterangan){
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
}
