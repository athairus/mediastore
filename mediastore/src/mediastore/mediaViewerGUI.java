
package mediastore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mediaViewerGUI extends JFrame {
    private Database db;
    private JLabel imageLabel;
    private ImageIcon image;
    
    public void init(Media m) throws java.io.IOException{
    image = db.viewCoverImage(m);
    imageLabel = new JLabel(image);
    }

}
