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
    }
}
