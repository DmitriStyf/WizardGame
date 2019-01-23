package com.wizard;

import java.util.*;

public class Spells {
    private Map<String, Spell> spellList = new HashMap<>();


    public Spells() {

        spellList.put("Lacarnum Inflamarae", new Spell("Lacarnum Inflamarae", 25, 10, 16, 70, 1));
        spellList.put("Lumos Solem", new Spell("Lumos Solem", 45, 17, 23, 65, 2));
        spellList.put("Everte Statum", new Spell("Everte Statum", 45, 23, 29, 60, 3));
        spellList.put("Arania Exumai", new Spell("Arania Exumai", 50, 30, 36, 55, 4));
        spellList.put("Avada Kedavra", new Spell("Avada Kedavra", 100, 100, 100, 10, 5));
        spellList.put("Vulnera Sanentur", new Spell("Vulnera Sanentur", 25, 10, 20, 70, 1));

    }
    public void printAllSpells() {
        for (int counter = 0; counter < spellList.size(); counter++) {
            System.out.println(spellList.get().getSpellName() + spellList.get().getSpellPrice())));
        }
    }

    public Spell getSpell(String spell) {
        for (Map.Entry<String, Spell> someSpellName : spellList.entrySet()) {
            if (someSpellName.getKey().equalsIgnoreCase(spell)) {
                return spellList.get(spell);
            }
        }
        System.out.println("Error");
        return null;
    }
}
