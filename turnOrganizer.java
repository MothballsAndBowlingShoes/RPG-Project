import java.util.Scanner;

public class turnOrganizer {

    private static Scanner input = new Scanner(System.in);

    static entity currentPlayerEntity;

    public static void turnMenu()
    {
        //sets currentEntity to whatever the first member of your party is
        currentPlayerEntity = player.getPartyMember(0);
        //battle.currentEnemy.getEnemyParty()[0] = currentEnemy.getEnemyPartyMember(0);
        System.out.println("What do you want to do?");
        System.out.println("|Attack (1)|Item (2)|Switch Party Member (3)");

        int choice = input.nextInt();

        if(choice == 1)
        {
            currentPlayerEntity.printKnownMoves();
            currentPlayerEntity.executeMove(battle.currentEnemyEntity);
            
        } else if(choice == 2) {
            player.printBag();
            System.out.println("What item do you want to use?");
            choice = input.nextInt();
            
        } else if(choice == 3) {
            System.out.println("Who do you want to switch to?");
            player.printParty();
        }

    }
}
