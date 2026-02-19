package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.EnemyBuilder;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System Demo - All 4 Creational Patterns ===\n");


        System.out.println("1. Abstract Factory - Creating themed components");
        EnemyComponentFactory fireFactory = new FireComponentFactory();
        List<Ability> fireAbilities = fireFactory.createAbilities();
        LootTable fireLoot = fireFactory.createLootTable();
        String fireAI = fireFactory.createAIBehavior();

        System.out.println("  Fire theme:");
        System.out.println("    Abilities: " + fireAbilities.stream().map(Ability::getName).toList());
        System.out.println("    Loot items: " + fireLoot.getItems());
        System.out.println("    AI: " + fireAI);

        EnemyComponentFactory iceFactory = new IceComponentFactory();
        System.out.println("  Ice theme AI: " + iceFactory.createAIBehavior());

        System.out.println();


        System.out.println("2. Builder Pattern - Creating enemy with fluent interface");
        EnemyBuilder builder = new BasicEnemyBuilder();

        Enemy fireGoblin = builder
                .setName("Elite Fire Goblin")
                .setHealth(200)
                .setDamage(35)
                .setDefense(12)
                .setSpeed(18)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAIBehavior(fireFactory.createAIBehavior())
                .build();

        System.out.println("  Created: " + fireGoblin.displayInfo());

        System.out.println();


        System.out.println("3. Prototype Pattern - Cloning enemies");
        Enemy originalGoblin = fireGoblin;
        System.out.println("  Original: " + originalGoblin.displayInfo());


        Enemy cloneGoblin = originalGoblin.clone();
        System.out.println("  Clone:    " + cloneGoblin.displayInfo());


        System.out.println("  Clone is different object: " + (originalGoblin != cloneGoblin));
        System.out.println();


        System.out.println("4. DragonBoss example");
        DragonBoss dragon = new DragonBoss(
                "Ancient Fire Dragon",
                10000, 800, 300, 50,
                "FIRE",
                fireFactory.createAbilities(),
                fireFactory.createLootTable(),
                fireFactory.createAIBehavior()
        );

        System.out.println("  Original Dragon: " + dragon.displayInfo());

        Enemy dragonClone = dragon.clone();
        System.out.println("  Cloned Dragon:   " + dragonClone.displayInfo());

        System.out.println("\n=== Demo finished ===");
        System.out.println("Patterns demonstrated:");
        System.out.println(" - Abstract Factory: themed components (abilities + loot + AI)");
        System.out.println(" - Builder: fluent construction of enemies");
        System.out.println(" - Prototype: deep cloning of enemies");
        System.out.println(" - Factory Method: hidden in builder.build()");
    }
}