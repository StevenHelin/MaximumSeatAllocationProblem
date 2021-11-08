import data.Amphi;
import data.Seat;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        for (Seat s : listSeats)
        {
            System.out.println("ID : " + s.getID()
                    + " x : " + s.getX()
                    + " Y : " + s.getY()
                    + " Libre ? : " + s.isFree() );
        }
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        amphi.greedy();
        System.out.println("valide? : " + amphi.isValid() + " nb sieges occupés : " + amphi.occupiedSeats());
        for (Seat s : amphi.getListSeat())
        {
            System.out.println("ID : " + s.getID()
                    + " x : " + s.getX()
                    + " Y : " + s.getY()
                    + " Libre ? : " + s.isFree() );
        }
    }
}
