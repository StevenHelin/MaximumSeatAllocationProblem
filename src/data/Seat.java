package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Seat
{
    private int ID;         // Identifiant du siège
    private int x;          // Coordonnée x du siège
    private int y;          // Coordonnée y du siège
    private boolean free;   // Siège libre ou non

    public Seat()
    {

    }

    public Seat(boolean free)
    {
        this.free = free;
    }

    public Seat(int ID, int x, int y, boolean free) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.free = free;
    }

    /**
     * Lecture d'un fichier .txt "seat" pour ajouter
     * les sièges dans une liste de sièges
     * @param listSeats liste des sièges
     */
    public void loadSeat(ArrayList<Seat> listSeats)
    {
        try
        {
            // Chemin du fichier texte, à changer par rapport à vous !!
            File myObj = new File("seat.txt");
            Scanner myReader = new Scanner(myObj);
            // Permet de skipper la 1ère ligne qui contient les en-têtes
            String data = myReader.nextLine();
            while (myReader.hasNextLine() )
            {
                Seat seat = new Seat(true);
                data = myReader.nextLine();
                String[] temp = data.split("\\s+");
                seat.setID(Integer.parseInt(temp[0]));
                seat.setX(Integer.parseInt(temp[1]));
                seat.setY(Integer.parseInt(temp[2]));
                listSeats.add(seat);
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Computes the Euclidian distance between the current seat and another one.
     * @param j : the other seat with which we want to compute the distance.
     * @return the distance between the two seats.
     */
    public double distance(Seat j){
        return Math.sqrt(Math.pow(this.getX() - j.getX(), 2) + Math.pow(this.getY() - j.getY(), 2));
    }

    /**
     * GETTERS
     */

    public int getID() {
        return ID;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isFree() {
        return free;
    }

    /**
     * SETTERS
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFree(boolean free) {
        this.free = free;
    }


    public Seat copy() {
        Seat s = new Seat(true);
        s.setFree(this.isFree());
        s.setID(this.getID());
        s.setX(this.getX());
        s.setY(this.getY());
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return ID == seat.ID &&
                x == seat.x &&
                y == seat.y &&
                free == seat.free;
    }
}
