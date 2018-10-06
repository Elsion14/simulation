package game;

import java.util.ArrayList;

/**
  *Méthode principale du package game
  */
public class Main {

  public static void main(String[] args) {
    ArrayList<Building> available_buildings = new ArrayList<>();
    Building farm = new Building("ferme", 10, 0, 0.1f);
    Building market = new Building("marché", 25, 5, 0f);
    Building mine = new Building("mine", 15, 3, 0f);
    available_buildings.add(farm);
    available_buildings.add(market);
    available_buildings.add(mine);

    World w = new World(20,20);
    w.generateWorld();
    Nation concilium = w.addNation("Concilium");
    if (concilium == null) {
      System.out.println("Une nation porte déjà ce nom");
    } else {
      System.out.println("Une nouvelle nation voit le jour: "+concilium.getName());
    }
    City ostie = w.addCity("Ostie", concilium, 100.0, 50);

    ArrayList<Integer> coord_ostie = ostie.getCoord();
    ArrayList<Tile> vois = w.consvois(coord_ostie.get(0), coord_ostie.get(1));
    ostie.addLinkedTile(vois);
    ostie.addBuilding(farm);
    ostie.addBuilding(mine);
    ostie.setDemography();
    ostie.setRichness();

    City solon = w.addCity("Solon", concilium, 100.0, 50, 0, 0, null, null);
    if (solon == null) {
      System.out.println("Impossible de fonder une ville ici: une autre ville est trop proche");
    } else {
      ArrayList<Tile> vois_solon = w.consvois(solon.getCoord().get(0), solon.getCoord().get(1));
      solon.addLinkedTile(vois_solon);
      System.out.println("La ville de "+solon.getName()+" a été fondée !");
    }

    //CREATION NATION ADUKAR
    Nation adu = w.addNation("Adukar");
    if (adu == null) {
      System.out.println("Une nation porte déjà ce nom");
    } else {
      System.out.println("Une nouvelle nation voit le jour: "+adu.getName());
    }
    //AJOUT VILLE NELDOREN A ADUKAR
    City neldoren = w.addCity("Neldoren", adu, 100.0, 50, 10, 10, null, null);
    if (neldoren == null) {
      System.out.println("Impossible de fonder une ville ici: une autre ville est trop proche");
    } else {
      ArrayList<Tile> vois_neldoren = w.consvois(neldoren.getCoord().get(0), neldoren.getCoord().get(1));
      neldoren.addLinkedTile(vois_neldoren);
      System.out.println("La ville de "+neldoren.getName()+" a été fondée !");
    }

    System.out.println(w);
    for (City c : w.getWorldCities()) {
      System.out.println(c.getName());
    }

    for (Nation n : w.getAllNations()) {
      System.out.println("Villes appartenant à la nation "+n.getName());
      for (City c : n.getCities()) {
        System.out.println("-"+c.getName());
      }
    }
  }
}
