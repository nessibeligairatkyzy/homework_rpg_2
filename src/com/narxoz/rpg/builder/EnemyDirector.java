package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    private final EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createMinion(EnemyComponentFactory factory) {
        return builder
                .setName("Minion")
                .setHealth(120)
                .setDamage(20)
                .setDefense(6)
                .setSpeed(12)
                .setElement("NONE")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAIBehavior(factory.createAIBehavior())
                .build();
    }

    public Enemy createElite(EnemyComponentFactory factory) {
        return builder
                .setName("Elite " + factory.getClass().getSimpleName().replace("ComponentFactory", ""))
                .setHealth(300)
                .setDamage(50)
                .setDefense(20)
                .setSpeed(25)
                .setElement(factory.getClass().getSimpleName().contains("Fire") ? "FIRE" :
                        factory.getClass().getSimpleName().contains("Ice") ? "ICE" : "SHADOW")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAIBehavior(factory.createAIBehavior())
                .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Raid Boss " + factory.getClass().getSimpleName().replace("ComponentFactory", ""))
                .setHealth(15000)
                .setDamage(400)
                .setDefense(150)
                .setSpeed(60)
                .setElement(factory.getClass().getSimpleName().contains("Fire") ? "FIRE" :
                        factory.getClass().getSimpleName().contains("Ice") ? "ICE" : "SHADOW")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAIBehavior(factory.createAIBehavior())
                .build();
    }
}