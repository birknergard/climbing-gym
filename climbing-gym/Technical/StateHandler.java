package Technical;

import Gym.*;
public interface StateHandler
{
    public void setProgramState(int state);
    public void execute(Gym gym);
    public void chooseClimber(Gym gym);
    public void climbCompleted();

    public void createUser(Gym gym);


}
