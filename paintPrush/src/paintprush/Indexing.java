package paintprush;

import java.util.ArrayList;

public class Indexing {

    public void bringToFront(Shape selectedShape, ArrayList<Shape> allShapes) {
        allShapes.remove(selectedShape);
        allShapes.add(selectedShape);
    }

    public void sendToBack(Shape selectedShape, ArrayList<Shape> allShapes) {
        allShapes.remove(selectedShape);
        allShapes.add(0, selectedShape);
    }
}
