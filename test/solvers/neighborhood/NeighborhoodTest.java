package solvers.neighborhood;

import data.Seat;
import data.Amphi;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NeighborhoodTest
{
    /*----- NEIGHBOR4 ----- */
    /*----- COIN GAUCHE -----*/

    /**
     * Test de neighbor4 pour le coin en haut à gauche (secteur 1)
     */
    @Test
    void neighbor4CornerLeft1()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        Neighborhood n = new Neighborhood(amphi);
        List<Seat> listNeighbors;
        int x = 0, y = 0;
        listNeighbors = n.neighbor4(amphi, x, y);
        amphi.sortListByID(listNeighbors);
        System.out.println("Les voisins du siège x = " + x + " et y = " + y + " sont : ");
        for (Seat value : listNeighbors)
        {
            System.out.println("Siège ID " + value.getID()
                    + ", x = " + value.getX()
                    + ", y = " + value.getY());
        }

        assertEquals(y + 75, listNeighbors.get(0).getY());
        assertEquals(x + 50, listNeighbors.get(1).getX());
    }

    /**
     * Test de neighbor4 pour le coin en haut à gauche (secteur 2)
     */
    @Test
    void neighbor4CornerLeft2()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        Neighborhood n = new Neighborhood(amphi);
        List<Seat> listNeighbors;
        int x = 270, y = 0;
        listNeighbors = n.neighbor4(amphi, x, y);
        amphi.sortListByID(listNeighbors);
        System.out.println("Les voisins du siège x = " + x + " et y = " + y + " sont : ");
        for (Seat value : listNeighbors)
        {
            System.out.println("Siège ID " + value.getID()
                    + ", x = " + value.getX()
                    + ", y = " + value.getY());
        }
        assertEquals(x - 120, listNeighbors.get(0).getX());
        assertEquals(y + 75, listNeighbors.get(1).getY());
        assertEquals(x + 50, listNeighbors.get(2).getX());
    }

    /**
     * Test de neighbor4 pour le coin en haut à gauche (secteur 3)
     */
    @Test
    void neighbor4CornerLeft3()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        Neighborhood n = new Neighborhood(amphi);
        List<Seat> listNeighbors;
        int x = 490, y = 0;
        listNeighbors = n.neighbor4(amphi, x, y);
        amphi.sortListByID(listNeighbors);
        System.out.println("Les voisins du siège x = " + x + " et y = " + y + " sont : ");
        for (Seat value : listNeighbors)
        {
            System.out.println("Siège ID " + value.getID()
                    + ", x = " + value.getX()
                    + ", y = " + value.getY());
        }
        assertEquals(x - 120, listNeighbors.get(0).getX());
        assertEquals(y + 75, listNeighbors.get(1).getY());
        assertEquals(x + 50, listNeighbors.get(2).getX());
    }

    /*----- COIN GAUCHE -----*/

    /*----- COIN DROITE -----*/

    /**
     * Test de neighbor4 pour le coin en haut à droite (secteur 1)
     */
    @Test
    void neighbor4CornerRight1()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        Neighborhood n = new Neighborhood(amphi);
        List<Seat> listNeighbors;
        int x = 150, y = 0;
        listNeighbors = n.neighbor4(amphi, x, y);
        amphi.sortListByID(listNeighbors);
        System.out.println("Les voisins du siège x = " + x + " et y = " + y + " sont : ");
        for (Seat value : listNeighbors)
        {
            System.out.println("Siège ID " + value.getID()
                    + ", x = " + value.getX()
                    + ", y = " + value.getY());
        }
        assertEquals(x - 50, listNeighbors.get(0).getX());
        assertEquals(y + 75, listNeighbors.get(1).getY());
        assertEquals(x + 120, listNeighbors.get(2).getX());
    }

    /**
     * Test de neighbor4 pour le coin en haut à droite (secteur 2)
     */
    @Test
    void neighbor4CornerRight2()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        Neighborhood n = new Neighborhood(amphi);
        List<Seat> listNeighbors;
        int x = 370, y = 0;
        listNeighbors = n.neighbor4(amphi, x, y);
        amphi.sortListByID(listNeighbors);
        System.out.println("Les voisins du siège x = " + x + " et y = " + y + " sont : ");
        for (Seat value : listNeighbors)
        {
            System.out.println("Siège ID " + value.getID()
                    + ", x = " + value.getX()
                    + ", y = " + value.getY());
        }
        assertEquals(x - 50, listNeighbors.get(0).getX());
        assertEquals(y + 75, listNeighbors.get(1).getY());
        assertEquals(x + 120, listNeighbors.get(2).getX());
    }

    /**
     * Test de neighbor4 pour le coin en haut à droite (secteur 3)
     */
    @Test
    void neighbor4CornerRight3()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        Neighborhood n = new Neighborhood(amphi);
        List<Seat> listNeighbors;
        int x = 640, y = 0;
        listNeighbors = n.neighbor4(amphi, x, y);
        amphi.sortListByID(listNeighbors);
        System.out.println("Les voisins du siège x = " + x + " et y = " + y + " sont : ");
        for (Seat value : listNeighbors)
        {
            System.out.println("Siège ID " + value.getID()
                    + ", x = " + value.getX()
                    + ", y = " + value.getY());
        }
        assertEquals(x - 50, listNeighbors.get(0).getX());
        assertEquals(y + 75, listNeighbors.get(1).getY());
    }

    /*----- COIN DROITE -----*/

    /*----- BORDURE GAUCHE -----*/

    /**
     * Test de neighbor4 pour la bordure gauche
     */
    @Test
    void neighbor4BorderLeft1()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        Neighborhood n = new Neighborhood(amphi);
        List<Seat> listNeighbors;
        int x = 0, y = 225;
        listNeighbors = n.neighbor4(amphi, x, y);
        amphi.sortListByID(listNeighbors);
        System.out.println("Les voisins du siège x = " + x + " et y = " + y + " sont : ");
        for (Seat value : listNeighbors)
        {
            System.out.println("Siège ID " + value.getID()
                    + ", x = " + value.getX()
                    + ", y = " + value.getY());
        }
        assertEquals(y - 75, listNeighbors.get(0).getY());
        assertEquals(y + 75, listNeighbors.get(1).getY());
        assertEquals(x + 50, listNeighbors.get(2).getX());
    }

    /**
     * Test de neighbor4 pour la bordure gauche
     */
    @Test
    void neighbor4BorderLeft2()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        Neighborhood n = new Neighborhood(amphi);
        List<Seat> listNeighbors;
        int x = 270, y = 225;
        listNeighbors = n.neighbor4(amphi, x, y);
        amphi.sortListByID(listNeighbors);
        System.out.println("Les voisins du siège x = " + x + " et y = " + y + " sont : ");
        for (Seat value : listNeighbors)
        {
            System.out.println("Siège ID " + value.getID()
                    + ", x = " + value.getX()
                    + ", y = " + value.getY());
        }
        assertEquals(x - 120, listNeighbors.get(0).getX());
        assertEquals(y - 75, listNeighbors.get(1).getY());
        assertEquals(y + 75, listNeighbors.get(2).getY());
        assertEquals(x + 50, listNeighbors.get(3).getX());
    }

    /*----- BORDURE GAUCHE -----*/

    /*----- BORDURE DROITE -----*/

    /**
     * Test de neighbor4 pour la bordure droite
     */
    @Test
    void neighbor4BorderRight()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        Neighborhood n = new Neighborhood(amphi);
        List<Seat> listNeighbors;
        int x = 370, y = 225;
        listNeighbors = n.neighbor4(amphi, x, y);
        amphi.sortListByID(listNeighbors);
        System.out.println("Les voisins du siège x = " + x + " et y = " + y + " sont : ");
        for (Seat value : listNeighbors)
        {
            System.out.println("Siège ID " + value.getID()
                    + ", x = " + value.getX()
                    + ", y = " + value.getY());
        }
        assertEquals(y - 75, listNeighbors.get(0).getY());
        assertEquals(y + 75, listNeighbors.get(1).getY());
        assertEquals(x + 50, listNeighbors.get(2).getX());
    }

    /*----- BORDURE DROITE -----*/

    /*----- BORDURE HAUT-----*/

    /*----- BORDURE HAUT-----*/


    @Test
    void neighbor8()
    {

    }
}