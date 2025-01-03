package Gym;

import People.*;
import java.util.HashMap;
import java.util.Map;

public class Gym
{
    class Info {
        private final String name;
        private final String location;

        Info(String name, String location){
            this.name = name;
            this.location = location;
        }

        public String getName() {
            return this.name;
        }

        public String getLocation() {
            return this.location;
        }

    }
    private final Info info;
    private final HashMap<String, Climber> climberList;
    private final HashMap<String, Setter> employeeList;
    private final HashMap<String, Boulder> bouldersInGym;

    public Gym(String name, String location){
        this.info = new Info(name, location);
        this.climberList = new HashMap<>();
        this.employeeList = new HashMap<>();
        this.bouldersInGym = new HashMap<>();
    }

    private Info getGymInfo(){
        return this.info;
    }
    public HashMap<String, Boulder> getBouldersInGym() {
        return this.bouldersInGym;
    }

    public HashMap<String, Climber> getClimberList() {
        return this.climberList;
    }

    public HashMap<String, Setter> getEmployeeList() {
        return this.employeeList;
    }

    private Setter getSetter(String id){
       return this.getEmployeeList().get(id);
    }

    public void addBoulderToLists(Boulder boulder, String employeeId){
        this.bouldersInGym.put(boulder.getBoulderId(), boulder);
        this.getSetter(employeeId).getBouldersSet().put(boulder.getBoulderId(), boulder);
    }

    public boolean boulderExistsInGym(String boulderID){
        return this.getBouldersInGym().containsKey(boulderID);
    }
    public Boulder findBoulderByID(String id){
        return this.bouldersInGym.get(id);
    }

    public void printBoulders(){
        System.out.println("Boulders at " + this.info.getName() + ", " + this.info.getLocation());
        for(Map.Entry<String, Boulder> entry : this.bouldersInGym.entrySet()){
            System.out.println(entry.getKey() + " - "
                    + entry.getValue() + " - Set by "
                    + entry.getValue().getSetterName());
        }
        System.out.println("------");
    }
    public void printSetters(){
        System.out.println("Setters at " + this.getGymInfo().getName() + ", " + this.getGymInfo().getLocation());
        for(Map.Entry<String, Setter> entry : this.getEmployeeList().entrySet()){
            System.out.println(entry.getKey() + " - "
                    + entry.getValue().getName() + " : "
                    + entry.getValue().getPhoneNumber());
        }
        System.out.println("------");
    }

    public void printClimbers(){
        System.out.println("Climbers at " + this.getGymInfo().getName() + ", " + this.getGymInfo().getLocation());
        for(Map.Entry<String, Climber> entry : this.getClimberList().entrySet()){
            System.out.println(entry.getKey() + " - "
                    + entry.getValue().getName() + " : "
                    + entry.getValue().getPhoneNumber());
        }
        System.out.println("------");
    }
}
