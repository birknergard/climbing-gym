package People;
import Gym.*;
import Technical.DateHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Climber extends Person implements ClimbBoulder
{
    /**
     * Subclass of Person, stores the gym in which the climber is frequenting, the total number of ascents, as well as
     * a list of each boulder the climber has ascended. Each climber inherits the attributes from the Person class, most importantly the PersonID, which
     * is used in the ascentList HashMap as its key.
     */
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
    public Climber(Gym gym){
        this.gym = gym;

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

    /**
     * Checks if boulder is already in climbers ascentlist.
     * @param id of Boulder [String]
     * @return boolean
     */
    private boolean boulderHasBeenAscended(String id){
        return this.getAscentList().containsKey(id);
    }

    private void addAscentToTotal(){
        this.totalAscents++;
    }

    /**
     * Adds a boulder to the climbers ascentList, and updates fields as required.
     * @param id of boulder [String]
     */
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
                dateHandler.setAscentDateByUserInput(id, scanner, this);

            }
            this.addAscentToTotal();
        } else {
            System.out.println( id + " bulderen finnes ikke gymmen til personen.");
        }
    }

    /**
     * Prints a list to the terminal of all available climbs for the gym in which the climber is assigned.
     */
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
