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
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        amphi.greedy();
        amphi.greedySolution();

    }
}
