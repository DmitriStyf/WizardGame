package com.wizard;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wizard {
    private String name;
    private String surname;
    private int health = 100;
    private int money = 100;
    private List<String> knowledgeList = new ArrayList<>();

    public List<String> getKnowledgeList() {
        return knowledgeList;
    }

    public void setKnowledgeList(List<String> knowledgeList) {
        this.knowledgeList = knowledgeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void insertSpell(String incomingSpell) {
        knowledgeList.add(incomingSpell);// mozhno bqlo prosot sdelatj get.spell i add
    }

    public void healthRounder() {
        if (health > 100) {
            this.health = 100;
        }
        if (health < 0) {
            this.health = 0;
        }
    }
}