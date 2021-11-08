import java.util.List;

public class Amphi {

	private int n; //seats number
	 private int beta; //distance de sécurité
	 private List<Seat> listSeat;
	 
	public Amphi(int n, int beta, List<Seat> listSeat) {
		super();
		this.n = n;
		this.beta = beta;
		this.listSeat = listSeat;
	}
	
	public boolean isValid(){
		  for(Seat i : listSeat){
		    for(Seat j : listSeat){
		      if(i.distance(j)<beta && i.equals(j) && i.isFree() == false && j.isFree() == false){
		        return false;
		      }
		    }
		  }
		  return true;
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
	 
	
	 
	
}

