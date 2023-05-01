import java.util.ArrayList;
import java.util.*;
import java.util.Random;

public class enemy {
    public entity[] enemyParty = new entity[4];
    private int partySize;
    Random rand = new Random();

    private ArrayList<item> bag = new ArrayList<item>(List.of(itemIDs.normal_potion));

    public enemy()
    {   
        this.intilizeEnemy();
        battle.currentEnemy = this;
        battle.currentEnemyEntity = this.enemyParty[0];
    }

    public void addPartyMember()
    {
        
        for(int i = 0; i < 4; i++)
        {
            if(enemyParty[i] == null)
            {
                enemyParty[i] = entityID.Piss_Rat;
                partySize = i;
                break;
            }
        }
    }

    public entity getEnemyPartyMember(int index)
    {
        return enemyParty[index];
    }

    public void printParty()
    {
        for(int i = 0; i < partySize + 1; i++)
        {
            System.out.println(i + 1 + ". " + enemyParty[i].getName());
        }
    }

    public item getBagContents(int index)
    {
        return bag.get(index);
    }

    public void useItem(item desiredItem)
    {
        for(int i = 0; i < bag.size(); i++)
        {
            if(bag.get(i).getID() == desiredItem.getID())
            {
                if(rand.nextBoolean() == true)
                {
                    System.out.println(battle.currentEnemyEntity.getName() + " used " + desiredItem.getName());
                    desiredItem.affect();
                    bag.remove(i);
                }
            }
        }
    }

    public ArrayList<item> getBag()
    {
        return bag;
    }

    public entity[] getEnemyParty()
    {
        return this.enemyParty;
    }

    public void setEnemyParty(entity[] party)
    {
        this.enemyParty = party;
    }

    public void intilizeEnemy()
    {
        enemyParty[0] = entityID.Piss_Rat;
        enemyParty[1] = entityID.Piss_Rat;
        enemyParty[2] = entityID.Piss_Rat;
        enemyParty[3] = entityID.Piss_Rat;
    }

    public boolean checkBag()
    {
        for(int i = 0; i < battle.getCurrentEnemy().getBag().size(); i++)
        {
            if(battle.getCurrentEnemy().getBag().get(i).getID() == itemIDs.normal_potion.getID())
            {
                battle.currentEnemy.useItem(itemIDs.normal_potion);
                return true;
            }
        }
        return false;
    }
}