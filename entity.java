import java.util.Scanner;
import java.lang.Math;

public class entity {
    private String name;
    private move [] knownMoves = new move[4];
    private int hp;
    private int level;
    private static int enemyHP;
    
    private static Scanner input = new Scanner(System.in);
    
    //Object for Pokemon
    public entity(String name, int level, int hpStat) 
    {
        this.name = name;
        this.level = level;

        //calculates HP through a floor
        this.hp = (int) Math.floor(0.01 * (2 * hpStat + 31 + Math.floor(0.25 * hpStat)) * level) + level + 10;
        enemyHP = hp;
    }
    
    //Adds moves to list of available moves
    public void addMoves(int moveIndex, int typeIndex, String name, int power)
    {
        knownMoves[moveIndex] = new move(getType(typeIndex), name, power);
    }

    //Executes moves
    public void executeMove()
    {
        
        System.out.println("Select Move");

        int selectedMove = input.nextInt();
        
        System.out.println(getName() + " used " + knownMoves[selectedMove].getName() + "!");
        enemyHP = enemyHP - (level * knownMoves[selectedMove].getDamage()) / 5;
    }
    
    //Gets name of current entity
    public String getName() {
        return name;
    }

    //gets Enemy HP (Will be depricated later)
    public int getEnemyHP()
    {
        return enemyHP;
    }
    
    //Gets Pokemon Type
    private static type getType(int typeIndex) 
    {
        return type.getTypeList()[typeIndex];
    }
    
}