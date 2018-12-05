
package tubes.tba;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FA {
    
    private String nama;
    private List<TransFA> trans;
    private boolean status;
    
    public FA(String nama,boolean status){
        this.status=status;
        this.nama=nama;
        trans=new ArrayList<>();
    }
    
    public FA(String nama){
        status=false;
        this.nama= nama;
        trans = new ArrayList<>();   
    }
    
    public String getName(){
        return nama;
    }
    
    public boolean getIsFinal(){
        return status;
    }
    
    public void addTransisi(Character input,FA next){
        trans.add(new TransFA(input , next));
    }
    public FA getNext( Character input){
      for (TransFA o : trans ){
          if(o.getInput().equals(input)){
              return o.getNext();
          }
      }
      return null;
    }
    
    public class TransFA {
    private Character input;
    private FA next;

	public TransFA(Character input, FA next) {
		this.input = input;
		this.next = next;
	}

	public Character getInput() {
		return input;
	}

	public FA getNext() {
		return next;
        }
    }
}