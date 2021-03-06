package personality;

/** Characteristic.java
 * Define the model to be implemented for each characteristic
 * of the personality of each person, their action and define if is
 * good or bad.
 */
public abstract class Characteristic implements Comparable<Characteristic> {

  private String name; // Identify the characteristic (not null, not black)

  //keep the characteristic color and help to group characteristics
  private CharacteristicColor characteristicGroup;


  /** Used by member of group to show your characteristic in action
   * @return action: is execution of the children implementation
   * @throws RuntimeException: result can't be null or empty string
   */
  public final String act() throws RuntimeException{
    String action = this.doCharacteristic();
    if(action == null || action.trim().length() == 0) {
      throw new RuntimeException("Execution of act get a bad string");
    }
    return action;
  }

  public String toString() {
    return getName();
  }
  
  /** Return the actual name of characteristic colored with
    * characteristicGroup's color
    * @return coloredName: The string name with colors of terminal
   */
  public String getName() {
    return this.characteristicGroup + this.name + CharacteristicColor.UNDEFINED;
  }

  /** Get the group of this characteristic
   * @return characteristicColorGroup: the integer characterist color group
   */
  public Integer getCharacteristicGroup() {
    return this.characteristicGroup.getGroup();
  }

  /** Implements compare method for possibility group characteristics by classifications
   * @return comparation: int that represents 1 for greater, 0 equals and -1 lesser
   */
  public int compareTo(Characteristic other) {
    Integer comparation = null;
    if(this.getCharacteristicGroup() == other.getCharacteristicGroup()) {
      comparation = 0;
    } else if (this.getCharacteristicGroup() > other.getCharacteristicGroup()) {
      comparation = 1;
    } else {
      comparation = -1;
    }
    return comparation;
  }

  /** This method should be implemented by childrens to define the exclusive
   * behavior of each person using this characteristic
   * @return characteristic description of action
   */
  protected abstract String doCharacteristic();

  protected Characteristic(String name, CharacteristicColor characteristicGroup) {
    this.name = name; // fuck the set method
    this.characteristicGroup = characteristicGroup;
  }
}
