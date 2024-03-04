package Gym;

import Technical.idCreator;

public abstract class Boulder implements idCreator
{
    private static int previousId;
    private final String boulderId;
    private Grade grade;
    private int ascents;
    private final String setterName;
    private final int angle;

 Boulder(int gradeByInt, String setter, int angle){
     this.grade = new Grade(gradeByInt);
     this.setterName = setter;
     this.ascents = 0;
     this.angle = angle;
     this.boulderId = createId("B");
     System.out.println("Boulder created with ID: " + boulderId);
     previousId++;
 }
 Boulder(){
     this.grade = new Grade();
     this.setterName = "Unknown";
     this.ascents = 0;
     this.angle = 10;
     this.boulderId = createId("B");
     previousId++;
     System.out.println("Boulder created with ID: " + boulderId);
 }
    public String createId(String prefix){
     return prefix + previousId;
    }

    public String getBoulderId() {
        return boulderId;
    }

    public int getAscents() {
        return ascents;
    }

    public Grade getGrade() {
        return grade;
    }

    public String getSetterName() {
        return setterName;
    }
    public int getAngle(){
     return this.angle;
    }

    public void addAscent(){
     this.ascents += 1;
    }

    public void setAscents(int value){
     this.ascents = value;
    }

    public void setGradeByInt(int value){
     this.grade.setGrade("V" + value);
    }
    public void setGrade(String grade){
     this.grade.setGrade(grade);
    }


    @Override
    public String toString(){
     return "; " + this.getGrade() + "; ASC: " + this.getAscents();
    }

}
