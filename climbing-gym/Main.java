import Gym.Gym;
import People.Climber;
import People.Setter;

public class Main
{
    public static void main(String[] args) {
        InteractionManager program = new InteractionManager();
        Gym gym = new Gym("Bergen Klatresenter", "Laksevåg, Bergen");

        // Sets default user until new one is declared
        program.setUser(new Climber("", "", gym));


        // Add some data to the temporary database
        Setter birk = new Setter("Birk Nergård", "86947205", gym);
        Setter mia = new Setter("Mia Miasen", "77084793", gym);

        Climber balder = new Climber("Balder Barmen", "94810495", gym);
        Climber haakon = new Climber("Håkon Anthun", "54628511", gym);

        birk.addBoulder(5, 10);
        birk.addBoulder(0,0);
        mia.addBoulder(10, -5);
        mia.addBoulder(17, 55);

        // Clear terminal and run program
        program.setProgramState(1);
    }
}
