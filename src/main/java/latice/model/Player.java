package latice.model;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	private final String name;
	private final ArrayList<Tile> rack;
	private final ArrayList<Tile> stack;
	private Integer point;
	private Boolean ptsFree;
	
	public Player(String name, ArrayList<Tile> rack, ArrayList<Tile> stack, Integer point) {
		this.name = name;
		this.rack = rack;
		this.stack = stack;
		this.point = point;
	}
	
    public void fillRack() {
        
    	Collections.shuffle(this.stack);
    	
        for (int i = 0; i<rack.size(); i++) {
        	
        	if(this.rack.get(i) == null && this.stack.size()>0) {
        		this.rack.set(i, this.stack.get(0));
        		this.stack.remove(0);
        	}  
        }
    }

    //TODO refaire methode
    public void clearRack(){
            for (int i = rack.size(); i>0; i--) {
                if (rack.size()!=0) {
                    stack.add(rack.get(i-1));
                    rack.remove(i-1);
            }
        }

    }

	public String getName() {
		return name;
	}

	public ArrayList<Tile> getRack() {
		return rack;
	}

	public ArrayList<Tile> getStack() {
		return stack;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Boolean getPtsFree() {
		return ptsFree;
	}

	public void setPtsFree(Boolean ptsFree) {
		this.ptsFree = ptsFree;
	}

}


