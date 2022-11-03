package paintprush;

import java.util.ArrayList;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import paintprush.Shapes.Hexagon;
import paintprush.Shapes.Rectangle;
import paintprush.Shapes.Line;
import paintprush.Shapes.Oval;
import paintprush.Shapes.Traingle;
import paintprush.Shapes.Text;
import paintprush.Shapes.Hexagon;
import paintprush.Shapes.RoundRct;
import paintprush.Shapes.SmilyFace1;
import paintprush.Shapes.SmilyFace2;
import paintprush.Shapes.SmilyFace3;

public class Utility {

    public static ArrayList<Shape> loadSVG(String svgFilename, DrawPanel drawPanel) {
        ArrayList<Shape> shapes = new ArrayList<>();
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            FileInputStream inStream = new FileInputStream(svgFilename);
            Document doc = builder.parse(inStream);

            Element root = doc.getDocumentElement();

            NodeList allChildren = root.getChildNodes();

//              Element root1 = doc.getElementById("comp");
            //   int map = allChildren.item(1).getChildNodes().getLength();
            System.out.println(root.getElementsByTagName("g").item(0));
            Shape s;
            for (int i = 0; i < allChildren.getLength(); i++) {
                Node node = allChildren.item(i);
                switch (node.getNodeName()) {
                    case "line":
                        shapes.add(Line.loadSVG(node));
                        break;
                    case "rect": {
                        NamedNodeMap map = node.getAttributes();
                        Node roundRect = map.getNamedItem("class");
                        String temp = "roundRect";
                        if (roundRect != null && temp.equals(roundRect.getNodeValue())) {
                            shapes.add(RoundRct.loadSVG(node));
                        } else {
                            shapes.add(Rectangle.loadSVG(node));
                        }
                        break;
                    }
                    case "polygon":
                        shapes.add(loadPolygonShapeSVG(node));
                        break;
                    case "text":
                        shapes.add(Text.loadSVG(node, drawPanel));
                        break;
                    case "ellipse":
                        shapes.add(Oval.loadSVG(node));
                        break;
                    case "circle":
                        NamedNodeMap map = node.getAttributes();
                        Node roundRect = map.getNamedItem("class");
                        String smilyFace1 = "smilyFace1";
                        String smilyFace2 = "smilyFace2";
                        String smilyFace3 = "smilyFace3";
                        if (roundRect != null && smilyFace1.equals(roundRect.getNodeValue())) {
                            shapes.add(SmilyFace1.loadSVG(node));
                        } else if (roundRect != null && smilyFace2.equals(roundRect.getNodeValue())) {
                            shapes.add(SmilyFace2.loadSVG(node));
                        } else if (roundRect != null && smilyFace3.equals(roundRect.getNodeValue())) {
                            shapes.add(SmilyFace3.loadSVG(node));
                        }
                        break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return shapes;
    }

    public static Shape loadPolygonShapeSVG(Node node) {
        switch (node.getAttributes().getNamedItem("class").getNodeValue()) {
            case "triangle":
                return Traingle.loadSVG(node);
            case "hexagon":
                return Hexagon.loadSVG(node);
        }
        return null;
    }
}
