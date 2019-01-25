package com.wizard;

import java.util.Random;

public class Opponent extends Wizard {
    Spells spells = new Spells();

    public String decideSpellName(Wizard player1, Wizard opponent) {
        Random randomChance = new Random();
        int decideHealorDmg = randomChance.nextInt(100);
        if (opponent.getHealth() < 45) {
            if (decideHealorDmg > 50) {
                if (player1.getHealth() < 11) {
                    return "Lacarnum Inflamarae";
                } else if (player1.getHealth() < 17) {
                    return "Lumos Solem";
                } else if (player1.getHealth() < 23) {
                    return "Everte Statum";
                } else if (player1.getHealth() < 30) {
                    return "Avada Kedavra";
                } else if (player1.getHealth() < 65) {
                    return "Arania Exumai";
                } else {
                    return "Vulnera Sanentur";
                }
            } else {
                return "Vulnera Sanentur";
            }
        } else if (opponent.getHealth() > player1.getHealth()) {
            if (25 > decideHealorDmg) {
                return "Lumos Solem";
            } else if (25 > decideHealorDmg) {
                return "Arania Exumai";
            } else if (25 > decideHealorDmg) {
                return "Everte Statum";
            } else if (25 > decideHealorDmg) {
                return "Lumos Solem";
            }

        } else {
            if (20 > decideHealorDmg) {
                return "Lumos Solem";
            } else if (15 > decideHealorDmg) {
                return "Arania Exumai";
            } else if (20 > decideHealorDmg) {
                return "Everte Statum";
            } else if (25 > decideHealorDmg) {
                return "Lacarnum Inflamarae";
            } else if (20 > decideHealorDmg) {
                return "Vulnera Sanentur";
            }
        }
        return null;
    }
}
