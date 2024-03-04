package People;
import Gym.*;
import Technical.DateHandler;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ascent
{
    private final Climber climber;
    private final Boulder boulder;
    private LocalDate firstAscentDate;
    private int count;

    public Ascent(Climber climber, Boulder boulder){
        this.boulder = boulder;
        this.firstAscentDate = LocalDate.of(0,1,1);
        this.climber = climber;
        this.count = 1;
    }

    private Climber getClimber() {
        return climber;
    }

    public String getClimberName(){
        return this.getClimber().getName();
    }

    public Boulder getBoulder() {
        return boulder;
    }

    public LocalDate getFirstAscentDate() {
        return firstAscentDate;
    }


    // Handle cases where an invalid date or month is inputted.
    public void setFirstAscentDate(ArrayList<Integer> list){
        DateHandler dateHandler = new DateHandler();
        this.firstAscentDate = dateHandler.returnDateFromList(list);
    }


    public int getAscentCount() {
        return count;
    }

    public void addAscent(){
        this.count++;
    }
}
