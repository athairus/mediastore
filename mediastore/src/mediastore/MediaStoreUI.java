package mediastore;

import java.awt.*;
import javax.swing.*;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.GraphiteAquaSkin;

/**
 * Name: Milton John
 * Section: 1
 * Program: Lab
 * Date: Mar 20, 2013
 */
/**
 * A class that
 *
 * @author Milton John
 * @version 1.0 Mar 20, 2013
 *
 */
public class MediaStoreUI {

    private static final int defaultWidth = 800;                      //width of JFrame
    private static final int defaultHeight = 480;                     //height of JFrame
    
    public static void main( String[] args ) {

        Runnable r = new Runnable() {
            @Override
            @SuppressWarnings( "CallToThreadDumpStack" )
            public void run() { // Substance (the look and feel theme this program uses) refuses to run unless the frame is created in this manner
                try {
                    SubstanceLookAndFeel.setSkin( new GraphiteAquaSkin() );
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
                JFrame frame = new WelcomeWindow();
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.setSize( defaultWidth, defaultHeight );
                frame.setMinimumSize( new Dimension( defaultWidth, defaultHeight ) );
                frame.pack();
                frame.setVisible( true );



            }
        };
        EventQueue.invokeLater( r );
    }
}
