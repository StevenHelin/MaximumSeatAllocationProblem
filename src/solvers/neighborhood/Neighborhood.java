package solvers.neighborhood;

import data.Amphi;
import data.Seat;

import java.util.ArrayList;
import java.util.List;

public class Neighborhood implements NeighborhoodI
{
    Amphi A= new Amphi();
    boolean choiceNeighbor; // true = voisinage4, false = voisinage8

    public Neighborhood(Amphi a)
    {
        A = a;
    }

    public Neighborhood(Amphi a, boolean choice)
    {
        A = a;
        choiceNeighbor = choice;
    }

    public int[][] buildMatrix(Amphi A){
        int[][] matrix = new int[0][0];
        for (int i =0; i<A.getN();i++){
            for(int j=0; j<A.getN();j++){
                if(!A.getListSeat().get(i).isFree()){
                 matrix[i][j]=0;
                }
                else{
                    matrix[i][j]=1;
                }
            }

        }
        return matrix;
    }

    /**
     * Permet de récupérer un siège dans l'amphi
     * @param a Amphi
     * @param x Coordonnée x
     * @param y Coordonnée y
     * @return Un siège
     */
    public Seat findSeat(Amphi a, int x, int y)
    {
        Seat s = new Seat();
        for(int i = 0; i < a.getListSeat().size(); i++)
        {
            if(a.getListSeat().get(i).getX() == x 
                    && a.getListSeat().get(i).getY() == y)
            {
                s = a.getListSeat().get(i);
            }
        }
        return s;
    }

    /**
     * Fonction qui permet de connaitre les voisins (seulement haut-bas et gauhe-droite) d'un siège à un x et y donnés
     * @param a Amphi qui contient la liste de sièges
     * @param x Coordonnée x du siège dont on souhaite les voisins
     * @param y Coordonnée y du siège dont on souhaite les voisins
     * @return La liste des voisins
     */
    public List<Seat> neighbor4(Amphi a, int x, int y)
    {
        List<Seat> listNeighbors = new ArrayList<>();
        switch (x)
        {
            /** COIN GAUCHE **/
            case 0:
            {
                listNeighbors.add(findSeat(a, x + 50, y));
                // Coin haut-gauche
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                }
                // Coin bas-gauche
                else if(y == 525)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                // Bordure gauche
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                break;
            }
            case 270:
            {
                listNeighbors.add(findSeat(a, x + 50, y));
                // S'il n'est pas au coin bas-gauche, on ajoute le voisin se trouvant à sa gauche
                if(y != 600)
                {
                    listNeighbors.add(findSeat(a, x - 120, y));
                }
                // Coin haut-gauche
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                }
                // Coin bas-gauche
                else if(y == 600)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                // Bordure gauche
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                break;
            }
            case 490:
            {
                listNeighbors.add(findSeat(a, x + 50, y));
                // S'il n'est pas au coin bas-gauche, on ajoute le voisin se trouvant à sa gauche
                if(y != 675)
                {
                    listNeighbors.add(findSeat(a, x - 120, y));
                }
                // Coin haut-gauche
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                }
                // Coin bas-gauche
                else if(y == 675)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                // Bordure
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                break;
            }
            /** COIN GAUCHE **/

            /** COIN DROITE **/
            case 150:
            {
                listNeighbors.add(findSeat(a, x - 50, y));
                listNeighbors.add(findSeat(a, x + 120, y));
                // Coin haut-droite
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                }
                // Coin bas-droite
                else if(y == 525)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                // Bordure
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                break;
            }
            case 370:
            {
                listNeighbors.add(findSeat(a, x - 50, y));
                listNeighbors.add(findSeat(a, x + 120, y));
                // Coin haut-droite
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                }
                // Coin bas-droite
                else if(y == 600)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                // Bordure
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                break;
            }
            case 640:
            {
                listNeighbors.add(findSeat(a, x - 50, y));
                // Coin haut-droite
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                }
                // Coin bas-droite
                else if(y == 675)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                // Bordure
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                break;
            }
            /** COIN DROITE **/

            /** BORDURES **/
            case 50:
            case 100:
            case 320:
            case 540:
            case 590:
            {
                listNeighbors.add(findSeat(a, x + 50, y));
                listNeighbors.add(findSeat(a, x - 50, y));
                // Bordure du haut
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                }
                // Bordure du bas
                else if((y == 525) || (y == 600) || (y == 675))
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
                //
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                }
            }
            /** BORDURES **/
        }
        return listNeighbors;
    }

    /**
     * Fonction qui permet de connaitre les voisins (toutes directions) d'un siège à un x et y donnés
     * @param a Amphi qui contient la liste de sièges
     * @param x Coordonnée x du siège dont on souhaite les voisins
     * @param y Coordonnée y du siège dont on souhaite les voisins
     * @return La liste des voisins
     */
    public List<Seat> neighbor8(Amphi a, int x, int y)
    {
        List<Seat> listNeighbors = new ArrayList<>();
        switch (x)
        {
            /** COIN GAUCHE **/
            case 0:
            {
                listNeighbors.add(findSeat(a, x + 50, y));
                // Coin haut-gauche
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x + 50, y + 75));
                }
                // Coin bas-gauche
                else if(y == 525)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x + 50, y - 75));
                }
                // Bordure gauche
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x + 50, y + 75));
                    listNeighbors.add(findSeat(a, x + 50, y - 75));
                }
                break;
            }
            case 270:
            {
                listNeighbors.add(findSeat(a, x + 50, y));
                // S'il n'est pas au coin bas-gauche, on ajoute le voisin se trouvant à sa gauche
                if(y != 600)
                {
                    listNeighbors.add(findSeat(a, x - 120, y));
                }
                // Coin haut-gauche
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x - 120, y + 75));
                    listNeighbors.add(findSeat(a, x + 50, y + 75));
                }
                // Coin bas-gauche
                else if(y == 600)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x - 120, y - 75));
                    listNeighbors.add(findSeat(a, x + 50, y - 75));
                }
                // Bordure gauche
                else
                {
                    if(y != 525)
                    {
                        listNeighbors.add(findSeat(a, x - 120, y + 75));
                    }
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x - 120, y - 75));
                    listNeighbors.add(findSeat(a, x + 50, y - 75));
                    listNeighbors.add(findSeat(a, x + 50, y + 75));
                }
                break;
            }
            case 490:
            {
                listNeighbors.add(findSeat(a, x + 50, y));
                // S'il n'est pas au coin bas-gauche, on ajoute le voisin se trouvant à sa gauche
                if(y != 675)
                {
                    listNeighbors.add(findSeat(a, x - 120, y));
                }
                // Coin haut-gauche
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x - 120, y + 75));
                    listNeighbors.add(findSeat(a, x + 50, y + 75));
                }
                // Coin bas-gauche
                else if(y == 675)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x - 120, y - 75));
                    listNeighbors.add(findSeat(a, x + 50, y - 75));
                }
                // Bordure
                else
                {
                    if(y != 600)
                    {
                        listNeighbors.add(findSeat(a, x - 120, y + 75));
                    }
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x - 120, y - 75));
                    listNeighbors.add(findSeat(a, x + 50, y - 75));
                    listNeighbors.add(findSeat(a, x + 50, y + 75));
                }
                break;
            }
            /** COIN GAUCHE **/

            /** COIN DROITE **/
            case 150:
            {
                listNeighbors.add(findSeat(a, x - 50, y));
                listNeighbors.add(findSeat(a, x + 120, y));
                listNeighbors.add(findSeat(a, x + 120, y + 75));
                // S'il n'est pas au coin bas-droite, on ajoute le voisin se trouvant en bas à gauche
                if(y != 525)
                {
                    listNeighbors.add(findSeat(a, x - 50, y + 75));
                }
                // Coin haut-droite
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                }
                // Coin bas-droite
                else if(y == 525)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x + 120, y - 75));
                    listNeighbors.add(findSeat(a, x - 50, y - 75));
                }
                // Bordure
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x + 120, y - 75));
                    listNeighbors.add(findSeat(a, x - 50, y - 75));
                }
                break;
            }
            case 370:
            {
                listNeighbors.add(findSeat(a, x - 50, y));
                listNeighbors.add(findSeat(a, x + 120, y));
                listNeighbors.add(findSeat(a, x + 120, y + 75));
                // S'il n'est pas au coin bas-droite, on ajoute le voisin se trouvant à sa gauche
                if(y != 600)
                {
                    listNeighbors.add(findSeat(a, x - 50, y + 75));
                }
                // Coin haut-droite
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                }
                // Coin bas-droite
                else if(y == 600)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x + 120, y - 75));
                    listNeighbors.add(findSeat(a, x - 50, y - 75));
                }
                // Bordure
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x + 120, y - 75));
                    listNeighbors.add(findSeat(a, x - 50, y - 75));
                }
                break;
            }
            case 640:
            {
                listNeighbors.add(findSeat(a, x - 50, y));
                // S'il n'est pas au coin bas-droite, on ajoute le voisin se trouvant à sa gauche
                if(y != 675)
                {
                    listNeighbors.add(findSeat(a, x - 50, y + 75));
                }
                // Coin haut-droite
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                }
                // Coin bas-droite
                else if(y == 675)
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x - 50, y - 75));
                }
                // Bordure
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x + 120, y - 75));
                    listNeighbors.add(findSeat(a, x - 50, y - 75));
                }
                break;
            }
            /** COIN DROITE **/

            /** BORDURES **/
            case 50:
            case 100:
            case 320:
            case 540:
            case 590:
            {
                listNeighbors.add(findSeat(a, x + 50, y));
                listNeighbors.add(findSeat(a, x - 50, y));
                // Bordure du haut
                if(y == 0)
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x - 50, y + 75));
                    listNeighbors.add(findSeat(a, x + 50, y + 75));
                }
                // Bordure du bas
                else if((y == 525) || (y == 600) || (y == 675))
                {
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x - 50, y - 75));
                    listNeighbors.add(findSeat(a, x + 50, y - 75));
                }
                //
                else
                {
                    listNeighbors.add(findSeat(a, x, y + 75));
                    listNeighbors.add(findSeat(a, x, y - 75));
                    listNeighbors.add(findSeat(a, x - 50, y + 75));
                    listNeighbors.add(findSeat(a, x + 50, y + 75));
                    listNeighbors.add(findSeat(a, x - 50, y - 75));
                    listNeighbors.add(findSeat(a, x + 50, y - 75));
                }
            }
            /** BORDURES **/
        }
        return listNeighbors;
    }

    @Override
    public List<Seat> getNeighborhood(Amphi amphi, Seat seat) {
        this.A=amphi;
        if (this.choiceNeighbor)
        {
            return this.neighbor4(amphi,seat.getX(), seat.getY());
        }
        return this.neighbor8(amphi,seat.getX(), seat.getY());
    }
}

