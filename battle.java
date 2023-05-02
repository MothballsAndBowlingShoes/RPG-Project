public class battle {
    private static int turn;
    private static Boolean win;

    static enemy currentEnemy;
    public static entity currentEnemyEntity;

    private static entity currentPlayerEntity;

    public static void callBattle(enemy enemyPlayer)
    {
        

        currentPlayerEntity = player.getPartyMember(0);

        turn = 0;
        win = false;
        
        
        while(win != true)
        {
            whosTurn();
            turn++;

            if(currentPlayerEntity.getFainted() == true)
            {
                System.out.println("You lost!");
                break;
            } else if(currentEnemyEntity.getFainted() == true)
            {
                win = true;
                System.out.println("You Win");
            } 
        }



    }

    public static void whosTurn()
    {
        if(turn % 2 == 0)
        {

            
        } else {
            turnOrganizer.turnMenu();
        }

        if(currentEnemyEntity.getSpeedStat() >= getCurrentPlayerEntity().getSpeedStat())
        {
            battleAI.ai();
            turnOrganizer.turnMenu();
        } else if(currentEnemyEntity.getSpeedStat() <= getCurrentPlayerEntity().getSpeedStat()) {
            turnOrganizer.turnMenu();
            battleAI.ai();
        } else {
            turnOrganizer.turnMenu();
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
