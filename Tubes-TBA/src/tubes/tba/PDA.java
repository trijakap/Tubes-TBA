package tubes.tba;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PDA {
    
    private String nama;
    private boolean status;
    private List<TransPDA> trans;
    
    public PDA(String nama , boolean status){
        this.nama= nama;
        trans = new ArrayList<>();
        this.status = status;
    }
    public PDA(String nama){
        this.nama= nama;
        trans = new ArrayList<>();
        status = false;   
    }
    
    public String getName(){
        return nama;
    }
    
    public boolean status(){
        return status;
    }
    
    public void addTransition(Character read,Character pop,String push,PDA state){
        trans.add(new TransPDA(read, pop, push, state));
    }
    
    public PDA getNext(Stack<Character> stack , Character read,Character pop){
        for(TransPDA trans:trans){
            if(trans.getRead().equals(read) && trans.getPop().equals(pop)){
                for(int i=trans.getPush().length()-1; i>=0;i--){
                    stack.add(trans.getPush().charAt(i));
                }
                return trans.getNext();
            }
        }
        return null;
    }
    
    
    public class TransPDA {
        private Character read;
	private Character pop;
	private String push;
	private PDA next;

	public TransPDA(Character read,Character pop, String push, PDA next) {
		this.read = read;
		this.pop = pop;
		this.push = push;
		this.next = next;
	}

	public Character getRead() {
		return read;
	}

	public Character getPop() {
		return pop;
	}

	public String getPush() {
		return push;
	}

	public PDA getNext() {
		return next;
        }
    }
    
}
