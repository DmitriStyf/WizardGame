package com.wizard;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WizardShop {
    Spells spells = new Spells();

    public void printAllSpells() {
        for (Map.Entry<String, Spell> entry : spells.getSpellList().entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue().getSpellPrice());
        }
    }

    public void buySpells(String requestedSpell, Wizard wizard) {
        if (spells.getSpellList().containsKey(requestedSpell)) {
            // check if this spell exists
            if (wizard.getKnowledgeList().contains(requestedSpell)) {
                System.out.println("This spell already exists in your spell book choose different spell");
            } else {
                if (spells.getSpellList().get(requestedSpell).getSpellPrice() <= wizard.getMoney()) {
                    wizard.getKnowledgeList().add(requestedSpell);
                    int updatedMoney = wizard.getMoney() - spells.getSpellList().get(requestedSpell).getSpellPrice();
                    wizard.setMoney(updatedMoney);
                } else {
                    System.out.println("You don't have enough money ");
                }
            }
        } else{
            System.out.println("This Spell doesn't exists in the shop");
        }
    }
}