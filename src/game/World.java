package game;

import java.util.*;

/**
  *World permet de générer puis de gérer une grille de Tile de dimension 2.
  *Un objet World est caractérisé par une largeur, une hauteur, un nombre d'objet DemographicResource, un nombre d'objet RicherResource et une grille d'objet Tile.
  *@see Tile
  *@see DemographicResource
  *@see RicherResource
  */
public class World {

/**
  *la largeur de la grille
  */
  private int width;
/**
  *la hauteur de la grille
  */
  private int height;
/**
  *le nombre d'objet DemographicResource dans la grille
  */
  private int nb_r_resources = 10;
/**
  *le nombre d'objet RicherResource dans la grille
  */
  private int nb_d_resources = 10;
/**
  *la grille d'objet Tile
  */
  private Tile[][] map;

/**
  *la liste de tous les objets City dans la grille
  */
  private ArrayList<City> world_cities;

/**
  *Constructeur qui initialise une grille de type Tile[][] de taille width*height
  *@param width la largeur de la grille
  *@param height la hauteur de la grille
  */
  public World(int width, int height) {
    this.width = width;
    this.height = height;
    this.map = new Tile[this.width][this.height];
    this.world_cities = new ArrayList<>();
  }

/**
  *Méthode permettant de générer le contenu de la grille, la remplissant d'objet Plain, puis d'y ajouter de façon aléatoire des objets DemographicResource et RicherResource
  *@see Plain
  *@see DemographicResource
  *@see RicherResource
  */
  public void generateWorld() {
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        Tile tile = new Plain(i,j);
        this.map[i][j] = tile;
      }
    }
    Random r = new Random();
    for (int i = 0; i < this.nb_r_resources; i++) {
      int x_r_resource = r.nextInt(this.width);
      int y_r_resource = r.nextInt(this.height);

      while (!(this.map[x_r_resource][y_r_resource] instanceof Plain)) {
        x_r_resource = r.nextInt(this.width);
        y_r_resource = r.nextInt(this.height);
      }
      this.map[x_r_resource][y_r_resource] = new RicherResource(5,x_r_resource,y_r_resource);
    }
    for (int d = 0; d < this.nb_d_resources; d++) {
      int x_d_resource = r.nextInt(this.width);
      int y_d_resource = r.nextInt(this.height);

      while (!(this.map[x_d_resource][y_d_resource] instanceof Plain)) {
        x_d_resource = r.nextInt(this.width);
        y_d_resource = r.nextInt(this.height);
      }
      this.map[x_d_resource][y_d_resource] = new DemographicResource(0.2f,x_d_resource,y_d_resource);
    }
  }

/**
  *Méthode permettant de récupérer toutes les cases (Tile) voisines de celle ayan pour coordonnées (x,y), et de retourner une liste de ces cases
  *@param x (int) coordonnée x
  *@param y (int) coordonnée y
  *@return la liste des objets Tile voisins de la case de coordonnées (x,y)
  *@see Tile
  */
  public ArrayList<Tile> consvois(int x, int y) {
    ArrayList<Tile> voisins = new ArrayList<>();
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if ((x+i >= 0 && x+i < this.width) && (y+j >= 0 && y+j < this.height)) {
          voisins.add(this.map[x+i][y+j]);
        }
      }
    }
    return voisins;
  }

  /*======PAS UTILISé POUR L'INSTANT
  public ArrayList<Tile> consvois2(int x, int y) {
    ArrayList<Tile> res = new ArrayList<>();
    for (int i = -2; i < 3; i++) {
      for (int j = -2; j < 3; j++) {
        if ((x+i >= 0 && x+i < this.width) && (y+j >= 0 && y+j < this.height)) {
          res.add(this.map[x+i][y+j]);
        }
      }
    }
    return res;
  }*/

/**
  *Méthode permettant de tester si un objet City récemment ajouté a des Tile en conflit avec tous les autres objets City (attribut linkedTiles) présents dans l'attribut world_cities
  *@param c (City) l'objet City sur lequel faire le test
  *@return un booléen qui vaut true si il y a conflit, false sinon
  *@see City
  */
  public boolean tilesInConflict(City c) {
    ArrayList<Tile> c_linkedTiles = consvois(c.getCoord().get(0), c.getCoord().get(1));
    if (this.world_cities != null) {
      for (City w_city : this.world_cities) {
        for (Tile w_city_tile : w_city.getLinkedTiles()) {
          for (Tile c_linkedTile : c_linkedTiles) {
            if (w_city_tile.getCoord().equals(c_linkedTile.getCoord())) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

/**
  *Méthode permettant d'ajouter un objet City dans la grille et de le retourner
  *@param name (String) le nom
  *@param owner (Nation) le propriétaire
  *@param pop (double) la population
  *@param richness (int) la richesse
  *@param x_city (int) la coordonnée en x
  *@param y_city (int) la coordonnée en y
  *@param linked_tiles (ArrayList(Tile)) la liste des objets Tile liées à l'objet City
  *@param buildings (ArrayList(Building)) la liste des objets Building de l'objet City
  *@return l'objet City créé
  *@see City
  *@see Nation
  *@see Tile
  *@see Building
  */
  public City addCity(String name, Nation owner, double pop, int richness, int x_city, int y_city, ArrayList<Tile> linked_tiles, ArrayList<Building> buildings) {
    City c = new City(name, owner, pop, richness, x_city, y_city, linked_tiles, buildings);
    if (tilesInConflict(c)) {
      return null;
    }
    this.map[x_city][y_city] = c;
    this.world_cities.add(c);
    return c;
  }

/**
  *Méthode permettant d'ajouter un objet City dans la grille, en faisant appel à la méthode addCity() ayant 8 arguments et de le retourner
  *@param name (String) le nom
  *@param owner (Nation) le propriétaire
  *@param pop (double) la population
  *@param richness (int) la richesse
  *@return l'objet City créé
  *@see City
  *@see Nation
  */
  public City addCity(String name, Nation owner, double pop, int richness) {
    Random r = new Random();
    int x_city = r.nextInt(this.width);
    int y_city = r.nextInt(this.height);

    while (!(this.map[x_city][y_city] instanceof Plain)) {
      x_city = r.nextInt(this.width);
      y_city = r.nextInt(this.height);
    }
    City c = this.addCity(name, owner, pop, richness, x_city, y_city, null, null);
    return c;
  }

/**
  *Méthode permettant d'ajouter un objet City dans la grille, en faisant appel à la méthode addCity() ayant 8 arguments et de le retourner
  *@param name (String) le nom
  *@param pop (double) la population
  *@param richness (int) la richesse
  *@return l'objet City créé
  *@see City
  */
  public City addCity(String name, double pop, int richness) {
    Random r = new Random();
    int x_city = r.nextInt(this.width);
    int y_city = r.nextInt(this.height);

    while (!(this.map[x_city][y_city] instanceof Plain)) {
      x_city = r.nextInt(this.width);
      y_city = r.nextInt(this.height);
    }
    City c = this.addCity(name, null, pop, richness, x_city, y_city, null, null);
    return c;
  }

/**
  *Retourne une représentation de la grille en caractères
  *@return la représentation de la grille
  *@see Plain#toString()
  *@see City#toString()
  *@see DemographicResource#toString()
  *@see RicherResource#toString()
  */
  public String toString() {
    String res = "";

    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        if (this.map[i][j] != null) {
          res += this.map[i][j].toString() + " ";
        }
      }
      res += "\n";
    }
    return res;
  }

/**
  *Retourne la grille sous forme de tableau de Tile à deux dimensions
  *@return un tableau de type Tile[][]
  *@see Tile
  */
  public Tile[][] getMap() {
    return this.map;
  }

/**
  *Retourne la largeur de la grille
  *@return la largeur de la grille
  */
  public int getWidth() {
    return this.width;
  }

/**
  *Retourne la hauteur de la grille
  *@return la hauteur de la grille
  */
  public int getHeight() {
    return this.height;
  }

/**
  *Retourne un tableau de type int[] contenant la largeur et la hauteur de la grille
  *@return un tableau de type int[] contenant la largeur et la hauteur de la grille
  */
  public int[] getSize() {
    int[] size = {this.getWidth(), this.getHeight()};
    return size;
  }

/**
  *Retourne une liste de type ArrayList(City) des objets City contenus dans la grille
  *@return une liste de type ArrayList(City) des objets City contenus dans la grille
  */
  public ArrayList<City> getWorldCities() {
    return this.world_cities;
  }

}
