package paintprush;

import paintprush.Shapes.Oval;
import paintprush.Shapes.Hebtagon;
import paintprush.Shapes.RoundRct;
import paintprush.Shapes.Hexagon;
import paintprush.Shapes.Bantagon;
import paintprush.Shapes.Rectangle;
import paintprush.Shapes.Circle;
import paintprush.Shapes.Line;
import paintprush.Shapes.Pencil;
import paintprush.Shapes.SmilyFace1;
import paintprush.Shapes.SmilyFace2;
import paintprush.Shapes.SmilyFace3;
import paintprush.Shapes.Square;
import paintprush.Shapes.Text;
import paintprush.Shapes.Traingle;

public class ShapeFactory {

    public static Shape CreateShape(ShapesEnum theShape,DrawPanel drawPanel) {
        Shape s = null;
        switch (theShape) {
            case Line:
                s = new Line();
                break;
            case Oval:
                s = new Oval();
                break;
            case Rectangle:
                s = new Rectangle();
                break;
            case Square:
                s = new Square();
                break;
            case Bentagon:
                s = new Bantagon();
                break;
            case Hexagon:
                s = new Hexagon();
                break;
            case Heptagon:
                s = new Hebtagon();
                break;
            case Triangle:
                s = new Traingle();
                break;
            case Circle:
                s = new Circle();
                break;
            case RoundRect:
                s = new RoundRct();
                break;
            case Pencil:
                s = new Pencil();
                break;
            case SmilyFace1:
                s = new SmilyFace1();
                break;
            case SmilyFace2:
                s = new SmilyFace2();
                break;
            case SmilyFace3:
                s = new SmilyFace3();
                break;
            case CompositShape:
                s = new CompositeShape(drawPanel);
                break;
            case Text:
                s = new Text(drawPanel);
                break;
        }
        return s;
    }
}
