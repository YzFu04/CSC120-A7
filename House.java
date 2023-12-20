/* This is a stub for the House class */
import java.util.ArrayList;

/*
 * a place where students live, work, and sometimes eat (if the House has a dining room)
 */
public class House extends Building{
  /*
   * an attribute to store residents in the class
   */
  private ArrayList<String> residents;
  /*
   * an attribute to indicate whether the house has a dining room
   */
  private boolean hasDiningRoom;
  /*
   * an attribute to indicate whether elevator is available
   */
  private boolean elevator;
  protected int activeFloor = -1;

  /*
   * a constructor to initialize residents to a new ArrayList<String>(), as well as to set hasDiningRoom to indicate whether or not the house has a dining room
   */
  public House(String name, String address, int nFloors, ArrayList<String> residents, boolean hasDiningRoom, boolean elevator) {
    super (name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.elevator = elevator;
    System.out.println("You have built a house: 🏠");
  }

  /* 
   * an accessor to retreive whether the house has a dining room
   * @return hasDiningRoom
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }
  /* 
   * an accessor to return number of residents in the house
   * @return nResidents
   */
  public int nResidents() {
    return residents.size();
  }

  /*
   * a method to update the ArrayList of residents every time someone moves in
   */
  public void moveIn(String person) {
    if (residents.contains(person)) {
      throw new RuntimeException("Resident already moved in");
    } else {
      residents.add(person);
    }
  }

  /*
   * a method to update the ArrayList of residents every time someone moves out
   * @return name the name of the person who moved out
   */
  public String moveOut(String person) {
    if (residents.contains(person)){
      residents.remove(person);
      return person;
    } else {
      throw new RuntimeException("Resident not found");
    }
  }

  /*
   * a boolean method that tells us whether or not a given person is a resident of the House
   * @return isResident
   */
  public boolean isResident(String person) {
    boolean isResident = residents.contains(person);
    return isResident;
  }

  /*
   * overloaded method that tells us whether or not given people are residents of the House
   * @param people An array of people to check
   * @return @return true if all people are residents, false otherwise
   */
  public boolean areResidents(String[] people) {
    for (String person : people) {
        if (!residents.contains(person)) {
            return false;
        }
      }
    return true;
  }

  /*
   * overloaded method that print all residents in the house
   * @return Arraylist
   */
  public void isResident() {
    for (String name : residents) {
      System.out.println(name);
    }
  }

  /*
   * @override showOptions() in Building class
   */
  public void goToFloor(int floorNum) {
      if (elevator){
        if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this house. Must call enter() before navigating between floors.");
        }
        if (floorNum < -1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this House is 1-" + this.nFloors +".");
        }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    }
    else {
      throw new RuntimeException("There is not an elevator in this house.");
    }
  }

  /*
   * @override showOptions() in Building class
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ": \n + enter() \n + exit() \n + goUp() \n + goDown() \n + goToFloor(n) \n + hasDiningRoom() \n + nResidents() \n + moveIn(person) \n + moveOut(person) \n + isResident(person) \n + isResident(personA, personB) \n + isResident()");
  }

  // public static void main(String[] args) {
  //   new House();
  // }

}