package data;

import java.util.List;

public class Amphi {

	private int n; //seats number
	 private int beta; //distance de securite
	 private List<Seat> listSeat;
	 
	public Amphi(int n, int beta, List<Seat> listSeat) {
		this.n = n;
		this.beta = beta;
		this.listSeat = listSeat;
	}

	public Amphi() {
		this.n = n;
		this.beta = beta;
		this.listSeat = listSeat;
	}

	public boolean isValid(){
		for(Seat i : listSeat){
			for(Seat j : listSeat){
				if(i.distance(j)<beta && !i.equals(j) && i.isFree() == false && j.isFree() == false){
					return false;
				}
			}
		}
		return true;
	}
	
	public void reset() {
		for (Seat i : listSeat) {
			i.setFree(true);
		}
	}

	/**
	 * Counts the number of occupied seats in an amphitheater.
	 * @Return the number of occupied seats.
	 */
	public int occupiedSeats(){
		int occupied = 0;
		for(Seat s: listSeat){
			if(!s.isFree()){
				occupied++;
			}
		}
		return occupied;
	}
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getBeta() {
		return beta;
	}

	public void setBeta(int beta) {
		this.beta = beta;
	}

	public List<Seat> getListSeat() {
		return listSeat;
	}

	public void setListSeat(List<Seat> listSeat) {
		this.listSeat = listSeat;
	}
	 
	public void greedy(){
	    boolean occupy;
		for (Seat s1 : listSeat){
			occupy = true;
			for (Seat s2 : listSeat){
				if (!s2.isFree() && s1.distance(s2) < beta){
					occupy = false;
				}
			}
			if (occupy){
				s1.setFree(false);
			}
		}
	}
	 
	
}

