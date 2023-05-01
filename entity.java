import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.util.*;

public class entity {
    private static ArrayList<type> typeList = new ArrayList<type>(List.of(new type("Fire"), new type("Grass"), new type("Water")));
    private String name;
    private move [] knownMoves = new move[4];
    private int hp;
    private int level;
    private int attackStat;
    private int defenseStat;
    private type entityType;
    private int maxHP;
    private static Scanner input = new Scanner(System.in);
    private double STAB;
    Random rand = new Random();
    
    //Object for Pokemon
    public entity(String name, int level, type entityType, int hpStat, int attackStat, int defenseStat) 
    {   
        this.entityType = entityType;
        this.defenseStat = defenseStat;
        this.attackStat = attackStat;
        this.name = name;
        this.level = level;

        //calculates HP through a floor
        this.hp = (int) Math.floor(0.01 * (2 * hpStat + 31 + Math.floor(0.25 * hpStat)) * level) + level + 10;
        maxHP = (int) Math.floor(0.01 * (2 * hpStat + 31 + Math.floor(0.25 * hpStat)) * level) + level + 10;
    }

    //Adds moves to list of available moves
    public void addMoves(move move)
    {
        knownMoves[0] = move;

    }

    //Executes moves
    public void executeMove(entity target)
    {
        
        System.out.println("Select Move");

        int selectedMove = input.nextInt();
        
        System.out.println(getName() + " used " + knownMoves[selectedMove].getName() + "!");

        target.takeDamage(knownMoves[selectedMove], target);
        //System.out.println(this.getName() + " has " + this.getHP() + "Hit Points left");
        //System.out.println(target.getName() + " has " + target.getHP() + "Hit Points left");

    }

    public void NPC_executeMove()
    {
        int selectedMove = rand.nextInt(1);

        battle.getCurrentPlayerEntity().NPC_takeDamage(knownMoves[selectedMove]);
    }
    
    //Gets name of current entity
    public String getName() {
        return name;
    }

    
    //Gets Pokemon Type
    public static type getType(int typeIndex) 
    {
        return typeList.get(typeIndex);
    }

    public int getHP()
    {
        return hp;
    }

    private void takeDamage(move chosenMove, entity targetEntity)
    {
        if(entityType == chosenMove.getMoveType())
        {
            STAB = 1.5;
        } else {
            STAB = 1;
        }
        targetEntity.hp -= ((((((2 * level * rand.nextInt(3)) + 2) * chosenMove.getDamage() * attackStat/targetEntity.getDefenseStat()) / 50) + 2) * STAB);
    }

    private void NPC_takeDamage(move chosenMove)
    {
        if(entityType == chosenMove.getMoveType())
        {
            STAB = 1.5;
        } else {
            STAB = 1;
        }

        System.out.println(getName() + " used " + knownMoves[0].getName() + "!");

        battle.getCurrentPlayerEntity().hp -= Math.floor(((((((2 * this.level * rand.nextInt(3)) + 2) * chosenMove.getDamage() * this.attackStat/battle.getCurrentPlayerEntity().getDefenseStat()) / 50) + 2) * this.STAB));
        
        System.out.println(battle.getCurrentPlayerEntity().getName() + " took damage");
        
        System.out.println("you have " + battle.getCurrentPlayerEntity().getHP() + " Hit points left");
    }


    private int getDefenseStat() {
        return defenseStat;
    }

    void setHP(int result)
    {
        hp = result;
    }

    public int getMaxHP() {
        return maxHP;
    }

    

    
}