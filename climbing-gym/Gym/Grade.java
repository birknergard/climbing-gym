package Gym;

public class Grade
{
    private String grade;

    public Grade(){
        this.grade = "V0";
    }
    public Grade(int number){
        if(number >= 0 && number < 18){
            this.grade = "V" + number;
        } else {
            System.out.println("V" + number + " is is not a valid grade on the V-scale.");
        }

    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString(){
        return grade;
    }

}
