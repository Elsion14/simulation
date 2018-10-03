package game;

import java.util.ArrayList;

/**
  *DemographicResource définit un type de Tile.
  *Un objet RicherResource est caractérisé par un coefficient démographique et ses coordonnées x et y.
  *@see Tile
  */
public class DemographicResource extends Tile {

/**
  *le coefficient démographique
  */
  float demography;

/**
  *@param demography (float) le coefficient démographique
  *@param x (int) la coordonnée x
  *@param y (int) la coordonnée y
  */
  public DemographicResource(float demography, int x, int y) {
    super(x,y);
    this.demography = demography;
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
    return "d";
  }

/**
  *Modifie la valeur de l'attribut demography
  *@param new_demo (float) la nouvelle valeur de l'attribut demography
  */
  public void setDemography(float new_demo) {
    this.demography = new_demo;
  }

/**
  *Retourne le coefficient démographique de l'objet
  *@return le coefficient démographique
  */
  public float getDemography() {
    return this.demography;
  }
}
