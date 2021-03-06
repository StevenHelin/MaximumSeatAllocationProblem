package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	public Amphi deepCopy(){
		List<Seat> s = new ArrayList<Seat>();
		for (Seat seat : this.listSeat){
			s.add(seat.copy());
		}
		Amphi a = new Amphi(this.n,this.beta,s);
		return a;
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

	/**
	 * Fonction qui trie une liste de sièges en fonction de son ID
	 * @param s Liste de sièges à trier
	 */
	public void sortListByID(List<Seat> s)
	{
		boolean valide = false;
		while(!valide)
		{
			valide = true;
			for(int i = 0; i < s.size() - 1; i++)
			{
				if(s.get(i).getID() > s.get(i + 1).getID() )
				{
					valide = false;
					Seat sTemp;
					sTemp = s.get(i);
					s.set(i, s.get(i + 1) );
					s.set(i + 1, sTemp);
				}
			}
		}
	}

	public void greedySolution(){
		for (Seat s1 : listSeat){
			s1.setFree(false);
			if (!isValid()){
				s1.setFree(true);
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Amphi amphi = (Amphi) o;
		return n == amphi.n &&
				beta == amphi.beta &&
				Objects.equals(listSeat, amphi.listSeat);
	}

}

