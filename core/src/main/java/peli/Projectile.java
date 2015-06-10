package peli;

import libraries.GameObject;

public class Projectile extends GameObject {

    private float speed;
    private int damage;
    private SpaceShip owner;
    public Projectile(float x, float y, float angle, Weapon weapon, SpaceShip owner) {
        super(x, y, weapon.getProjectileImage());
        this.angle = angle;
        this.speed = weapon.getProjectileSpeed();
        this.damage = weapon.getDamage();
        this.owner = owner;
    }

    @Override
    public void move() {
        this.moveForward(this.speed);
    }

    public int getDamage() {
        return damage;
    }
    
    public SpaceShip getOwner() {
        return owner;
    }
    
}
