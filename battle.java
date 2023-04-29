public class battle {
    private static int turn;
    private static Boolean win;

    static enemy currentEnemy;
    public static entity currentEnemyEntity;

    private static entity currentPlayerEntity;

    public static void callBattle(enemy enemyPlayer)
    {
        

        currentPlayerEntity = player.getPartyMember(0);

        turn = 1;
        win = false;
        
        
        while(win != true)
        {
            whosTurn();
            turn++;

            if(enemyPlayer.enemyParty[0].getHP() <= 0)
            {
                win = true;
                System.out.println("You Win");
            }
        }



    }

    public static void whosTurn()
    {
        if(turn % 2 != 0)
        {
            turnOrganizer.turnMenu();
        } else {
            battleAI.ai();
        }
    }

    public static entity getCurrentEnemyEntity()
    {
        return currentEnemyEntity;
    }

    public static enemy getCurrentEnemy()
    {
        return currentEnemy;
    }

    public static entity getCurrentPlayerEntity() {
        return currentPlayerEntity;
    }
}
