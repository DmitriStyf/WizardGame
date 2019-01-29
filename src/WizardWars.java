import com.wizard.*;

import java.nio.file.OpenOption;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WizardWars {

    public static void main(String[] args) {
        WizardShop wizardShop = new WizardShop();
        Opponent snake = new Opponent();
        snake.setName("SNAKE");
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
        while (true) {
            System.out.println("What spell do you want to buy, type Done when finished buying");
            String buyspell = scanner.nextLine();
            if (wizard.getMoney() <= 0 || buyspell.equalsIgnoreCase("done")) {
                break;
            } else {
                wizardShop.buySpells(buyspell, player1);
                System.out.println("You have " + player1.getMoney() + " gold left ");
                if (wizard.getMoney() <= 0) {
                    break;
                }

            }
        }

        System.out.println("Thank you for shopping, you have bought: ");
        System.out.println(player1.getKnowledgeList());

        System.out.println("LETS DUEL");
        System.out.println("Your opponent is " + snake.getName());
        System.out.println("Choose what spell you want to cast");
        System.out.println(player1.getKnowledgeList());

        while (player1.getHealth() > 0 || snake.getHealth() > 0) {
            String pCastingSpell = scanner.nextLine();
            String snakeCastSpell = snake.decideSpellName(player1, snake);
            int daySpeedSpell = spells.getSpellList().get(pCastingSpell).getSpellSpeed();
            int snakeSpeedSpell = spells.getSpellList().get(snakeCastSpell).getSpellSpeed();
            if (player1.getKnowledgeList().contains(pCastingSpell)) {
                if (daySpeedSpell > snakeSpeedSpell) {
                    System.out.println(player1.getName() + " Spell is faster. Casting: " + pCastingSpell);
                    if (pCastingSpell.equalsIgnoreCase("Vulnera Sanentur")) {
                        int healing = spellUtilities.channelHealing(pCastingSpell);
                        player1.setHealth(player1.getHealth() + healing);
                        player1.healthRounder();
                        System.out.println(player1.getName() + " healed " + healing + " hp");
                    } else {
                        int damage = spellUtilities.castDamage(pCastingSpell);
                        snake.setHealth(snake.getHealth() - damage);
                        System.out.println(player1.getName() + " did " + damage + " damage");
                    }
                    if (player1.getHealth() < 1 || snake.getHealth() < 1) {
                        break;
                    }
                    if (snakeCastSpell.equalsIgnoreCase("Vulnera Sanentur")) {
                        int healing = spellUtilities.channelHealing(snakeCastSpell);
                        snake.setHealth(snake.getHealth() + healing);
                        snake.healthRounder();
                        System.out.println(snake.getName() + " healed " + healing + " hp");
                    } else {
                        int damage = spellUtilities.castDamage(snakeCastSpell);
                        player1.setHealth(player1.getHealth() - damage);
                        System.out.println(snake.getName() + " did " + damage + " damage");
                    }
                    System.out.println(player1.getName() + " have " + player1.getHealth() + " health left");
                    System.out.println(snake.getName() + " have " + snake.getHealth() + " health left");
                } else if (daySpeedSpell < snakeSpeedSpell) {
                    System.out.println(snake.getName() + " spell is faster. Casting: " + snakeCastSpell);
                    if (snakeCastSpell.equalsIgnoreCase("Vulnera Sanentur")) {
                        int healing = spellUtilities.channelHealing(snakeCastSpell);
                        snake.setHealth(snake.getHealth() + healing);
                        snake.healthRounder();
                        System.out.println(snake.getName() + " healed " + healing + " hp");
                    } else {
                        int damage = spellUtilities.castDamage(snakeCastSpell);
                        player1.setHealth(player1.getHealth() - damage);
                        System.out.println(snake.getName() + " did " + damage + " damage");
                    }
                    if (player1.getHealth() < 1 || snake.getHealth() < 1) {
                        break;
                    }
                    if (pCastingSpell.equalsIgnoreCase("Vulnera Sanentur")) {
                        int healing = spellUtilities.channelHealing(pCastingSpell);
                        player1.setHealth(player1.getHealth() + healing);
                        player1.healthRounder();
                        System.out.println(player1.getName() + " healed " + healing + " hp");
                    } else {
                        int damage = spellUtilities.castDamage(pCastingSpell);
                        snake.setHealth(snake.getHealth() - damage);
                        System.out.println(player1.getName() + " did " + damage + " damage");
                    }
                    System.out.println(player1.getName() + " have " + player1.getHealth() + " health left");
                    System.out.println(snake.getName() + " have " + snake.getHealth() + " health left");
                } else {
                    int decideHealorDmg = spellUtilities.randomNumberInRange(0, 50);
                    if (daySpeedSpell >= decideHealorDmg) {
                        System.out.println(player1.getName() + " Spell is faster. Casting: " + pCastingSpell);
                        if (pCastingSpell.equalsIgnoreCase("Vulnera Sanentur")) {
                            int healing = spellUtilities.channelHealing(pCastingSpell);
                            player1.setHealth(player1.getHealth() + healing);
                            player1.healthRounder();
                            System.out.println(player1.getName() + " healed " + healing + " hp");
                        } else {
                            int damage = spellUtilities.castDamage(pCastingSpell);
                            snake.setHealth(snake.getHealth() - damage);
                            System.out.println(player1.getName() + " did " + damage + " damage");
                        }
                        if (player1.getHealth() < 1 || snake.getHealth() < 1) {
                            break;
                        }
                        if (snakeCastSpell.equalsIgnoreCase("Vulnera Sanentur")) {
                            int healing = spellUtilities.channelHealing(snakeCastSpell);
                            snake.setHealth(snake.getHealth() + healing);
                            snake.healthRounder();
                            System.out.println(snake.getName() + " healed " + healing + " hp");
                        } else {
                            int damage = spellUtilities.castDamage(snakeCastSpell);
                            player1.setHealth(player1.getHealth() - damage);
                            System.out.println(snake.getName() + " did " + damage + " damage");
                        }
                        if (player1.getHealth() < 1 || snake.getHealth() < 1) {
                            break;
                        }
                    } else {
                        System.out.println(snake.getName() + " Spell is faster. Casting: " + snakeCastSpell);
                        if (snakeCastSpell.equalsIgnoreCase("Vulnera Sanentur")) {
                            int healing = spellUtilities.channelHealing(snakeCastSpell);
                            snake.setHealth(snake.getHealth() + healing);
                            snake.healthRounder();
                            System.out.println(snake.getName() + " healed " + healing + " hp");
                        } else {
                            int damage = spellUtilities.castDamage(snakeCastSpell);
                            player1.setHealth(player1.getHealth() - damage);
                            System.out.println(snake.getName() + " did " + damage + " damage");
                        }
                        if (player1.getHealth() < 1 || snake.getHealth() < 1) {
                            break;
                        }
                        if (pCastingSpell.equalsIgnoreCase("Vulnera Sanentur") ) {
                            int healing = spellUtilities.channelHealing(pCastingSpell);
                            player1.setHealth(player1.getHealth() + healing);
                            player1.healthRounder();
                            System.out.println(player1.getName() + " healed " + healing + " hp");
                        } else {
                            int damage = spellUtilities.castDamage(pCastingSpell);
                            snake.setHealth(snake.getHealth() - damage);
                            System.out.println(player1.getName() + " did " + damage + " damage");
                        }

                    }
                    System.out.println(player1.getName() + " have " + player1.getHealth() + " left");
                    System.out.println(snake.getName() + " have " + snake.getHealth() + " left");
                }
            } else if (pCastingSpell.equalsIgnoreCase("print")) {
                System.out.println(player1.getKnowledgeList());
            }else{
                System.out.println("You don't know this spell");
            }
            if (player1.getHealth() < 1 || snake.getHealth() < 1) {
                break;
            }
        }
        if (snake.getHealth() > player1.getHealth()) {
            System.out.println("SNAKE WON THE GAME !!");
        } else {
            System.out.println(player1.getName() + " WON THE GAME");
        }
    }
}