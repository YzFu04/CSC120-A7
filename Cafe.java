/* This is a stub for the Cafe class */

/*
 * a class which keeps track of cafe inventory
 */
public class Cafe extends Building{
    /*
     * an attribute which is the number of ounces of coffee remaining in inventory
     */
    private int nCoffeeOunces; 
    /*
     * an attribute which is the number of sugar packets remaining in inventory
     */
    private int nSugarPackets; 
    /*
     * an attribute which is number of "splashes" of cream remaining in inventory
     */
    private int nCreams;
    /*
     * an attribute which is the number of cups remaining in inventory
     */
    private int nCups;
    /*
    * an attribute to indicate whether elevator is available
    */
    protected boolean elevator = true;
    protected int activeFloor = -1;


    /*
     * a constructor to set the starting values of each of the stocked items (coffee, sugar, cream, and cups)
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /*
     * a method to decrease the remaining inventory when the Cafe sells a cup of coffee
     */
    public void sellCoffee(int size, int sugar, int cream) {
        if (nCoffeeOunces >= size && nSugarPackets >= sugar && nCreams >= cream && nCups >= 1) {
            nCoffeeOunces -= size;
            nSugarPackets -= sugar;
            nCreams -= cream;
            nCups -= 1;
        } else {
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
            nCoffeeOunces -= size;
            nSugarPackets -= sugar;
            nCreams -= cream;
            nCups -= 1;
        }
    }

    /*
     * overloaded method to indicate number of coffee
     */
    public void sellCoffee(int size, int sugar, int cream, int cup) {
        if (nCoffeeOunces >= size && nSugarPackets >= sugar && nCreams >= cream && nCups >= 1) {
            nCoffeeOunces = nCoffeeOunces - size * cup;
            nSugarPackets = nSugarPackets - sugar * cup;
            nCreams = nCreams - cream * cup;
            nCups = nCups - cup;
        } else {
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
            nCoffeeOunces = nCoffeeOunces - size * cup;
            nSugarPackets = nSugarPackets - sugar * cup;
            nCreams = nCreams - cream * cup;
            nCups = nCups - cup;
        }
    }

    /*
     * overloaded method to make a cup of coffee in default sugar, and cream
     */
    public void sellCoffee(int size) {
        if (nCoffeeOunces >= size && nSugarPackets >= 1 && nCreams >= 1 && nCups >= 1) {
            nCoffeeOunces -= size;
            nSugarPackets -= 1;
            nCreams -= 1;
            nCups -= 1;
        } else {
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
            nCoffeeOunces -= size;
            nSugarPackets -= 1;
            nCreams -= 1;
            nCups -= 1;
        }
    }

    /*
     * a method to restock when necessary
     */
    private void restock(int size, int sugar, int cream, int cup) {
        nCoffeeOunces += size;
        nSugarPackets += sugar;
        nCreams += cream;
        nCups += cup;
    }

    /*
     * @override
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Cafe. Must call enter() before navigating between floors.");
        }
        if (floorNum != 1) {
            throw new RuntimeException("Invalid floor number. Valid range for this Cafe is 1.");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /*
     * @override showOptions() in Building class
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ": \n + enter() \n + exit() \n + goUp() \n + goDown() \n + goToFloor(n) \n + sellCoffee(size, sugar, cream) \n + sellCoffee(size, sugar, cream, cup) \n + sellCoffee(size) \n + restock(size, sugar, cream, cup) ");
    }

    // public static void main(String[] args) {
    //     new Cafe();
    // }
    
}
