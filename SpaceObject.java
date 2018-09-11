import greenfoot.*; 
public class SpaceObject extends BasicActor
{
    int counter = 0;
    public void act() 
    {
        counter++;
        if(counter == 10){
            super.act();
            counter = 0;
        }        
    }
}
