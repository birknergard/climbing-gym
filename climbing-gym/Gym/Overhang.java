package Gym;

public class Overhang extends Boulder
{
    private BoulderType type;

    public Overhang(){
        super();
        this.type = BoulderType.Overhang;
    }
    public Overhang(int angle, int grade, String setter){
        super(grade, setter, angle);
        this.type = BoulderType.Overhang;
    }

    @Override
    public String toString(){
        return this.type + super.toString();
    }
}
