import com.wizard.*;

import java.util.Scanner;
import java.util.regex.Pattern;

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
        Opponent opponent = new Opponent();
        int test = wizard.getHealth()-spellUtilities.channelHealing("Lacarnum Inflamarae");
        System.out.println("Total health " +test);

        opponent.decideSpellName(player1,opponent);
        System.out.println(opponent.decideSpellName(player1,opponent));



    }


}

/**
 * create class Opponent (Check internet what is inheritance in java)
 *
 * decideSpellName 2 Wizard object one is the opponent and other is the player object
 * it will return spellName (String)
 */

        /**
*         * Task1: If health of opponent below 45
 *         * 50% change to cast healing
 *         * 50% there will be below decision
 *         * he will get players health
 *         * if playerHealth is below 11 he will castFlame
 *         * else if playerHealth is below 17 he will castLightening
 *         * else if playerHealth is below 23 he will castWind
 *         * else if playerHealth is below 30 he will castFireball
 *         * else if playerHealth is below 65 he will castDeath
 *         * else castHealing
 *
 *        Lacarnum Inflamarae   Flame
         *        //Lumos Solem           Lightening
         *        //Everte Statum         Wind
         *        //Arania Exumai         Fireball
         *        //Avada Kedavra         Death
         *        //Vulnera Sanentur      Healing
         *          /**
  *                     *  Task2: If health of opponent bigger than the player
  *                     *          25% change to castLightening
  *                     *          25% to castFireball
  *                     *          25% to castWind
  *                     *          25% to castFlmae
  *                     *
  *                     */
/**
  *             *  Task3: rest of the conditions
  *             *          20% change to castLightening
  *             *          15% to castFireball
  *             *          20% to castWind
  *             *          25% to castFlame
  *             *          20% to cast healing
  *
 */
