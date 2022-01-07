package solvers.move;

import data.Amphi;
import data.Seat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the possible move class
 */
class PossibleMoveTest {

    @Test
    /**
     * Test with no possible moves
     */
    void getMoves1() {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        listSeats.get(0).setFree(false);

        List<Seat> neighb = new ArrayList<>();
        neighb.add(listSeats.get(1));neighb.add(listSeats.get(8));

        for (Seat s : neighb)
        {
            Logger.getGlobal().info("ID : " + s.getID()
                    + " x : " + s.getX()
                    + " Y : " + s.getY()
                    + " Libre ? : " + s.isFree() );
        }
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);

        PossibleMove pm = new PossibleMove();
        List<Move> list_moves = pm.getMoves(neighb,amphi);
        Logger.getGlobal().info(list_moves.toString());
        assertEquals(0,list_moves.size());
    }

    @Test
    /**
     * Test with 1 possible moves
     */
    void getMoves2() {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        listSeats.get(0).setFree(false);

        List<Seat> neighb = new ArrayList<>();
        neighb.add(listSeats.get(1));neighb.add(listSeats.get(8));neighb.add(listSeats.get(2));

        for (Seat s : neighb)
        {
            Logger.getGlobal().info("ID : " + s.getID()
                    + " x : " + s.getX()
                    + " Y : " + s.getY()
                    + " Libre ? : " + s.isFree() );
        }
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);

        PossibleMove pm = new PossibleMove();
        List<Move> list_moves = pm.getMoves(neighb,amphi);
        Logger.getGlobal().info(list_moves.toString());
        assertEquals(1,list_moves.size());
        assertEquals(listSeats.get(2),list_moves.get(0).getSeat());
    }

    @Test
    /**
     * Test with 0 possible moves
     */
    void getMoves3() {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);

        PossibleMove pm = new PossibleMove();
        List<Move> list_moves = pm.getMoves(null,amphi);
        Logger.getGlobal().info(list_moves.toString());
        assertEquals(0,list_moves.size());
    }

    @Test
    /**
     * Test with moves that allow unload
     */
    void getUnloadMoves() {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        for (Seat s : listSeats) {
            s.setFree(false);
        }
        Amphi amphi = new Amphi(listSeats.size(), 0, listSeats);

        PossibleMove pm = new PossibleMove(true,true);
        List<Move> list_moves = pm.getMoves(amphi.getListSeat(),amphi);
        Logger.getGlobal().info(list_moves.toString());
        assertEquals(listSeats.size(),list_moves.size());
    }
    @Test
    /**
     * Test with moves that allow unload
     */
    void getUnloadMoves2() {
        Seat seat = new Seat(false);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        for (Seat s : listSeats) {
            s.setFree(false);
        }
        Amphi amphi = new Amphi(listSeats.size(), 0, listSeats);

        PossibleMove pm = new PossibleMove(false,false);
        List<Move> list_moves = pm.getMoves(amphi.getListSeat(),amphi);
        Logger.getGlobal().info(list_moves.toString());
        assertEquals(0,list_moves.size());
    }
}