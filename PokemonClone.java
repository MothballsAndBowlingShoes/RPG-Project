public class PokemonClone
{
    public static void main(String[] args)
    {
        player.addPartyMember(entityID.gardevoir);
        //trainerIDs.test.addPartyMember();
        trainerIDs.test.enemyParty[0].addMoves(moveIDs.flamethrower);
        System.out.println(battle.getCurrentEnemyEntity().getName());
        battle.callBattle(trainerIDs.test);
    }
    
    
}