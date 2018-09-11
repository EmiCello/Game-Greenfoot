import greenfoot.*;  
public class BasicActor extends Actor
{
    int SPEED = 1;
    public void act() 
    {
        int currentLocation = getX();
        if(currentLocation == 0){
            deleteActor();       
        }else{
            move();
        }        
    } 
    public void move(){
        setLocation(getX() - SPEED, getY());
    } 
    public void deleteActor(){    
        getWorld().removeObject(this);
    }
}
