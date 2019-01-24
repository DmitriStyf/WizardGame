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
        }else{
            System.out.println(nameOfSpell+ " cast failed !");
        }
        return 0;
    }
}