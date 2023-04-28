import java.util.Scanner;

public class turnOrganizer {

    private static Scanner input = new Scanner(System.in);

    static entity currentEntity;
    public static void turnMenu()
    {
        //sets currentEntity to whatever the first member of your party is
        currentEntity = player.getPartyMember(0);

        System.out.println("What do you want to do?");
        System.out.println("|Attack (1)|Item (2)|Switch Party Member (3)|Run (4)|");

        int choice = input.nextInt();

        if(choice == 1)
        {
                currentEntity.executeMove();
        } else if(choice == 2) {
            
        } else if(choice == 3) {
            System.out.println("Who do you want to switch to?");
            player.printParty();
        } else if(choice == 4) {
            
        }

    }
}
