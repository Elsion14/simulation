package gui;

import game.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class MapPanel extends JPanel {

  private Tile[][] map;
  private int tile_size = 15;

  public MapPanel() {

  }

  public void createGrid(double width, double height) {
    World w = new World((int) width, (int) height);
    w.generateWorld();
    this.map = w.getMap();
  }

  @Override
  public void paintComponent(Graphics g) {
    for (int i = 0; i < this.map.length; i++) {
      for (int j = 0; j < this.map[i].length; j++) {
        if (this.map[i][j] instanceof Plain) {
          g.setColor(Color.GREEN);
          g.fillRect(i*this.tile_size, j*this.tile_size, this.tile_size, this.tile_size);
        } else if (this.map[i][j] instanceof RicherResource) {
          g.setColor(Color.YELLOW);
          g.fillRect(i*this.tile_size, j*this.tile_size, this.tile_size, this.tile_size);
        } else if (this.map[i][j] instanceof DemographicResource) {
          g.setColor(Color.CYAN);
          g.fillRect(i*this.tile_size, j*this.tile_size, this.tile_size, this.tile_size);
        } else if (this.map[i][j] instanceof City) {
          g.setColor(Color.BLACK);
          g.fillRect(i*this.tile_size, j*this.tile_size, this.tile_size, this.tile_size);
        }
      }
    }
  }

  public int getTileSize() {
    return this.tile_size;
  }
}
