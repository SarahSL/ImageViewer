package imageviewer;

import imageviewer.persistence.ImageLoader;
import imageviewer.persistence.filesystem.FileImageLoader;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        ImageLoader loader = new FileImageLoader("C:\\Users\\ENTRAR\\Pictures");
        mainFrame.imageDisplay().display(loader.load());
    }
    
}
