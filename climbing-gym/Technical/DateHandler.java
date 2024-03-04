package Technical;

import People.Climber;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DateHandler
{
    // Skal ta inn en string med format (YYYY-MM-DD)
    // og lagre det i et LocalDate format, som da kan spyttes ut.

    public LocalDate returnDateFromList(ArrayList<Integer> list){
        return LocalDate.of(list.get(0), list.get(1), list.get(2));
    }

    public void passDateInput(String id, Scanner scanner, Climber person){
        while(true) {
            String rawDate = scanner.nextLine();
            ArrayList<Integer> dateArray = fetchDateByString(rawDate);
            if(isDateValid(dateArray.get(1), dateArray.get(2))) {
                person.getAscentList().get(id).setFirstAscentDate(dateArray);
                break;
            } else {
                System.out.println("Invalid date, try again. FORMAT(YYYY-MM-DD)");
                System.out.println("------");
            }
        }
    }
    public ArrayList<Integer> fetchDateByString(String rawDate){ //Format required: YYYY-MM-DD
        String[] parts = rawDate.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(year);
        list.add(month);
        list.add(day);

        return list;
    }

    private boolean isMonthValid(int month){
        return month <= 12 && month >= 1;
    }

    public boolean isDateValid(int month, int day){
        if(isMonthValid(month)){
            if (month == 2) {
                return day <= 29 && 1 <= day;
            }
            else if (month % 2 == 0) {
                return day <= 30 && day >= 1;
            } else {
                return day <= 31 && day >= 1;
            }
        } else {
            return false;
        }
    }

}
