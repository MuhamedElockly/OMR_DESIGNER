/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintprush.Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import paintprush.DrawPanel;
import paintprush.Shape;

/**
 *
 * @author dell
 */
public class Bantagon extends Shape {

    Color color = null;

    public void draw(Graphics g, DrawPanel draw) {

        this.color = getSelectedColor2();

        int x = Math.min(getP1().x, getP2().x);
        int y = Math.min(getP1().y, getP2().y);
        int w = Math.abs(getP1().x - getP2().x);
        int h = Math.abs(getP1().y - getP2().y);
        int r = (int) (((w) / 2) / (Math.sin(Math.toRadians(54))));
        int f = (int) ((Math.sin(Math.toRadians(72))) * r);
        int n = (int) ((f) / (Math.tan(Math.toRadians(72))));
        int m = (int) ((w / 2) / (Math.sin(Math.toRadians(54))));

        int xB[] = {x, (x + (w / 2)), x + w, ((x + w) - n), x + n};
        int yB[] = {y, y - m, y, y + f, y + f};

        g.drawPolygon(xB, yB, 5);
        g.setColor(color);
        if (isFilled()) {
            g.fillPolygon(xB, yB, 5);
        }
    }

    @Override
    public boolean isPointInsideShape(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public ArrayList<Shape> getLocalShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSVG() {
        return "";
    }

    Point p3;
    Point p4;

    @Override
    public Shape copyCompShape(int counter) {
        try {
            Shape s = (Shape) this.clone();
            p3 = new Point();
            p4 = new Point();
            p3.x = s.getP1().x;
            p3.y = s.getP1().y;
            p4.x = s.getP2().x;
            p4.y = s.getP2().y;
            p3.x += 30 * counter;
            p3.y += 30 * counter;
            p4.x += 30 * counter;
            p4.y += 30 * counter;
            s.setP1(p3);
            s.setP2(p4);

            return s;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Circle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
