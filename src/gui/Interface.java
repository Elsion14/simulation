package gui;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame {

  public Interface() {
    Container c = getContentPane();

    MapPanel map = new MapPanel();

    GridBagLayout g = new GridBagLayout();
    c.setLayout(g);
    GridBagConstraints gc = new GridBagConstraints();
    gc.fill = GridBagConstraints.BOTH;

    gc.gridx = 0;
    gc.gridy = 0;
    gc.gridwidth = 1;
    gc.gridheight = 1;
    gc.weightx = 200;
    gc.weighty = 200;

    c.add(map, gc);

    this.setTitle("Universe Simulation");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(960,810);
    this.setLocationRelativeTo(null);
    this.setVisible(true);

    int tile_size = map.getTileSize();
    double width = map.getWidth()/tile_size;
    double height = map.getHeight()/tile_size;
    map.createGrid(width, height);
    map.repaint();
  }
}
