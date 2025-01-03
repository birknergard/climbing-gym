package Technical;

import Gym.*;
import People.*;

import java.util.Scanner;

public class InteractionManager implements StateHandler
{

    //# Fields
    private static Climber user;
    private final static Scanner input;
    private static int state;

    //# Methods
    static {
        // Preloading static fields
        input = new Scanner(System.in);
        state = 0;
    }
    public void setTemporaryUser(Gym gym){
        setUser(new Climber(gym));
    }
    private Climber getUser(){
        return user;
    }
    public void setUser(Climber newUser){
        user = newUser;
    }
    private static void printLine(){
        System.out.println("------");
    }
    private static void changeState(int newState){
        state = newState;
    }


    public void setProgramState(int state){
        switch(state) {
            case 1:
                execute(this.getUser().getGym());
            case 2:
                chooseClimber(this.getUser().getGym());
            case 2_1:
                createUser(getUser().getGym());
            case 3:
                chooseBoulder();
            case 4:
                climbCompleted();

        }
    }
    public void execute(Gym gym){
        if(state == 1) {
            System.out.println("Try again.");
            printLine();
        } else {
            changeState(1);
            clearScreen();
            System.out.println("Welcome to the climbing gym!");
            System.out.println("This is an interactive program in which you can climb boulders.");
            System.out.println("Navigation is done by writing in the terminal where you will respond to a variety of prompts.");
            System.out.println("Do your best to follow these prompts accurately.");
            printLine();
            System.out.println("Press ENTER to start.");
            printLine();
        }

        String userInput = input.nextLine();
        if(userInput.isEmpty()){
            setProgramState(2);
        } else if(userInput.equals("exit")) {
            System.out.println("Exiting program ...");
            System.exit(0);
        } else {
            setProgramState(1);
        }
    }
    public void chooseClimber(Gym gym){
        if(state == 2) {
            System.out.println("Try again.");
            printLine();
        } else {
            changeState(2);
            clearScreen();
            System.out.println("Choose a climber from the list below");
            gym.printClimbers();
            System.out.println("Write the id corresponding to the person you choose.");
            System.out.println("Alternatively you can write 'new' in order to create your own user. :)");
            printLine();
        }
        String userInput = input.nextLine();

        if(gym.getClimberList().containsKey(userInput)){
            setUser(gym.getClimberList().get(userInput));
            setProgramState(3);
        } else if(userInput.equals("exit")) {
            System.out.println("Exiting program ...");
            System.exit(0);
        } else if(userInput.equals("new")){
            setProgramState(2_1);
        } else {
            System.out.println("Invalid ID, please try again.");
            setProgramState(2);
        }
    }

    public void chooseBoulder(){
        if(state == 3){
            System.out.println("Try again.");
        } else {
            changeState(3);
            clearScreen();
            System.out.println("Hello " + getUser().getFirstName() + "!");
            System.out.println("Here is the list of boulders you can try.");
            this.getUser().getGym().printBoulders();
            System.out.println("Please pick your boulder by writing its corresponding ID!");
            printLine();
        }
        if(input.hasNextLine()){
            String userInput = input.nextLine();

            if(this.getUser().getGym().boulderExistsInGym(userInput)){
                this.getUser().climb(userInput);
                setProgramState(4);
            } else if(userInput.equals("exit")) {
                System.out.println("Exiting program ...");
                System.exit(0);
            } else {
                System.out.println("The ID you have written appears to be incorrect.");
                setProgramState(3);
            }
        } else {
            System.out.println("No input available, exiting ...");
            System.exit(0);
        }
    }
    public void climbCompleted(){
        if(state == 4) {
            System.out.println("Try again. ");
            printLine();
        } else {
            changeState(4);
            System.out.println("You completed the climb!");
            System.out.println("Would you like to do another one?");
            System.out.println("yes/no?");
            printLine();
        }

        if(input.hasNextLine()){
            String userInput = input.nextLine();
            if(userInput.equals("yes")){
                setProgramState(3);
            } else if(userInput.equals("exit") || userInput.equals("no")){
                System.out.println("Exiting program ...");
                System.exit(0);
            } else {
                setProgramState(4);
            }
        } else {
            System.out.println("No input available, exiting ...");
            System.exit(0);
        }
    }

    public void createUser(Gym gym){
        changeState(2_1);
        clearScreen();
        System.out.println("Please write your full name.");
        System.out.println("------");
        String name = input.nextLine();
        while(true) {
            if(name.isEmpty()){
                System.out.println("You need to write a name.");
                System.out.println("------");
                name = input.nextLine();
            } else {
                break;
            }
        }


        clearScreen();
        System.out.println("Please write your phonenumber. (or just press enter)");
        System.out.println("------");
        String phoneNumber;
        String buffer = input.nextLine();
        if (buffer.isEmpty()){
            phoneNumber = "Unknown";
        } else {
            phoneNumber = buffer;
        }

        clearScreen();
        System.out.println("Does this look correct?");
        System.out.println("------");
        System.out.println("Name: " + name);
        System.out.println("Phonenumber: " + phoneNumber);
        System.out.println("------");
        System.out.println("Yes/No?");
        System.out.println("------");

        buffer = input.nextLine();

        if(buffer.equals("yes")){
            System.out.println("In this program it is possible to create your own boulders if you are a setter.");
            System.out.println("Keep in mind that you need to enter the right password in order to set yourself as a setter.");
            System.out.println("Are you a climber or a setter?");
            System.out.println("------");
            buffer = input.nextLine();
            if(buffer.equals("setter")){
                System.out.println("Enter password:");
                buffer = input.nextLine();
                if(passwordIsCorrect(buffer)){
                    System.out.println("Password correct! Creating setter ...");
                    setUser(new Setter(name, phoneNumber, gym));
                } else {
                    System.out.println("Password incorrect. Creating climber ...");
                    setUser(new Climber(name, phoneNumber, gym));
                }

            } else if(buffer.equals("climber")) {
                setUser(new Climber(name, phoneNumber, gym));
            }
        } else {
            setProgramState(2_1);
        }
        setProgramState(2);

        }

    private boolean passwordIsCorrect(String input){
        String pass = "edamame";
        return input.equals(pass);
    }

    private static void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

}
