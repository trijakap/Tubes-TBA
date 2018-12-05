/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.tba;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trijakapam
 */
public class PisahKata {
    String kalimat;
    public PisahKata (String kalimat){
        this.kalimat = kalimat;
    }
    
    public List<String> getKata(){
        int i=0;
        String a = "";
        List<String> kata = new ArrayList<>();
        
        while(i < kalimat.length()){
            if(kalimat.charAt(i) != ' '){
               a += kalimat.charAt(i);
            }else if(kalimat.charAt(i) == ' '&& !a.equals("di")){
                kata.add(a);
                a = "";
            }else if(a.equals("di")){
                a+=" ";
            }
            i++;
        }
        kata.add(a);
        
        return kata;
    }
}
