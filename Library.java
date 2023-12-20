/* This is a stub for the Library class */
import java.util.Hashtable;

/*
 * a class which has a collection of titles
 */
public class Library extends Building {
  /* 
   * an attribute in which we will store each book's title and author
   */ 
  private Hashtable<String, Boolean> collection;
  /*
   * an attribute to indicate whether elevator is available
   */
  protected boolean elevator = true;
  protected int activeFloor = -1;

  /* 
   * a constructor
   */ 
  public Library(String name, String address, int nFloors, Hashtable<String, Boolean> collection) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean> ();
    System.out.println("You have built a library: 📖");
  }
  
  /* 
   * a method to update the Hashtable containing the collection every time we add a title
   */ 
  public void addTitle(String title) {
    collection.put(title, true);
  }

  /*
   * a method to update the Hashtable containing the collection every time we remove a title
   * @return title
   */
  public String removeTitle(String title) {
    if (collection.contains(title)) {
      collection.remove(title);
      return title;
    } else {
      throw new RuntimeException("Book not found");
    }
  } 

  /*
   * a method to check out a book
   */
  public void checkOut(String title) {
    if (collection.get(title)) {
      collection.replace(title, true, false);
   } else {
    throw new RuntimeException("Book not found");
   }
  }

  /*
   * a method to return a book
   */
  public void returnBook(String title) {
    Boolean value = collection.get(title);
    Boolean t = true;
    if (!value) {
      collection.replace(title, value, t);
    }
  }

  /*
   * a method to return true if the title appears as a key in the Libary's collection, false otherwise
   * @return boolean
   */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  } 
  
  /*
   * a method to return true if the title is currently available, false otherwise
   * @return boolean
   */
  public boolean isAvailable(String title) {
    Boolean value = collection.get(title);
    return value;
  }
  
  /*
   * a method that prints out the entire collection in an easy-to-read way (including checkout status)
   * @return collection
   */
  public void printCollection() {
    for (String title : collection.keySet()) {
      System.out.println(title);
      System.out.println(isAvailable(title));
    }
  }

  /*
   * overloaded method that only prints out the available/unavailable books
   * @return available/unavailable collection
   */
  public void printCollection(boolean currentStatus) {
    for (String title : collection.keySet()) {
      if (isAvailable(title) == currentStatus) {
        System.out.println(title);
      }
    }
  }

  /*
   * overloaded method that prints out the collection with a specific string (including checkout status)
   * @return books with specific string
   */
  public void printCollection(String keyword) {
    for (String title : collection.keySet()) {
      if (title.contains(keyword)) {
        System.out.println(title);
        System.out.println(isAvailable(title));
      }
    }
  }

  /*
   * @override showOptions() in Building class
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Library. Must call enter() before navigating between floors.");
    }
    if (floorNum < -1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is -1 -" + this.nFloors +".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  /*
   * @override showOptions() in Building class
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ": \n + enter() \n + exit() \n + goUp() \n + goDown() \n + goToFloor(n) \n + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + containsTitle(title) \n + isAvailable(title) \n + printCollection() \n + printCollection(currentStatus) \n + printCollection(keyword)");
  }

}

  // public static void main(String[] args) {
  //   new Library();
  // }
