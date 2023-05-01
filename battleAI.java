public class battleAI extends battle {
    
    public static void ai()
    {
            if((currentEnemyEntity.getHP() / currentEnemyEntity.getMaxHP()) * 100 <= 25)
            {
                if(getCurrentEnemy().checkBag() == true)
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
