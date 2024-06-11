package Gym;

import Technical.idCreator;

public abstract class Boulder implements idCreator
{
    private static int previousId;
    private final String boulderId;
    private Grade grade;
    private final int angle;

    enum BoulderType{
        Slab, Overhang, Vertical
    }

    private class Grade{
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
        public String getGrade(){
            return this.grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        @Override
        public String toString(){
            return grade;
        }
    }

 Boulder(int gradeByInt, String setter, int angle){
     this.grade = new Grade(gradeByInt);
     this.angle = angle;
     this.boulderId = createId("B", previousId);
     System.out.println("Boulder created with ID: " + boulderId);
     previousId++;
 }
 Boulder(){
     this.grade = new Grade();
     this.angle = 10;
     this.boulderId = createId("B", previousId);
     previousId++;
     System.out.println("Boulder created with ID: " + boulderId);
 }
    public String createId(String prefix, int staticNumber){
     return prefix + previousId;
    }

    public String getBoulderId() {
        return boulderId;
    }

    public String getGrade() {
        return this.grade.getGrade();
    }

    public int getAngle(){
     return this.angle;
    }

    public void setGradeByInt(int value){
     this.grade.setGrade("V" + value);
    }
    public void setGrade(String grade){
        this.grade.setGrade(grade);
    }

}
