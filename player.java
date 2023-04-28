public class player {
    private static entity[] playerParty = new entity[4];
    private static int partySize;
    public player()
    {

    }

    public static void addPartyMember(String name, int level, int healthStat)
    {
        for(int i = 0; i < playerParty.length; i++)
        {
            if(playerParty[i] == null)
            {
                playerParty[i] = new entity(name, level, healthStat);
                playerParty[i].addMoves(0, 0, "Flame Thrower", 40);
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
}
