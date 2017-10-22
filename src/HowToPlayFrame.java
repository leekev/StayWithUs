import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class HowToPlayFrame extends JComponent {

    private static final long serialVersionUID = 1L;
    
    private BufferedImage howToPlay;

    
    public HowToPlayFrame() {
        try {
            this.howToPlay = ImageIO.read(new File("image.PNG"));
        } catch (IOException e) {
            System.err.println("Unable to load image.PNG");
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(howToPlay, 0, 0, howToPlay.getWidth(), howToPlay.getHeight(), null);
    }
}
