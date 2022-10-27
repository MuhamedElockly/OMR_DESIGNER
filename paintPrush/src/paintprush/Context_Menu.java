package paintprush;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.ComboBox;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.MenuEvent;
import paintprush.Shapes.Text;

public class Context_Menu {

    DrawPanel draw;

    public Context_Menu(DrawPanel drawPanel, int x, int y) {
        draw = drawPanel;
        setMenue(drawPanel, x, y);
    }
    Alligment alligment;
    Indexing indexing;

    public void setMenue(DrawPanel d, int x, int y) {

        JPopupMenu menu = new JPopupMenu();

        JMenu Alligment = new JMenu("Alligment");

        JMenuItem delete = new JMenuItem("Delete");
        delete.addActionListener(deleteAction);

        JMenuItem group = new JMenuItem("Group");
        group.addActionListener(this.group);

        JMenuItem leftAlligment = new JMenuItem("Left-Alligment");
        leftAlligment.addActionListener(this.leftAlligement);

        JMenuItem topAlligment = new JMenuItem("Top-Alligment");
        topAlligment.addActionListener(this.topAlligement);

        JMenuItem unGroup = new JMenuItem("Un Group");
        unGroup.addActionListener(this.unGroup);

        JMenuItem horizontalCenter = new JMenuItem("Distribute-Horizontally");
        horizontalCenter.addActionListener(this.horizentalDistripute);

        JMenuItem verticalCenter = new JMenuItem("Distribute Vertically");
        verticalCenter.addActionListener(this.verticalDistripute);

        JMenuItem bringToFront = new JMenuItem("Bring To Front");
        bringToFront.addActionListener(this.bringToFront);

        JMenuItem editText = new JMenuItem("Edit Text");
        editText.addActionListener(this.editText);

        JMenuItem sendToBack = new JMenuItem("Send To Back");
        sendToBack.addActionListener(this.sendToBack);
        menu.add(delete);
        if (draw.selectedShapesIndex.size() == 1 && draw.getSelectedShape() instanceof Text) {
            menu.add(editText);
        }

        if (draw.allShapes.size() > 1 && draw.selectedShapesIndex.size() == 1) {
            if (draw.allShapes.indexOf(draw.getSelectedShape()) < draw.allShapes.size() - 1) {
                if (draw.allShapes.indexOf(draw.getSelectedShape()) != 0) {
                    menu.add(sendToBack);
                    menu.add(bringToFront);
                } else {
                    menu.add(bringToFront);
                }
            } else {
                menu.add(sendToBack);
            }
        }
        if (draw.selectedShapesIndex.size() > 1 || draw.isGroup() == true) {
            if (draw.selectedShapesIndex.size() > 1) {
                if (draw.selectedShapesIndex.size() > 2) {
                    Alligment.add(horizontalCenter);
                    Alligment.add(verticalCenter);
                }
                Alligment.add(topAlligment);
                Alligment.add(leftAlligment);
                menu.add(Alligment);
            }
            menu.add(group);
        }
        if (draw.selectedShapesIndex.size() == 1 && draw.selectedShapesIndex.get(0) instanceof CompositeShape) {

            menu.add(unGroup);
        }
        menu.show(draw, x + draw.x_offScreen, y + draw.y_offScreen);
    }

    private ActionListener sendToBack = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            indexing = new Indexing();
            indexing.sendToBack(draw.getSelectedShape(), draw.allShapes);
            draw.copyHistory();
            draw.repaint();
        }
    };
    private ActionListener deleteAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            draw.deleteShape();
            draw.repaint();
        }
    };
    private ActionListener bringToFront = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            indexing = new Indexing();
            indexing.bringToFront(draw.getSelectedShape(), draw.allShapes);
            draw.copyHistory();
            draw.repaint();
        }
    };
    private ActionListener group = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            draw.deSelectAllShapes();
            Shape compShape = ShapeFactory.CreateShape(ShapesEnum.CompositShape,draw);
            draw.sortingSelectedShapes();
            ((CompositeShape) compShape).addShapes(draw.selectedShapesIndex);
            draw.allShapes.removeAll(draw.selectedShapesIndex);
            draw.allShapes.add(compShape);
            compShape.setSelected(true);
            draw.reSetSelectedIndex();
            draw.deSelectAllShapes();
            draw.copyHistory();
            draw.repaint();
        }
    };
    private ActionListener unGroup = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            CompositeShape cShape = (CompositeShape) draw.selectedShapesIndex.get(0);
            draw.allShapes.remove(draw.selectedShapesIndex.get(0));
            draw.allShapes.addAll(cShape.getLocalShape());
            draw.copyHistory();
            draw.repaint();
        }
    };
    private ActionListener leftAlligement = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            alligment = new Alligment();
            alligment.setAlligment(true, draw.selectedShapesIndex);
            draw.copyHistory();
            draw.repaint();
        }
    };
    private ActionListener topAlligement = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            alligment = new Alligment();
            alligment.setAlligment(false, draw.selectedShapesIndex);
            draw.copyHistory();
            draw.repaint();
        }
    };
    private ActionListener verticalDistripute = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            alligment = new Alligment();
            alligment.setCenter(false, draw.selectedShapesIndex);
            draw.copyHistory();
            draw.repaint();
        }
    };
    private ActionListener horizentalDistripute = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            alligment = new Alligment();
            alligment.setCenter(true, draw.selectedShapesIndex);
            draw.copyHistory();
            draw.repaint();
        }
    };
    Shape s;
    String temp;
    private ActionListener editText = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            s = draw.getSelectedShape();
            draw.reSetSelectedIndex();
            draw.deSelectAllShapes();
            temp = ((Text) s).getText();
            String text = JOptionPane.showInputDialog("Write The Text ");
            if (text == null || text.isEmpty()) {
                ((Text) s).setText(temp);
            } else {
                ((Text) s).setText(text);
            }
            draw.repaint();
        }
    };
}
