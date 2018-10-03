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
    Nation concilium = new Nation("Concilium");
    City ostie = w.addCity("Ostie", concilium, 100.0, 50);
    concilium.addCity(ostie);

    ArrayList<Integer> coord_ostie = ostie.getCoord();
    ArrayList<Tile> vois = w.consvois(coord_ostie.get(0), coord_ostie.get(1));
    System.out.println(vois);
    ostie.addLinkedTile(vois);
    ostie.addBuilding(farm);
    ostie.addBuilding(mine);
    ostie.setDemography();
    ostie.setRichness();
    System.out.println(ostie.getDemography());
    System.out.println(ostie.getRichness());

    City solon = w.addCity("Solon", concilium, 100.0, 50, 0, 0, null, null);
    concilium.addCity(solon);
    System.out.println(w);
  }
}
