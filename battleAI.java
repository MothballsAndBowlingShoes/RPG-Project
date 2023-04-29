public class battleAI extends battle {
    
    public static void ai()
    {
        for(int i = 0; i < getCurrentEnemy().getBag().size(); i++)
        {
            if((currentEnemyEntity.getHP() / currentEnemyEntity.getMaxHP()) * 100 <= 25)
            {
                if(getCurrentEnemy().getBag().get(i).getID() == itemIDs.normal_potion.getID())
                {
                    battle.currentEnemy.useItem(itemIDs.normal_potion); 
                } else {
                    getCurrentEnemyEntity().NPC_executeMove();
                }   
            } else {
                getCurrentEnemyEntity().NPC_executeMove();
            }
         }
    }
}
