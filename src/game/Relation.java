package game;

import java.util.*;

/**
  *Relation permet de gérer les relations d'une nation avec les autres nations.
  *Relation est caractérisée par un attribut relations.
  *@see Nation
  */
public class Relation {

/**
  *la liste des relations
  */
  private Map<Nation,Integer> relations;

/**
  *le constructeur de la classe
  */
  public Relation() {
    this.relations = new HashMap<>();
  }

/**
  *Méthode permettant de récupérer, sous forme de Map(Nation, Integer) la liste des relations d'une nation
  *@return la liste des relations d'une nation
  *@see Nation
  */
  public Map<Nation,Integer> getRelations() {
    return this.relations;
  }

/**
  *Méthode permettant d'ajouter une relation avec une nation, ou de modifier une relation
  *@param nation (Nation) une nation
  *@param value (int) la nouvelle valeur d'une relation avec une nation
  *@see Nation
  */
  public void setRelations(Nation nation, int value) {
    this.relations.put(nation, value);
  }
}
