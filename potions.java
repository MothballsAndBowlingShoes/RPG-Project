

public class potions extends item{

    int healingValue;
    
    
    public potions(int id, int healingValue) {
        super(id);
        this.healingValue = healingValue;
    }

    public void affect() {
        battle.currentEnemy.enemyParty[0].setHP(battle.currentEnemy.enemyParty[0].getHP() + healingValue);
    }
    
}
