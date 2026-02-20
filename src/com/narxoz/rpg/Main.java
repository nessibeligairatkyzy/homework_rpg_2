package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.prototype.EnemyRegistry;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - 4 Creational Patterns Demo ===\n");


        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();


        System.out.println("1. Abstract Factory - themed components");
        System.out.println("  Fire: " + fireFactory.createAbilities().stream().map(Ability::getName).toList()
                + " | Loot: " + fireFactory.createLootTable().getItems()
                + " | AI: " + fireFactory.createAIBehavior());
        System.out.println("  Ice:  " + iceFactory.createAbilities().stream().map(Ability::getName).toList()
                + " | Loot: " + iceFactory.createLootTable().getItems()
                + " | AI: " + iceFactory.createAIBehavior());
        System.out.println();


        System.out.println("2. Builder Pattern - fluent construction");
        Enemy basicGoblin = new BasicEnemyBuilder()
                .setName("Basic Goblin")
                .setHealth(100)
                .setDamage(15)
                .setDefense(5)
                .setSpeed(10)
                .setElement("NONE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAIBehavior("NEUTRAL")
                .build();

        System.out.println("  Basic: " + basicGoblin.displayInfo());

        Enemy raidBoss = new BossEnemyBuilder()
                .setName("Fire Raid Boss")
                .setHealth(20000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(70)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAIBehavior(fireFactory.createAIBehavior())
                .build();

        System.out.println("  Boss:  " + raidBoss.displayInfo());
        System.out.println();


        System.out.println("3. Director - preset enemy creation");
        EnemyDirector director = new EnemyDirector(new BasicEnemyBuilder());

        Enemy minion = director.createMinion(iceFactory);
        System.out.println("  Minion (Ice): " + minion.displayInfo());

        Enemy elite = director.createElite(shadowFactory);
        System.out.println("  Elite (Shadow): " + elite.displayInfo());

        Enemy raid = director.createRaidBoss(fireFactory);
        System.out.println("  Raid Boss (Fire): " + raid.displayInfo());
        System.out.println();


        System.out.println("4. Prototype & Registry - cloning from templates");
        EnemyRegistry registry = new EnemyRegistry();

        registry.registerTemplate("ice_minion", minion);
        registry.registerTemplate("shadow_elite", elite);
        registry.registerTemplate("fire_raid_boss", raid);

        registry.listTemplates();

        Enemy clonedMinion = registry.createFromTemplate("ice_minion");
        System.out.println("  Cloned Minion: " + clonedMinion.displayInfo());

        Enemy clonedRaid = registry.createFromTemplate("fire_raid_boss");
        System.out.println("  Cloned Raid Boss: " + clonedRaid.displayInfo());

        System.out.println("\n=== Demo complete ===");
        System.out.println("Patterns shown:");
        System.out.println(" - Abstract Factory: themed parts");
        System.out.println(" - Builder: step-by-step creation");
        System.out.println(" - Factory Method: in build()");
        System.out.println(" - Prototype: cloning via registry");
    }
}