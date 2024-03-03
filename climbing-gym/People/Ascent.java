package People;
import Gym.*;

import java.time.LocalDate;

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

    private boolean isMonthValid(int month){
       return month <= 12 && month >= 1;
    }

    public static boolean isDateValid(int month, int day){
        if(isMonthValid(month)){
            if (month == 2) {
                return day <= 29 && 1 <= day;
            }
            if (month % 2 == 0) {
                return day <= 30 && day >= 1;
            } else {
                return day <= 31 && day >= 1;
            }
        }
    }

    // Handle cases where an invalid date or month is inputted.
    private LocalDate formatDateByString(String rawDate){ //Format required: YYYY-MM-DD
        String[] parts = rawDate.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return LocalDate.of(year,month,day);
    }
    public void setFirstAscentDateByString(String rawDate){
        this.firstAscentDate = formatDateByString(rawDate);
    }
    public void setFirstAscentDate(int y, int m, int d){
        this.firstAscentDate = LocalDate.of(y,m,d);
    }

    public int getAscentCount() {
        return count;
    }

    public void addAscent(){
        this.count++;
    }
}
