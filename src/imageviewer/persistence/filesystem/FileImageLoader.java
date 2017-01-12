package imageviewer.persistence.filesystem;

import imageviewer.model.Image;
import imageviewer.persistence.ImageLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;

public class FileImageLoader implements ImageLoader {
    private final File[] files;

    public FileImageLoader(String folder) {
        this.files = new File(folder).listFiles(withImageExtension());
    }

    @Override
    public Image load() {
        return imageAt(0);
    }

    private FilenameFilter withImageExtension() {
        return new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".jpg");
            }
        };
    }

    private Image imageAt(final int pos) {
        return new Image() {

            @Override
            public InputStream stream() {
                try {
                    return new FileInputStream(files[pos]);
                } catch (FileNotFoundException ex) {
                    return null;
                }
            }

            @Override
            public Image getPrev() {
                if (pos == 0) return imageAt(files.length - 1);
                return imageAt(pos - 1);
            }

            @Override
            public Image getNext() {
                if (pos == files.length - 1) return imageAt(0);
                return imageAt(pos + 1);
            }
        };
        
    }
    
}
