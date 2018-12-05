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
public class CreateFA {
    public CreateFA(){
        
    }
    public FA subjek(){
        FA q0 = new FA("q0");
        FA q1 = new FA("q1");
        FA q2 = new FA("q2");
        FA q3 = new FA("q3");
        FA q4 = new FA("q4");
        FA q5 = new FA("q5");
        FA q6 = new FA("q6");
        FA q7 = new FA("q7");
        FA q8 = new FA("q8");
        FA q9 = new FA("q9");
        FA q10 = new FA("q10");
        FA q11 = new FA("q11");
        FA q12 = new FA("q12");
        FA q13 = new FA("q13");
        FA q14 = new FA("q14",true);
        q0.addTransisi('m', q1);
        q1.addTransisi('e', q2);
        q2.addTransisi('r', q8);
        q8.addTransisi('e', q12);
        q13.addTransisi('k', q7);
        q0.addTransisi('d', q6);
        q6.addTransisi('i', q7);
        q0.addTransisi('s', q5);
        q5.addTransisi('a', q11);
        q11.addTransisi('y', q7);
        q0.addTransisi('a', q4);
        q4.addTransisi('n', q10);
        q10.addTransisi('d', q7);
        q0.addTransisi('k', q3);
        q3.addTransisi('a', q9);
        q9.addTransisi('m', q12);
        q12.addTransisi('i', q14);
        q7.addTransisi('a', q14);
        return q0;
    }
    public FA predikat(){
        FA q0 = new FA("q0");
        FA q1 = new FA("q1");
        FA q2 = new FA("q2");
        FA q3 = new FA("q3");
        FA q4 = new FA("q4");
        FA q6 = new FA("q6");
        FA q7 = new FA("q7");
        FA q8 = new FA("q8");
        FA q9 = new FA("q9");
        FA q10 = new FA("q10");
        FA q11 = new FA("q11");
        FA q12 = new FA("q12");
        FA q5 = new FA("q5",true);
        q0.addTransisi('m', q1);
        q1.addTransisi('i', q2);
        q2.addTransisi('n', q3);
        q3.addTransisi('u', q4);
        q4.addTransisi('m', q5);
        q1.addTransisi('a', q6);
        q6.addTransisi('i', q8);
        q6.addTransisi('k', q7);
        q7.addTransisi('a', q8);
        q8.addTransisi('n', q5);
        q6.addTransisi('s', q9);
        q9.addTransisi('a', q10);
        q10.addTransisi('k', q5);
        q6.addTransisi('n', q11);
        q11.addTransisi('d', q12);
        q12.addTransisi('i', q5);
        return q0;
    }
    public FA objek(){
        FA q0 = new FA("q0");
        FA q1 = new FA("q1");
        FA q2 = new FA("q2");
        FA q3 = new FA("q3");
        FA q4 = new FA("q4");
        FA q5 = new FA("q5");
        FA q7 = new FA("q6");
        FA q6 = new FA("q7");
        FA q8 = new FA("q8");
        FA q9 = new FA("q9");
        FA q10 = new FA("q10");
        FA q11 = new FA("q11",true);

        q0.addTransisi('a', q1);
        q1.addTransisi('i', q2);
        q2.addTransisi('r', q11);
        q0.addTransisi('s', q5);
        q5.addTransisi('u', q8);
        q8.addTransisi('p', q11);
        q0.addTransisi('k', q4);
        q4.addTransisi('o', q7);
        q7.addTransisi('p', q10);
        q10.addTransisi('i', q11);
        q0.addTransisi('b', q3);
        q3.addTransisi('a', q6);
        q6.addTransisi('s', q9);
        q9.addTransisi('o', q11);
        return q0;
    }
    public FA keterangan(){
        //di kali , di kabin , di kota , di kantin , di kampus
        FA q1 = new FA("q1");
        FA q2 = new FA("q2");
        FA q3 = new FA("q3");//
        FA q4 = new FA("q4");//
        FA q5 = new FA("q5");
        FA q6 = new FA("q6");
        FA q7 = new FA("q7");
        FA q8 = new FA("q8");
        FA q9 = new FA("q9");
        FA q10 = new FA("q10");
        FA q11 = new FA("q11");
        FA q12= new FA("q12"); //
        FA q13= new FA("q13"); 
        FA q14= new FA("q14"); 
        FA q15= new FA("q15"); 
        FA q16= new FA("q16"); 
        FA q17= new FA("q17");
        FA q18= new FA("q18");
        FA q19= new FA("q19");
        FA q20= new FA("q20");
        FA q21= new FA("q21");
        FA q22= new FA("q18",true); //


        q1.addTransisi('d', q2);     
        q2.addTransisi('i', q3);     
        q3.addTransisi(' ', q4);     
        q4.addTransisi('k', q5);
        q5.addTransisi('a', q6);
        q6.addTransisi('n', q10);
        q10.addTransisi('t', q11);
        q11.addTransisi('o', q12);
        q12.addTransisi('r', q22);
        q6.addTransisi('m', q9);
        q9.addTransisi('p', q16);
        q16.addTransisi('u', q21);
        q21.addTransisi('s', q22);
        q9.addTransisi('a', q15);
        q15.addTransisi('r', q22);
        q4.addTransisi('r', q8);
        q8.addTransisi('u', q14);
        q14.addTransisi('m', q18);
        q18.addTransisi('a', q20);
        q20.addTransisi('h', q22);
        q4.addTransisi('t', q7);
        q7.addTransisi('a', q13);
        q13.addTransisi('m', q17);
        q17.addTransisi('a', q19);
        q19.addTransisi('n', q22);
        return q1;
    }
}
