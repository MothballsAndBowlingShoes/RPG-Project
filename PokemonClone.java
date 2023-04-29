public class PokemonClone
{
    public static void main(String[] args)
    {
        player.addPartyMember("Piss Rat", 5, 30, entity.getType(0), 255, 255, 255);
        //trainerIDs.test.addPartyMember();
        trainerIDs.test.enemyParty[0].addMoves(moveIDs.flamethrower);
        System.out.println(battle.getCurrentEnemyEntity().getName());
        battle.callBattle(trainerIDs.test);
    }
    
    
}