import greenfoot.*;  

public class Score extends Actor
{
   int score = 0;
   public Score(){
        add(0);
   }
   public void add(int amount){
        score = score + amount;        
        GreenfootImage scoreBackground = new GreenfootImage(130, 30);
        Color c = new Color(255, 255, 255, 50);
        scoreBackground.setColor(c);
        scoreBackground.fill();
        scoreBackground.setColor(Color.DARK_GRAY);
        scoreBackground.setFont(new Font("", true, false, 16));
        scoreBackground.drawString("SCORE: " + score , 12, 21);
        setImage(scoreBackground);
   }       
}
