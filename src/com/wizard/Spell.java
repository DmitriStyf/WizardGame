package com.wizard;

import java.util.Objects;

public class Spell {
    private String spellName;
    private double spellPrice;
    private int spellPowerMin;
    private int spellPowerMax;
    private int successRate;
    private int spellSpeed;

    public Spell(String spellName, double spellPrice, int spellDamageMin, int spellDamageMax, int successRate, int spellSpeed) {
        this.spellName = spellName;
        this.spellPrice = spellPrice;
        this.spellPowerMin = spellDamageMin;
        this.spellPowerMax = spellDamageMax;
        this.successRate = successRate;
        this.spellSpeed = spellSpeed;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public double getSpellPrice() {
        return spellPrice;
    }

    public void setSpellPrice(double spellPrice) {
        this.spellPrice = spellPrice;
    }

    public int getSpellPowerMin() {
        return spellPowerMin;
    }

    public void setSpellPowerMin(int spellPowerMin) {
        this.spellPowerMin = spellPowerMin;
    }

    public int getSpellPowerMax() {
        return spellPowerMax;
    }

    public void setSpellPowerMax(int spellPowerMax) {
        this.spellPowerMax = spellPowerMax;
    }

    public int getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(int successRate) {
        this.successRate = successRate;
    }

    public int getSpellSpeed() {
        return spellSpeed;
    }

    public void setSpellSpeed(int spellSpeed) {
        this.spellSpeed = spellSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spell spell = (Spell) o;
        return Double.compare(spell.spellPrice, spellPrice) == 0 &&
                spellPowerMin == spell.spellPowerMin &&
                spellPowerMax == spell.spellPowerMax &&
                successRate == spell.successRate &&
                spellSpeed == spell.spellSpeed &&
                Objects.equals(spellName, spell.spellName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spellName, spellPrice, spellPowerMin, spellPowerMax, successRate, spellSpeed);
    }
}

