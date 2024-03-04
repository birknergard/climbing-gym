package People;
import Gym.*;
import Technical.DateHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Climber extends Person implements ClimbBoulder
{
    private final Gym gym;
    private int totalAscents;
    private HashMap<String, Ascent> ascentList;

    public Climber(String name, String phoneNumber, Gym gym){
        super(name, phoneNumber);
        this.totalAscents = 0;
        this.ascentList = new HashMap<>();
        this.gym = gym;
        this.gym.getClimberList().put(this.getPersonId(), this);
    }
    public int getTotalAscents() {
        return this.totalAscents;
    }

    public HashMap<String, Ascent> getAscentList() {
        return ascentList;
    }

    public Gym getGym() {
        return gym;
    }

    private boolean boulderHasBeenAscended(String id){
        return this.getAscentList().containsKey(id);
    }

    private void addAscentToTotal(){
        this.totalAscents++;
    }


    public void climb(String id){
        if(this.getGym().boulderExistsInGym(id)){
            Boulder boulderBeingClimbed = this.getGym().findBoulderByID(id);

            if(boulderHasBeenAscended(id)){
                this.getAscentList().get(id).addAscent();
            } else {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Dette er " + this.getName() + " sin første bestigning av denne " +
                        "bulderen!\nSkriv vennligst når denne ble bestiget (YYYY-MM-DD): ");
                this.getAscentList().put(id, new Ascent(this, boulderBeingClimbed));
                DateHandler dateHandler = new DateHandler();
                dateHandler.passDateInput(id, scanner, this);

            }
            boulderBeingClimbed.addAscent();
            this.addAscentToTotal();
        } else {
            System.out.println( id + " bulderen finnes ikke gymmen til personen.");
        }
    }

    public void listClimbs(){
        for(Map.Entry<String, Ascent> entry : this.getAscentList().entrySet()){
            System.out.println(entry.getValue().getClimberName() + " has climbed "
                    + entry.getValue().getBoulder().getBoulderId() + ": "
                    + entry.getValue().getAscentCount() + " times. grade: "
                    + entry.getValue().getBoulder().getGrade() +
                    " - First Ascent: " + entry.getValue().getFirstAscentDate());
        }
        System.out.println("Total climbs: " + this.getTotalAscents());
        System.out.println("------");
    }
}
