/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peli;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Weapon {
    private int coolDown;
    private int timer;
    private Sprite projectileImage;
    private int damage;
    private float projectileSpeed;
    
    public Weapon(Sprite projectileImage, int damage, int coolDown, float projectileSpeed) {
        this.projectileImage = projectileImage;
        this.damage = damage;
        this.coolDown = coolDown;
        this.projectileSpeed = projectileSpeed;
    }
    
    public boolean fire() {
        if (this.timer > 0) {
            return false;
        }
        this.timer = coolDown;
        return true;
    }

    public Sprite getProjectileImage() {
        return projectileImage;
    }

    public int getDamage() {
        return damage;
    }
    
    public void countDown() {
        if (this.timer > 0) {
            this.timer--;
        }
    }

    public float getProjectileSpeed() {
        return projectileSpeed;
    }
    
}
