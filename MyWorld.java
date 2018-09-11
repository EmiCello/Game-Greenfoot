import greenfoot.*; 

public class MyWorld extends World
{
    int counter = 0;
    int counterTime = 0;
    int boatTimer = 0;
    int buoyTimer = 0;
    int c = 0;     
    
    int y = 60;
    int x = 82;
    
    Sun sun;
    Tree tree; 
    Boat boat;
    Buoy buoy;
    GameOver gameOver; 
    Score score;
    
    GreenfootImage river_middle;
    GreenfootImage river_night;
    GreenfootImage river_day;    
    
    public MyWorld()
    {    
         super(600, 400, 1, false); 
         sun = new Sun();
         addObject(sun, getWidth() - 80, y); 
         MyBoat myBoat = new MyBoat();
         addObject(myBoat, 120, 200);           
         score = new Score();
         addObject(score, 100, 360);         
         
         river_middle = new GreenfootImage("river_middle.png");
         river_night = new GreenfootImage("river_night.png");
         river_day = new GreenfootImage("river.png");
         
         for(int i = 0, j = 10; i <= 10; i++, j++){
            tree = new Tree();
            j += 9;
            addObject(tree, j , 134);
         }
    }
    
    public void act(){
        counter++;
        counterTime++;
        boatTimer++;
        buoyTimer++;
        c++;                
        int lotteryNumber = Greenfoot.getRandomNumber(200);        
        if(lotteryNumber == 100){
            Grass grass = new Grass();
            addObject(grass, getWidth(), getHeight() - x);
        }
        if(lotteryNumber == 50){
            Flower flower = new Flower();
            addObject(flower, getWidth(), getHeight() - x);
        }
        if(counter == 30 || counter == 40 || counter == 190){
            House house = new House();
            addObject(house, getWidth(), 135);
        }
        if(counter == 50  || counter == 58 || counter == 64 || counter == 72 || counter == 80){
            tree = new Tree();            
            addObject(tree, getWidth(), 134);
        }        
        if(counter == 170){
            House2 house = new House2();
            addObject(house, getWidth(), 132);
        }
        if(counter == 200){
            counter = 0;
        }        
        if(counterTime == 7000){
            setBackground(river_middle);            
        }
        if(counterTime == 7050){
            setBackground(river_night);
        }
        if(counterTime == 8260){
            Moon moon = new Moon();
            addObject(moon,getWidth(), y);
        }
        if(counterTime == 15000){
            setBackground(river_middle);
        }
        if(counterTime == 15500){
           setBackground(river_day);           
        }
        if(counterTime == 16000){
            Sun sun = new Sun();
            addObject(sun,getWidth(), y);
            counterTime = 0;
        }
        if(boatTimer == 200){
            boat = new Boat();            
            addObject(boat, getWidth(), Greenfoot.getRandomNumber(150) + 150);
            boatTimer = 0;
        }
        if(buoyTimer == 150){
            buoy = new Buoy();            
            addObject(buoy, getWidth(), Greenfoot.getRandomNumber(150) + 150); 
            buoyTimer = 0;
        }
        
        int myBoatX = getObjects(MyBoat.class).get(0).getX();
        for (Buoy buoy : getObjects(Buoy.class)) {
            if(myBoatX == buoy.getX()){
                score.add(1);
            }
        }
        for (Boat boat : getObjects(Boat.class)) {
            if(myBoatX == boat.getX()){
                 score.add(1);
            }
        }
    }
}
