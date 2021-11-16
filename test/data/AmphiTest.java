package data;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import data.Seat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class AmphiTest {

    @Test
    void greedyNbSeats() {
        List<Seat> seatList = new ArrayList<Seat>();
        seatList.add(new Seat(1,0,0,true));
        seatList.add(new Seat(2,0,10,true));
        seatList.add(new Seat(3,10,0,true));
        seatList.add(new Seat(4,10,10,true));
        seatList.add(new Seat(5,20,0,true));
        seatList.add(new Seat(6,0,20,true));
        seatList.add(new Seat(7,20,10,true));
        seatList.add(new Seat(8,20,20,true));
        seatList.add(new Seat(9,20,20,true));
        Amphi a = new Amphi(9,100,seatList);
        a.greedy();
        assertEquals(1,a.occupiedSeats());
    }

    @Test
    void greedySolutionNbSeats() {
        List<Seat> seatList = new ArrayList<>();
        seatList.add(new Seat(1,0,0,true));
        seatList.add(new Seat(2,0,10,true));
        seatList.add(new Seat(3,10,0,true));
        seatList.add(new Seat(4,10,10,true));
        seatList.add(new Seat(5,20,0,true));
        seatList.add(new Seat(6,0,20,true));
        seatList.add(new Seat(7,20,10,true));
        seatList.add(new Seat(8,20,20,true));
        seatList.add(new Seat(9,20,20,true));
        Amphi a = new Amphi(9,100,seatList);
        a.greedySolution();
        assertEquals(1,a.occupiedSeats());
    }

    @Test
    void isValidTestFalse() {
    	int n = 99;//nombre de siege � creer
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
    
    @Test
    void isValidTestTrue() {
    	int n = 99;//nombre de siege � creer
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
    
    @Test
    void deepCopy() {
        List<Seat> seats = new ArrayList<>();
        Random r = new Random();
        for (int i = 1 ; i < 50; i++){
            seats.add(new Seat(i,i*25,i*25,r.nextBoolean()));
        }
        Amphi a1 = new Amphi(49,100,seats);
        Amphi a2 = a1.deepCopy();
        assertEquals(a1,a2);
    }
}