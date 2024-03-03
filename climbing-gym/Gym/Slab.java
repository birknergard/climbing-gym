package Gym;

public class Slab extends Boulder
{
    private BoulderType type;

    public Slab(){
        super();
        this.type = BoulderType.Slab;
    }

    public Slab(int angle, int grade, String setter){
        super(grade, setter, angle);
        this.type = BoulderType.Slab;
    }
    @Override
    public String toString(){
        return this.type + super.toString();
    }

}
