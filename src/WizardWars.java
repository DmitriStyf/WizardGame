import com.wizard.CharacterCreation;
import com.wizard.Wizard;

import java.util.Scanner;

public class WizardWars {

    public static void main(String[] args) {
        CharacterCreation characterCreation = new CharacterCreation();
        System.out.println("Welcome to WizardWars. Lets create our character");
        Wizard player = new Wizard();
        Scanner scanner = new Scanner(System.in);

        while (player.getName() == null || player.getName().isEmpty()) {
            System.out.println("Please enter your character first name");
            String incomingFirstName = scanner.nextLine();
            if (characterCreation.validateName(incomingFirstName)) {
                player.setName(incomingFirstName);
            }
        }
        while (player.getSurname() == null || player.getSurname().isEmpty()) {
            System.out.println("Please enter your character surname");
            String incomingSurname = scanner.nextLine();
            if (characterCreation.validateSurname(incomingSurname)) {
                player.setSurname(incomingSurname);
            }
        }

        System.out.println("So " + player.getName()+ " "+player.getName()+" are you are ready to play?");
    }

}
