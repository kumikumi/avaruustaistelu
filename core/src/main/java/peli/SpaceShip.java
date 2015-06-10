/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peli;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import libraries.GameObject;

public class SpaceShip extends GameObject {

    private int forwardKey;
    private int backwardKey;
    private int leftKey;
    private int rightKey;
    private int fireKey;

    private int health;
    private int score;
    
    private float speed;

    private Weapon weapon;

    public SpaceShip(float x, float y, Sprite img) {
        super(x, y, img);
    }

    public void setKeys(int forwardKey, int backwardKey, int leftKey, int rightKey, int fireKey) {
        this.forwardKey = forwardKey;
        this.backwardKey = backwardKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.fireKey = fireKey;
        }
    
    public void respawn(float x, float y) {
        setX(x);
        setY(y);
        this.speed = 0;
        this.angle = 0;
        this.health = 100;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void move() {
        if (Gdx.input.isKeyPressed(forwardKey)) {
            this.speed += 1;
        }
        if (Gdx.input.isKeyPressed(backwardKey)) {
            this.speed -= 0.5;
        }

        if (Gdx.input.isKeyPressed(leftKey)) {
            this.angle -= 0.05;
        }

        if (Gdx.input.isKeyPressed(rightKey)) {
            this.angle += 0.05;
        }

        if (Gdx.input.isKeyPressed(fireKey)) {
            if (this.weapon.fire()) {
                Projectile ammus = new Projectile(this.getX(), this.getY(), this.angle, this.weapon, this);
                ammus.moveForward(30);
                ((GameScene)MyGame.sceneManager.getCurrentScene()).addProjectile(ammus);
            }
        }

        this.moveForward(speed);
        this.speed = this.speed * 0.9f;
        this.weapon.countDown();
    }

    public void takeDamage(int damage) {
        this.health-=damage;
        System.out.println("health: " + this.health);
    }
    
    public int getHealth(){
        return this.health;
    }
    
}
