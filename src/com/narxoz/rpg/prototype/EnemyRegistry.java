package com.narxoz.rpg.prototype;

import com.narxoz.rpg.enemy.Enemy;

import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {
    private final Map<String, Enemy> templates = new HashMap<>();

    public void registerTemplate(String key, Enemy prototype) {
        if (prototype == null) {
            throw new IllegalArgumentException("Prototype cannot be null");
        }
        templates.put(key, prototype);
    }

    public Enemy createFromTemplate(String key) {
        Enemy prototype = templates.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("No template registered for key: " + key);
        }
        return prototype.clone();
    }

    public void listTemplates() {
        System.out.println("Registered templates (" + templates.size() + "):");
        for (String key : templates.keySet()) {
            System.out.println(" - " + key + " (" + templates.get(key).getClass().getSimpleName() + ")");
        }
    }
}