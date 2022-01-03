package data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Contains all types of usefull functions for the Amphi class
 */
public class AmphiUtils {
    /**
     * Checks if the image named is a jpg
     * @param f
     * @return
     */
    private static boolean isNameCorrect(File f){
        String[] name = f.getName().split("\\.");
        return name[name.length - 1].trim().equals("jpg");
    }

    /**
     * Export a full view of the amphi
     * @param f : name of the file(jpg only)
     * @param amphi : amphi to see
     * @throws IOException : image cannot be created
     */
    public static boolean exportImage(File f, Amphi amphi) throws IOException {
        /* check if the name is correct */
        if(!isNameCorrect(f))return false;
        /* find the max height and width */
        List<Seat> l_seat = amphi.getListSeat();
        int width = 0,height = 0;
        for(Seat seat : l_seat){
            if(width < seat.getX())width = seat.getX();
            if(height < seat.getY())height = seat.getY();
        }
        width+=20;height+=20;
        /* picture creation */
        BufferedImage pict = new BufferedImage(width ,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = pict.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,width ,height);

        l_seat.forEach(seat->{
            /* define the color */
            if(seat.isFree())g.setColor(Color.BLACK);
            else g.setColor(Color.RED);
            g.fillRect(seat.getX() + 3,seat.getY() + 3,6,6);
        });
        /* export */
        ImageIO.write(pict,"jpg",f);
        return true;
    }
}
