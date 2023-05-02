import java.util.ArrayList;

public class player {
    private static entity[] playerParty = new entity[4];
    private static int partySize;

    private static ArrayList<item> bag = new ArrayList<item>();

    public player()
    {

    }

    public static void addPartyMember(entity monster)
    {
        for(int i = 0; i < playerParty.length; i++)
        {
            if(playerParty[i] == null)
            {
                playerParty[i] = monster;
                playerParty[i].addMoves(moveIDs.flamethrower);
                partySize = i;
                break;
            }
        }
        
        
        
    }

    public static entity getPartyMember(int index)
    {
        return playerParty[index];
    }

    public static void printParty()
    {
        for(int i = 0; i < partySize + 1; i++)
        {
            System.out.println(i + 1 + ". " + playerParty[i].getName());
        }
    }

    public static void printBag()
    {
        if(bag.size() > 1)
        {
            for(int i = 0; i < bag.size(); i++)
            {
                System.out.println(i + "." + bag.get(i));
            }
        }
    }
}
