

public class potions extends item{

    int healingValue;
    String name;
    
    public potions(int id, int healingValue, String name) {
        super(id, "name");
        this.healingValue = healingValue;
        this.name = name;
    }

    public void affect() {
        battle.currentEnemy.enemyParty[0].setHP(battle.currentEnemy.enemyParty[0].getHP() + healingValue);
    }

    public String getName() {
        return name;
    }
    
}
