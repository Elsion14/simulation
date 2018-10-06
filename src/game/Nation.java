package game;

import java.util.ArrayList;

/**
  *Nation permet, entre autre, de rassembler plusieurs objets City.
  *Nation est caractérisée par un nom, une population, une richesse et une liste de City.
  *@see City
  */
public class Nation {

/**
  *le nom
  */
  private String name;
/**
  *la population
  */
  private double pop;
/**
  *la richesse
  */
  private int richness;
/**
  *la liste des City
  */
  private ArrayList<City> cities;


/**
  *@param name (String) le nom
  */
  public Nation(String name) {
    this.name = name;
    this.cities = new ArrayList<>();
  }

/**
  *Permet d'ajouter un objet City à la liste des objets City liés à l'objet
  *@param city (City) l'objet City à ajouter
  */
  public void addCity(City city) {
    this.cities.add(city);
  }

/**
  *Retourne le nom de l'objet
  *@return le nom
  */
  public String getName() {
    return this.name;
  }

/**
  *Retourne la liste des objets City liés à l'objet
  *@return la liste cities
  */
  public ArrayList<City> getCities() {
    return this.cities;
  }
}
