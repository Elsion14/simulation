package game;

import java.util.*;

/**
  *Nation permet, entre autre, de rassembler plusieurs objets City.
  *Nation est caractérisée par un nom, une population, une richesse, une liste de City et des relations.
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
  *la liste des relations, sous forme d'objet Relation
  *@see Relation
  */
  private Relation relations;


/**
  *@param name (String) le nom
  */
  public Nation(String name) {
    this.name = name;
    this.cities = new ArrayList<>();
    this.relations = new Relation();
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

/**
  *Retourne sous forme de Map(Nation,Integer) la liste des relations de la nation
  *@return sous forme de Map(Nation,Integer) la liste des relations de la nation
  */
  public Map<Nation,Integer> getRelations() {
    return this.relations.getRelations();
  }

/**
  *Méthode permettant d'ajouter une relation à l'attribut relations, en faisant appel à la méthode setRelations(Nation, int) de la classe Relation
  *@param nation (Nation) une nation
  *@param value (int) une valeur
  *@see Relation#setRelations
  */
  public void setRelations(Nation nation, int value) {
    this.relations.setRelations(nation, value);
  }
}
