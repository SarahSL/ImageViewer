package imageviewer;

import imageviewer.ui.ImageDisplay;
import imageviewer.ui.swing.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;

    public MainFrame() {
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Image Viewer");
        add(toolbar(), BorderLayout.SOUTH);
        add(imagePanel());
        setVisible(true);
    }

    private JPanel imagePanel() {
        SwingImageDisplay panel = new SwingImageDisplay();
        imageDisplay = panel;
        return panel;
    }

    public ImageDisplay imageDisplay() {
        return imageDisplay;
    }

    private Component toolbar() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private Component prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(showPrevImage());
        return button;
    }

    private Component nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(showNextImage());
        return button;
    }

    private ActionListener showPrevImage() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                imageDisplay.display(imageDisplay.currentImage().getPrev());
            }
        };
    }

    private ActionListener showNextImage() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                imageDisplay.display(imageDisplay.currentImage().getNext());
            }
        };
    }
    
    
}
