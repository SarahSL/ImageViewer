package imageviewer.ui.swing;

import imageviewer.model.Image;
import imageviewer.ui.ImageDisplay;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image image;

    @Override
    public void display(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(toSwing(image), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    private BufferedImage toSwing(Image image) {
        try {
            return ImageIO.read(image.stream());
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public Image currentImage() {
        return image;
    }
    
    
    
}
