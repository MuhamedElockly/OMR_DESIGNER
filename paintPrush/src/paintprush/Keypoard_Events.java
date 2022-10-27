package paintprush;

import java.awt.KeyEventPostProcessor;
import java.awt.event.KeyEvent;

public class Keypoard_Events implements KeyEventPostProcessor {
    
    DrawPanel draw;
    
    public Keypoard_Events(DrawPanel drawPanel) {
        draw = drawPanel;
    }
    
    @Override
    public boolean postProcessKeyEvent(KeyEvent e) {
        
        if (e.isControlDown() && !e.isShiftDown()) {
            // if (e.getID() == KeyEvent.KEY_RELEASED) {
            draw.setCtrButton(true);
            
            if (e.getKeyCode() == KeyEvent.VK_C) {
                if (e.getID() == KeyEvent.KEY_RELEASED) {
                    
                    if (draw.selectedShapesIndex.size() > 0) {
                        draw.copyFromSelectedShapesToArray();
                    }
                }
                return true;
                
            } else if (e.getKeyCode() == KeyEvent.VK_V) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    if (draw.lastCopy.size() > 0) {
                        draw.copyFromArrayToShapes();
                        draw.copyHistory();
                        draw.repaint();
                    }
                }
                return true;
                
            } else if (e.getKeyCode() == KeyEvent.VK_A) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    draw.setCtrButton(true);
                    for (int i = 0; i < draw.allShapes.size(); i++) {
                        if (!draw.allShapes.get(i).isSelected()) {
                            draw.allShapes.get(i).setSelected(true);
                            draw.selectedShapesIndex.add(draw.allShapes.get(i));
                        }
                    }
                }
                draw.repaint();
                return true;
                
            } else if (e.getKeyCode() == KeyEvent.VK_Z) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    if (draw.indexOfBack >= 1) {
                        draw.indexOfBack--;
                        draw.allShapes.clear();
                        draw.allShapes.addAll(draw.back.get(draw.indexOfBack));
                        draw.deSelectAllShapes();
                        draw.reSetSelectedIndex();
                        draw.repaint();
                    } else {
                        draw.indexOfBack = -1;
                        draw.allShapes.clear();
                    }
                }
                draw.repaint();
                return true;
            }
        } else if (e.isControlDown()
                && e.isShiftDown()) {
            if (e.getKeyCode() == KeyEvent.VK_Z && draw.indexOfBack < draw.back.size() - 1) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    draw.indexOfBack++;
                    draw.allShapes.clear();
                    draw.allShapes.addAll(draw.back.get(draw.indexOfBack));
                    draw.deSelectAllShapes();
                    draw.reSetSelectedIndex();
                    draw.repaint();
                }
            }
            draw.repaint();
            return true;
            
        } else if (e.isShiftDown()) {
            draw.setShiftButton(true);
        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            draw.setShiftButton(false);
            draw.setCtrButton(false);
        } else if (e.getKeyCode()
                == KeyEvent.VK_BACK_SPACE) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                
                draw.deleteShape();
            }
            draw.repaint();
            return true;
        } else if (e.getKeyCode()
                == KeyEvent.VK_RIGHT) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (draw.getSelectedShape() != null) {
                    draw.getSelectedShape().moveShapeBy(1, 0);
                    draw.propertiesPanel.setAllProperties(draw.getSelectedShape().getAllProperties());
                    draw.repaint();
                }
            }
            return true;
        } else if (e.getKeyCode()
                == KeyEvent.VK_LEFT) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (draw.getSelectedShape() != null) {
                    draw.getSelectedShape().moveShapeBy(-1, 0);
                    draw.propertiesPanel.setAllProperties(draw.getSelectedShape().getAllProperties());
                    draw.repaint();
                }
            }
            return true;
        } else if (e.getKeyCode()
                == KeyEvent.VK_UP) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (draw.getSelectedShape() != null) {
                    draw.getSelectedShape().moveShapeBy(0, -1);
                    draw.propertiesPanel.setAllProperties(draw.getSelectedShape().getAllProperties());
                    draw.repaint();
                }
            }
            return true;
        } else if (e.getKeyCode()
                == KeyEvent.VK_DOWN) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (draw.getSelectedShape() != null) {
                    draw.getSelectedShape().moveShapeBy(0, 1);
                    draw.propertiesPanel.setAllProperties(draw.getSelectedShape().getAllProperties());
                    draw.repaint();
                }
            }
            return true;
        } else {
            draw.setCtrButton(false);
            return true;
        }
        return true;
    }
    
}
