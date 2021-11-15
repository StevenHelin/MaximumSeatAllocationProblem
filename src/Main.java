import data.Amphi;
import data.Seat;
import solvers.neighborhood.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        /*
         for (Seat s : listSeats)
         {
         System.out.println("ID : " + s.getID()
         + " x : " + s.getX()
         + " Y : " + s.getY()
         + " Libre ? : " + s.isFree() );
         }
         */
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        amphi.greedy();
        /*
        System.out.println("valide? : " + amphi.isValid() + " nb sieges occupés : " + amphi.occupiedSeats());
        for (Seat s : amphi.getListSeat()) {
            System.out.println("ID : " + s.getID()
                    + " x : " + s.getX()
                    + " Y : " + s.getY()
                    + " Libre ? : " + s.isFree());
        }
        */
        Neighborhood n = new Neighborhood(amphi);
        List<Seat> listNeighbor;
        int x = 270, y = 525;
        listNeighbor = n.neighbor8(amphi, x, y);
        amphi.sortList(listNeighbor);
        System.out.println("Les voisins du siège x = " + x + " et y = " + y + " sont : ");
        for (Seat value : listNeighbor)
        {
            System.out.println("Siège ID " + value.getID()
                    + ", x = " + value.getX()
                    + ", y = " + value.getY());
        }

    }
}
