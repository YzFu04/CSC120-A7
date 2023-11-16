import java.util.ArrayList;
import java.util.Hashtable;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Adds a Library to the map
     * @param l the library to add
     */
    public void addLibrary(Library l) {
        System.out.println("Adding building...");
        buildings.add(l);
        System.out.println("-->Successfully added " + l.getName() + " to the map.");
    }

    /**
     * Adds a Cafe to the map
     * @param c the Cafe to add
     */
    public void addCafe(Cafe c) {
        System.out.println("Adding building...");
        buildings.add(c);
        System.out.println("-->Successfully added " + c.getName() + " to the map.");
    }

    /**
     * Adds a House to the map
     * @param h the House to add
     */
    public void addHouse(House h) {
        System.out.println("Adding building...");
        buildings.add(h);
        System.out.println("-->Successfully added " + h.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        Hashtable<String, Boolean> collectionNeilson;
        Hashtable<String, Boolean> collectionJosten;
        ArrayList<String> residentsCapen;
        ArrayList<String> residentsGillet;
        ArrayList<String> residentsWashburn;
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addLibrary(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, collectionNeilson));
        myMap.addCafe(new Cafe("Compass Cafe", "7 Neilson Drive Northampton, MA 01063", 1, 100, 100, 100, 100));
        myMap.addLibrary(new Library("Werner Josten Library", "Mendenhall Center, 122 Green St, Northampton, MA 01063", 2, collectionJosten));
        myMap.addBuilding(new Building("Julia McWilliams Child ’34 Campus Center", "Smith College Campus Center, 100 Elm St, Northampton, MA 01063", 2));
        myMap.addCafe(new Cafe("Campus Center Cafe", "Smith College Campus Center, 100 Elm St, Northampton, MA 01063", 2, 200, 200, 200, 200));
        myMap.addHouse(new House("Capen House", "26 Prospect St, Northampton, MA 01060", 3, residentsCapen, false, false));
        myMap.addHouse(new House("Gillet House", "47 Elm St, Northampton, MA 01060", 5, residentsGillet, true, true));
        myMap.addHouse(new House("Washburn House", "4 Seelye Dr, Northampton, MA 01060", 3, residentsWashburn, false, false));
        System.out.println(myMap);
    }
    
}
