package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;


public class DragonBoss implements Enemy {
    private String name;
    private int health;
    private int maxHealth;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;
    private String aiBehavior;


    public DragonBoss() {
    }

    public DragonBoss(String name, int health, int damage, int defense, int speed,
                      String element, List<Ability> abilities, LootTable lootTable, String aiBehavior) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        if (abilities != null) {
            this.abilities.addAll(abilities);
        }
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getElement() {
        return element;
    }

    @Override
    public List<Ability> getAbilities() {
        return new ArrayList<>(abilities);
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    @Override
    public String getAIBehavior() {
        return aiBehavior;
    }

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
        return String.format(
                "%s (Boss) | HP: %d/%d | Dmg: %d | Def: %d | Spd: %d | Elem: %s | AI: %s | Abilities: %d",
                name, health, maxHealth, damage, defense, speed, element, aiBehavior, abilities.size()
        );
    }

    @Override
    public Enemy clone() {
        DragonBoss copy = new DragonBoss();

        copy.name = this.name;
        copy.health = this.health;
        copy.maxHealth = this.maxHealth;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.element = this.element;
        copy.aiBehavior = this.aiBehavior;

        copy.abilities = new ArrayList<>();
        for (Ability ability : this.abilities) {
            copy.abilities.add(ability.clone());
        }

        copy.lootTable = this.lootTable != null ? this.lootTable.clone() : null;

        return copy;
    }
}