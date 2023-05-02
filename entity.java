import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.util.*;

public class entity {
    private static ArrayList<type> typeList = new ArrayList<type>(List.of(new type("Fire"), new type("Grass"), new type("Water"), new type("Striky striky thunder boi")));
    private String name;

    
    private move [] knownMoves = new move[4];
    
    private int level;

    private int hpStat;
    private int SpeedStat;
    private int AttackStat;
    private int DefenseStat;
    
    private boolean fainted;

    private type entityType;
    private int maxHP;
    private int currentHP;
    private static Scanner input = new Scanner(System.in);
    private double STAB;
    Random rand = new Random();
    
    //Object for Pokemon
    public entity(String name, int level, type entityType, int baseHpStat, int baseAttackStat, int baseDefenseStat, int baseSpeedStat, int specialAttack, int specialDefense, int hpEV, int attackEV, int defenseEV, int speedEV, int specialAttackEV, int specialDefenseEV) 
    {   
        this.SpeedStat = (2 * baseSpeedStat + 31 + (speedEV / 4) * level) / 100 + 5;
        this.DefenseStat = (2 * baseDefenseStat + 31 + (defenseEV / 4) * level) / 100 + 5;
        this.AttackStat = (2 * baseAttackStat + 31 + (attackEV / 4) * level) / 100 + 5;

        this.entityType = entityType;
        
        this.name = name;
        this.level = level;

        //calculates HP through a floor
        this.hpStat = ((2 * baseHpStat + 31 + (hpEV/4) * level) / 100 + level + 10);

        this.maxHP = (int) Math.floor(0.01 * (2 * hpStat + 31 + Math.floor(0.25 * hpStat)) * level) + level + 10;
        this.currentHP = this.maxHP;
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
        return currentHP;
    }

    private void takeDamage(move chosenMove, entity targetEntity)
    {
        if(entityType == chosenMove.getMoveType())
        {
            STAB = 1.5;
        } else {
            STAB = 1;
        }
        targetEntity.hpStat -= ((((((2 * level * rand.nextInt(3)) + 2) * chosenMove.getDamage() * AttackStat/targetEntity.getDefenseStat()) / 50) + 2) * STAB);
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

        battle.getCurrentPlayerEntity().hpStat -= Math.floor(((((((2 * this.level * rand.nextInt(3)) + 2) * chosenMove.getDamage() * this.AttackStat/battle.getCurrentPlayerEntity().getDefenseStat()) / 50) + 2) * this.STAB));
        
        System.out.println(battle.getCurrentPlayerEntity().getName() + " took damage");
        
        System.out.println("you have " + battle.getCurrentPlayerEntity().getHP() + " Hit points left");
    }


    private int getDefenseStat() {
        return DefenseStat;
    }

    void setHP(int result)
    {
        hpStat = result;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getSpeedStat()
    {
        return SpeedStat;
    }

    public boolean getFainted()
    {
        if(currentHP < 0)
        {
            fainted = true;
            return true;
        }
        return false;
    }

    public void printKnownMoves()
    {
        for(int i = 0; i <= this.knownMoves.length && knownMoves[i] == null; i++)
        {
            System.out.println(i + " . " + this.knownMoves[i].getName());
        }
    }

    
}