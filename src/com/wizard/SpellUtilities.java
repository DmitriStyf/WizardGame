package com.wizard;

import java.util.Random;

public class SpellUtilities {
    Spells spells = new Spells();


    public int randomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public int castDamage(String nameOfSpell) {
        Random random = new Random();
        int successChance = random.nextInt(100);
        if (successChance < spells.getSpellList().get(nameOfSpell).getSuccessRate()) {
            System.out.println(nameOfSpell + " casted successful !");
            return randomNumberInRange(spells.getSpellList().get(nameOfSpell).getSpellPowerMin(),
                    spells.getSpellList().get(nameOfSpell).getSpellPowerMax());
        } else {
            System.out.println(nameOfSpell + " cast failed !");
        }
        return 0;
    }

    public int channelHealing(String nameOfSpell) {
        Random random = new Random();
        int successChance = random.nextInt(100);
        int updatedSuccessRate = spells.getSpellList().get(nameOfSpell).getSuccessRate();
        int healingDone = 0;
        if (successChance < spells.getSpellList().get(nameOfSpell).getSuccessRate()) { //50 <70
            System.out.println(nameOfSpell + " casted successful !");
            while (updatedSuccessRate > successChance) {// 40>70
                successChance = random.nextInt(100);
                int healingAmount = randomNumberInRange(spells.getSpellList().get(nameOfSpell).getSpellPowerMin(),
                        spells.getSpellList().get(nameOfSpell).getSpellPowerMax());
                int channeldeduct = randomNumberInRange(5, 10);
                healingDone = healingDone + healingAmount;
                updatedSuccessRate = updatedSuccessRate - channeldeduct;
                System.out.println("Channeled " + healingAmount + " healing");
            }
            System.out.println("Total healing done " + healingDone);
            return healingDone;
        } else {
            System.out.println(nameOfSpell + " cast failed !");
        }
        return 0;
    }

}