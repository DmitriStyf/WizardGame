package com.wizard;

import javax.swing.*;
import java.util.ArrayList;

public class Wizard {
    private String name;
    private String surname;
    private int health;
    private int money;
    private ArrayList<String> knowledgeList = new ArrayList<>();


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

    public ArrayList<String> getKnowledgeList() {
        return knowledgeList;
    }

    public void setKnowledgeList(ArrayList<String> knowledgeList) {
        this.knowledgeList = knowledgeList;
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
        knowledgeList.add(incomingSpell);
    }
}