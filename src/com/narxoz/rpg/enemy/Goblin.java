package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class Goblin implements Enemy {
    private String name;
    private int health;
    private int maxHealth;
    private int damage;
    private int defense;
    private int speed;
    private String element = "NONE";

    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;
    private String aiBehavior = "NEUTRAL";


    public Goblin(String name, int health, int damage, int defense, int speed,
                  List<Ability> abilities, LootTable lootTable, String aiBehavior) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities.addAll(abilities);
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
    }


    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getMaxHealth() { return maxHealth; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }
    @Override public String getElement() { return element; }
    @Override public List<Ability> getAbilities() { return new ArrayList<>(abilities); }
    @Override public LootTable getLootTable() { return lootTable; }
    @Override public String getAIBehavior() { return aiBehavior; }

    @Override
    public void takeDamage(int amount) {
        int reduced = Math.max(0, amount - defense);
        health = Math.max(0, health - reduced);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String displayInfo() {
        return String.format("%s (HP: %d/%d, Dmg: %d, Element: %s, AI: %s)",
                name, health, maxHealth, damage, element, aiBehavior);
    }


    @Override
    public Enemy clone() {
        Goblin copy = new Goblin(
                this.name + " (clone)",
                this.health,
                this.damage,
                this.defense,
                this.speed,
                new ArrayList<>(this.abilities),
                this.lootTable.clone(),
                this.aiBehavior
        );


        copy.abilities.clear();
        for (Ability ability : this.abilities) {
            copy.abilities.add(ability.clone());
        }

        copy.element = this.element;
        return copy;
    }


    public void multiplyStats(double factor) {
        this.maxHealth = (int) (this.maxHealth * factor);
        this.health = this.maxHealth;
        this.damage = (int) (this.damage * factor);

    }
}