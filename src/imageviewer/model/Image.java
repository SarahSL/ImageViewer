package imageviewer.model;

import java.io.InputStream;

public interface Image {

    public InputStream stream();

    public Image getPrev();
    public Image getNext();
    
}
