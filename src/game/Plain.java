package game;

import java.util.ArrayList;

/**
  *Plain définit un type de Tile.
  *Plain est caractérisée par ses coordonées x et y.
  *Elle hérite de la classe Tile.
  *@see Tile
  */
public class Plain extends Tile {

/**
  *Constructeur
  *@param x (int) la coordonnée x
  *@param y (int) la coordonnée y
  */
  public Plain(int x, int y) {
    super(x,y);
  }

/**
  *Retourne les coordonées de l'objet sous forme de liste
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
  *Retourne un String qui représente l'objet
  *@return la représentation de l'objet
  */
  @Override
  public String toString() {
    return "_";
  }
}
