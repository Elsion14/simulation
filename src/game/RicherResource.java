package game;

import java.util.ArrayList;

/**
  *RicherResource définit un type de Tile.
  *Un objet RicherResource est caractérisé par une richesse et ses coordonnées x et y.
  *@see Tile
  */
public class RicherResource extends Tile {

/**
  *La richesse
  */
  private int richness;

/**
  *@param richness la richesse
  *@param x la coordonnée x
  *@param y la coordonnée y
  */
  public RicherResource(int richness, int x, int y) {
    super(x,y);
    this.richness = richness;
  }

/**
  *Retourne les coordonnées de l'objet sous forme de liste
  *@return la liste des coordonnées de l'objet
  */
  @Override
  public ArrayList<Integer> getCoord() {
    ArrayList<Integer> coord = new ArrayList<>();
    coord.add(x);
    coord.add(y);

    return coord;
  }

/**
  *Retourne un String représentant l'objet
  *@return la représentation de l'objet
  */
  @Override
  public String toString() {
    return "r";
  }

/**
  *Modifie la valeur de l'attribut richness
  *@param richness (int) la nouvelle valeur de l'attribut richness
  */
  public void setRichness(int richness) {
    this.richness = richness;
  }

  /**
    *Retourne la richesse de l'objet
    *@return la richesse
    */
  public int getRichness() {
    return this.richness;
  }
}
