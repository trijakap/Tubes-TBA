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
    
    public void addTransition(Character input,Character pop,String push,PDA state){
        trans.add(new TransPDA(input, pop, push, state));
    }
    
    public PDA getNext(Stack<Character> stack , Character input,Character pop){
        for(TransPDA trans:trans){
            if(trans.getInput().equals(input) && trans.getPop().equals(pop)){
                for(int i=trans.getPush().length()-1; i>=0;i--){
                    stack.add(trans.getPush().charAt(i));
                }
                return trans.getNext();
            }
        }
        return null;
    }
    
    
    public class TransPDA {
        private Character input;
	private Character pop;
	private String push;
	private PDA next;

	public TransPDA(Character input,Character pop, String push, PDA next) {
		this.input = input;
		this.pop = pop;
		this.push = push;
		this.next = next;
	}

	public Character getInput() {
		return input;
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
