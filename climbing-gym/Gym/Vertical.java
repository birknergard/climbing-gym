package Gym;

public class Vertical extends Boulder
{
    private BoulderType type;

    public Vertical(){
        super();
        this.type = BoulderType.Vertical;
    }
    public Vertical(int angle, int grade, String setter){
        super(grade, setter, angle);
        this.type = BoulderType.Vertical;
    }
    @Override
    public String toString(){
        return this.type + super.toString();
    }
}
