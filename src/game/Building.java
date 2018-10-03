package game;

/**
  *Building définit des constructions, qui peuvent être ajoutées à un objet City.
  *Un objet Building est caractérisé par un nom, un coût, une richesse et un coefficient de démographie.
  *@see City
  */
public class Building {

/**
  *Le nom
  */
  private String name;
/**
  *Le coût
  */
  private int cost;
/**
  *La richesse
  */
  private int richness;
/**
  *Le coefficient de démographie
  */
  private float demography;

/**
  *@param name (String) nom
  *@param cost (int) coût
  *@param richness (int) richesse
  *@param demography (float) coefficient de démographie
  */
  public Building(String name, int cost, int richness, float demography) {
    this.name = name;
    this.cost = cost;
    this.richness = richness;
    this.demography = demography;
  }

/**
  *@return Retourne le nom associé à l'objet
  */
  public String getName() {
    return this.name;
  }

/**
  *@return Retourne le coût
  */
  public int getCost() {
    return this.cost;
  }

/**
  *@return Retourne la richesse
  */
  public int getRichness() {
    return this.richness;
  }

/**
  *@return Retourne le coefficient de démographie
  */
  public float getDemography() {
    return this.demography;
  }

/**
  *Retourne un String qui représente l'objet
  *@return (String) la représentation de l'objet
  */
  public String toString() {
    return this.name;
  }
}
