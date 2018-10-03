package game;

import java.util.ArrayList;

/**
  *Tile est une classe permettant de créer des cases.
  *Une tile est caractérisée par ses coordonnées x et y.
  */
public abstract class Tile {

/**
  *La coordonnée x
  *@see Tile#getCoord()
  */
  protected int x;
/**
  *La coordonnée y
  *@see Tile#getCoord()
  */
  protected int y;

/**
  *Constructeur
  *@param x (int) x la coordonnée x
  *@param y (int) y la coordonnée y
  */
  public Tile(int x, int y) {
    this.x = x;
    this.y = y;
  }

/**
  *Retourne les coordonées de l'objet sous forme de liste
  *@return la liste des coordonnées de l'objet
  */
  public abstract ArrayList<Integer> getCoord();

/**
  *Retourne un String qui représente l'objet
  *@return la représentation de l'objet
  */
  public abstract String toString();
}
