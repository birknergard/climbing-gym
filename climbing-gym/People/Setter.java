package People;

import Gym.*;

import java.util.HashMap;
import java.util.Map;

public class Setter extends Climber implements BoulderManager
{
    private static int previousId = 1;
    private HashMap<String, Boulder> bouldersSet;
    private final String employeeId;


    public Setter(String name, String phoneNumber, Gym gym){
      super(name, phoneNumber, gym);
      this.bouldersSet = new HashMap<>();
      this.employeeId = createId("S", previousId);
      previousId++;

      this.getGym().getEmployeeList().put(this.employeeId, this);

    }

    public HashMap<String, Boulder> getBouldersSet() {
        return this.bouldersSet;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void addBoulder(int grade, int angle){
        if(angle <= 90 && angle > -80) {
            Boulder buffer;
            if (angle == 0) {
                buffer = new Vertical(angle, grade, this.getName());
                this.getGym().addBoulderToLists(buffer, this.getEmployeeId());

            } else if (angle > 0) {
                buffer = new Overhang(angle, grade, this.getName());
                this.getGym().addBoulderToLists(buffer, this.getEmployeeId());

            } else if (angle < 0) {
                buffer = new Slab(angle, grade, this.getName());
                this.getGym().addBoulderToLists(buffer, this.getEmployeeId());
            }
            System.out.println(this.getName() + " created a new boulder!");
            System.out.println("------");
        } else {
            System.out.println("Invalid angle.");
        }
    }
    public void modifyGrade(Boulder boulder, int newGrade){
        System.out.println(this.getName() + "changed the grade from " + boulder.getGrade() + " to V" + newGrade + "!");
        boulder.setGradeByInt(newGrade);
    }
    public void printBouldersSet(){
       for(Map.Entry<String, Boulder> entry : this.getBouldersSet().entrySet()) {
           System.out.println(entry.getValue().getBoulderId() + " -> " + entry.getValue() + " - set by " + entry.getValue().getSetterName());
       }
    }
}
