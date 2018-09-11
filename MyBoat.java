import greenfoot.*; 

public class MyBoat extends Actor
{
    int licznik;    
    boolean klawiszWciśnięty;  
    boolean klawiszWciśniętyPoprzednio;
    boolean kierunekDół = true;
    boolean spadaj = false;
    boolean wzlatuj = false;
    int myBoatLocation;
    int score;    
    public MyBoat(){
        GreenfootImage img = getImage();
        img.scale(30,30);
    }
          
    public void act() 
    {
        Actor case1 = getOneIntersectingObject(Boat.class);  
        Actor case2 = getOneIntersectingObject(Buoy.class);  
        if(getY() == 130 || getY() == 310 || case1 != null || case2 != null){
            Greenfoot.playSound("game_over.mp3");
            GameOver gameOver = new GameOver();
            getWorld().addObject(gameOver, 300, 200);  
            Greenfoot.stop();
        }       
        
        if(klawiszWciśnięty == true && klawiszWciśniętyPoprzednio == false) {
            if(kierunekDół){
                kierunekDół = !kierunekDół;
                spadaj = false;
                wzlatuj = true;
            }else{
                kierunekDół = true;
                wzlatuj = false;
                spadaj = true;
            }
        }
        
        if(kierunekDół){
            spadaj = true;
        }
        
        if(spadaj){
            int x = getX();
            int y = getY();
            setLocation(x, y + 1);
        }
        
        if(!kierunekDół){
            wzlatuj = true;
        }
        
        if(wzlatuj){
            int x = getX();
            int y = getY();
            setLocation(x, y - 1);
        }
        
        if(klawiszWciśniętyPoprzednio){
            klawiszWciśniętyPoprzednio = false;          
        }
        
        if(klawiszWciśnięty){
            klawiszWciśniętyPoprzednio = true;
            klawiszWciśnięty = false;             
        }
                
        if (Greenfoot.isKeyDown("space")) {
            klawiszWciśnięty = true;              
        }  
        
        if(Greenfoot.isKeyDown("right")){
            move(1);            
        }              
         
        
    }
}
