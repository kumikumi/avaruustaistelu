package peli;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;
import java.util.List;
import libraries.Scene;
import libraries.StaticImage;

public class GameScene extends Scene {

    private SpaceShip player1;
    private SpaceShip player2;

    private List<Projectile> projectiles;
    private List<Projectile> removedProjectiles;

    @Override
    public void initialize() {
        projectiles = new ArrayList<Projectile>();
        removedProjectiles = new ArrayList<Projectile>();

        StaticImage background = new StaticImage(0, 0, new Sprite(new Texture("assets/bg2.png")));
        addDrawable(background);
        
        Weapon kakkuAse = new Weapon(new Sprite(new Texture("assets/kakku.png")), 10, 20, 8);

        this.player1 = new SpaceShip(100, 100, new Sprite(new Texture("assets/spaceship1.png")));
        this.player1.setKeys(Keys.W, Keys.S, Keys.A, Keys.D, Keys.SPACE);
        this.player1.setWeapon(kakkuAse);
        this.player2 = new SpaceShip(200, 100, new Sprite(new Texture("assets/spaceship2.png")));
        this.player2.setKeys(Keys.UP, Keys.DOWN, Keys.LEFT, Keys.RIGHT, Keys.ENTER);
        this.player2.setWeapon(kakkuAse);

        addDrawable(player1);
        addDrawable(player2);

    }

    public void addProjectile(Projectile projectile) {
        this.projectiles.add(projectile);
        addDrawable(projectile);
    }

    @Override
    public void updateScene() {
        player1.move();
        player2.move();

        for (Projectile p : this.projectiles) {
            p.move();
            if (p.getOwner() != player1 && p.getCollisionArea().overlaps(this.player1.getCollisionArea())) {
                player1.takeDamage(p.getDamage());
                removeDrawable(p);
                removedProjectiles.add(p);
            }

            if (p.getOwner() != player2 && p.getCollisionArea().overlaps(this.player2.getCollisionArea())) {
                player2.takeDamage(p.getDamage());
                removeDrawable(p);
                removedProjectiles.add(p);
            }
            
            
        }

        if (player1.getHealth() < 0) {
            player1.respawn(100, 100);
        }

        if (player2.getHealth() < 0) {
            player2.respawn(200, 100);
        }

        projectiles.removeAll(removedProjectiles);
        removedProjectiles.clear();

    }

    @Override
    public void checkInputs() {

    }

}
