package game;

import java.util.ArrayList;

/**
  *City définit un type de Tile.
  *Un objet City est caractérisé par un nom, un propriétaire, une population, un taux de croissance, une richesse, des Tile qui lui sont liées, des constructions ainsi que ses coordonnées x et y.
  *@see Tile
  */
public class City extends Tile {

/**
  *Le nom
  */
  private String name;
/**
  *La nation propriétaire
  *@see Nation
  */
  private Nation owner;
/**
  *La population
  */
  private double pop;
/**
  *le taux de croissance démographique
  */
  private float demography;
/**
  *La richesse
  */
  private int richness;
/**
  *Les objets Tile liés
  *@see Tile
  */
  private ArrayList<Tile> linked_tiles;
/**
  *Les constructions
  *@see Building
  */
  private ArrayList<Building> buildings;


/**
  *@param name (String) nom
  *@param owner (Nation) propriétaire
  *@param pop (int) population
  *@param richness (int) richesse
  *@param x (int) coordonnée x
  *@param y (int) coordonnée y
  *@param linked_tiles (ArrayList(Tile)) Tile liées
  *@param buildings (ArrayList(Building)) constructions
  */
  public City(String name, Nation owner, double pop, int richness, int x, int y, ArrayList<Tile> linked_tiles, ArrayList<Building> buildings) {
    super(x,y);
    this.name = name;
    this.owner = owner;
    this.pop = pop;
    this.demography = 1.2f;
    this.richness = richness;
    this.linked_tiles = new ArrayList<>();
    this.buildings = buildings = new ArrayList<>();
  }

/**
  *@param name (String) nom
  *@param owner (Nation) propriétaire
  *@param x (int) coordonnée x
  *@param y (int) coordonnée y
  *@param buildings (ArrayList(Building)) constructions
  */
  public City(String name, Nation owner, int x, int y, ArrayList<Building> buildings) {
    this(name, owner, 0.0f, 0, x, y, null, buildings);
  }

/**
  *@param name (String) nom
  *@param owner (Nation) propriétaire
  *@param x (int) coordonnée x
  *@param y (int) coordonnée y
  */
  public City(String name, Nation owner, int x, int y) {
    this(name, owner, 0.0f, 0, x, y, null, null);
  }

/**
  *Définit la Nation propriétaire en modifiant l'attribut owner
  *@param owner (Nation) propriétaire
  *@see Nation
  */
  public void setOwner(Nation owner) {
    this.owner = owner;
  }

/**
  *Calcule la nouvelle population en fonction de la population précédente et du taux de croissance démographique
  */
  public void setPop() {
    this.pop = this.pop * this.demography;
  }

/**
  *Définit le taux de croissance démographique en modifiant l'attribut demography en fonction des objets DemographicResource présents dans la liste linked_tiles, et des Building dans la liste buildings
  */
  public void setDemography() {
    for (int i = 0; i < this.linked_tiles.size(); i ++) {
      if (this.linked_tiles.get(i) instanceof DemographicResource) {
        this.demography += ((DemographicResource)this.linked_tiles.get(i)).getDemography();
      }
    }
    for (int i = 0; i < this.buildings.size(); i++) {
      if (this.buildings.get(i).getDemography() != 0) {
        this.demography += this.buildings.get(i).getDemography();
      }
    }
  }

/**
  *Définit la richesse générée par l'objet en modifiant l'attribut richness en fonction des objets RicherResource présents dans la liste linked_tiles, et des Building dans la liste buildings
  */
  public void setRichness() {
    for (int i = 0; i < this.linked_tiles.size(); i ++) {
      if (this.linked_tiles.get(i) instanceof RicherResource) {
        this.richness += ((RicherResource)this.linked_tiles.get(i)).getRichness();
      }
    }
    for (int i = 0; i < this.buildings.size(); i ++) {
      if (this.buildings.get(i).getRichness() != 0) {
        this.richness += this.buildings.get(i).getRichness();
      }
    }
  }

/**
  *Ajoute un objet Tile à la liste de Tile liées linked_tiles
  *@param tile (Tile) Tile à ajouter à la liste des Tile liées
  *@see Tile
  */
  public void addLinkedTile(ArrayList<Tile> tile_list) {
    for (int i = 0; i < tile_list.size(); i++) {
      this.linked_tiles.add(tile_list.get(i));
    }
  }

/**
  *Ajoute un objet Building à la liste de constructions buildings
  *@param building (Building) construction à ajouter à la liste des constructions
  *@see Building
  */
  public void addBuilding(Building building) {
    this.buildings.add(building);
  }

/**
  *Retourne l'attribut nom
  *@return (String) l'attribut nom
  */
  public String getName() {
    return this.name;
  }

/**
  *Retourne les coordonnées de l'objet sous forme de liste
  *@return (ArrayList(Integer)) la liste des coordonnées de l'objet
  */
  @Override
  public ArrayList<Integer> getCoord() {
    ArrayList<Integer> coord = new ArrayList<>();
    coord.add(this.x);
    coord.add(this.y);

    return coord;
  }

/**
  *Retourne le coefficient démographique
  *@return (float) le coefficient démographique
  */
  public float getDemography() {
    return this.demography;
  }

/**
  *Retourne la richesse
  *@return (int) la richesse
  */
  public int getRichness() {
    return this.richness;
  }

/**
  *Retourne les Tile liées sous forme de liste
  *@return (ArrayList(Tile)) la liste des Tile liées
  *@see Tile
  */
  public ArrayList<Tile> getLinkedTiles() {
    return this.linked_tiles;
  }

/**
  *Retourne la liste des constructions sous forme de liste
  *@return (ArrayList(Building)) la liste des constructions
  *@see Building
  */
  public ArrayList<Building> getBuildings() {
    return this.buildings;
  }

/**
  *Retourne un String qui représente l'objet
  *@return la représentation de l'objet
  */
  @Override
  public String toString() {
    return "c";
  }
}
