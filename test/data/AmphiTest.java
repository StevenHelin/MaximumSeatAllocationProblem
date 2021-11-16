package data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class AmphiTest {

    @org.junit.jupiter.api.Test
    void greedy() {
    }

    @org.junit.jupiter.api.Test
    void greedySolution() {
    }
    
    @org.junit.jupiter.api.Test
    void isValidTestFalse() {
    	int n = 99;//nombre de siege à creer
    	int rang=1; //compte les rang
    	int x=0;
    	int y=0;
    	int id=1;
    	boolean free = false;
    	List<Seat> listSeat = new ArrayList<Seat>();
    	int i;
    	for (i=0; i<n; i++) {
    		Seat s = new Seat(id, x, y, free);
    		id=id+1;
    		if(rang==8) {
    			rang=0;
    			x=x+50;
    			y=0;
    		}
    		else {
    			rang=rang+1;
    			y=y+75;
    		}
    		listSeat.add(s);
    	}
    	Amphi a = new Amphi(n, 100, listSeat);
    	
    	assertFalse(a.isValid());
    }
    
    @org.junit.jupiter.api.Test
    void isValidTestTrue() {
    	int n = 99;//nombre de siege à creer
    	int rang=1; //compte les rang
    	int x=0;
    	int y=0;
    	int id=1;
    	boolean free = true;
    	List<Seat> listSeat = new ArrayList<Seat>();
    	int i;
    	for (i=0; i<n; i++) {
    		Seat s = new Seat(id, x, y, free);
    		id=id+1;
    		if(rang==8) {
    			rang=0;
    			x=x+50;
    			y=0;
    		}
    		else {
    			rang=rang+1;
    			y=y+75;
    		}
    		listSeat.add(s);
    	}
    	Amphi a = new Amphi(n, 100, listSeat);
    	
    	assertTrue(a.isValid());
    }
    
    
}