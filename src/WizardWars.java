import com.wizard.*;

import java.util.Scanner;

public class WizardWars {

    public static void main(String[] args) {
        WizardShop wizardShop = new WizardShop();
        Spells spells = new Spells();
        SpellUtilities spellUtilities = new SpellUtilities();
        Wizard wizard = new Wizard();
        CharacterCreation characterCreation = new CharacterCreation();
        System.out.println("Welcome to WizardWars. Lets create our character");
        Wizard player1 = new Wizard();
        Scanner scanner = new Scanner(System.in);

        while (player1.getName() == null || player1.getName().isEmpty()) {
            System.out.println("Please enter your character first name");
            String incomingFirstName = scanner.nextLine();
            if (characterCreation.validateName(incomingFirstName)) {
                player1.setName(incomingFirstName);
            }
        }
        while (player1.getSurname() == null || player1.getSurname().isEmpty()) {
            System.out.println("Please enter your character surname");
            String incomingSurname = scanner.nextLine();
            if (characterCreation.validateSurname(incomingSurname)) {
                player1.setSurname(incomingSurname);
            }
        }
        System.out.println("So " + player1.getName() + " " + player1.getSurname() + " are you are ready to play?");


        wizardShop.printAllSpells();
        System.out.println("What spell do you want to buy");
        String buyspell = scanner.nextLine();

        wizardShop.buySpells(buyspell, player1);
        System.out.println(player1.getKnowledgeList());
        System.out.println(player1.getMoney());
        spellUtilities.randomNumberInRange(spells.getSpellList().get("Lacarnum Inflamarae").getSpellPowerMin(),
                spells.getSpellList().get("Lacarnum Inflamarae").getSpellPowerMax());


    }


}

/**
 * MOI KOD
 * Spells spells = new Spells();
 * System.out.println(spells.getSpell("Avada Kedavra"));
 * Wizard wizard = new Wizard();
 * <p>
 * <p>
 * wizard.insertSpell("Avada Kedavra");
 */
