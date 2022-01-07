package solvers;

import data.Amphi;
import data.Seat;
import org.junit.jupiter.api.Test;
import solvers.move.PossibleMove;
import solvers.neighborhood.Neighborhood;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TabouTest
{
    @Test
    void solve()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 0, listSeats);
        Amphi tabouAmphi = new Amphi();
        Tabou tabou = new Tabou(new PossibleMove(),new Neighborhood(amphi,true),100, Tabou.MoveChoice.DEFAULT, Tabou.StopChoice.ITERATION, tabouAmphi);
        //amphi.greedySolution();
        amphi = tabou.solve(amphi);
        System.out.println("valide? : " + amphi.isValid() + " nb sieges occupés : " + amphi.occupiedSeats());
        for (Seat s : amphi.getListSeat())
        {
            if (!s.isFree()) {
                System.out.println("ID : " + s.getID()
                        + " x : " + s.getX()
                        + " Y : " + s.getY()
                        + " Libre ? : " + s.isFree());
            }
        }
        assertTrue(amphi.occupiedSeats()>0);
        assertTrue(amphi.isValid());
    }
}