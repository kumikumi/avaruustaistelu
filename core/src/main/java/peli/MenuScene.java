package peli;

import peli.MyGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;
import libraries.InputListener;
import libraries.MenuButton;
import libraries.Scene;
import libraries.StaticImage;

class MenuScene extends Scene {

    private ArrayList<MenuButton> buttonList;

    private InputListener inputListener;

    @Override
    public void initialize() {
        StaticImage background = new StaticImage(0, 0, new Sprite(new Texture("assets/bg2.png")));
        addDrawable(background);
        Sprite quitImg = new Sprite(new Texture("assets/buttonQuit.png"));
        Sprite quitImgHover = new Sprite(new Texture("assets/buttonQuitHover.png"));

        Sprite startImg = new Sprite(new Texture("assets/buttonStart.png"));
        Sprite startImgHover = new Sprite(new Texture("assets/buttonStartHover.png"));

        float buttonHeight = quitImg.getHeight();
        float buttonWidth = quitImg.getWidth();

        buttonList = new ArrayList<MenuButton>();
        buttonList.add(new MenuButton(MyGame.SCREEN_WIDTH / 2 - buttonWidth / 2, MyGame.SCREEN_HEIGHT / 2 - buttonHeight, quitImg, quitImgHover, "QUIT"));
        buttonList.add(new MenuButton(MyGame.SCREEN_WIDTH / 2 - buttonWidth / 2, MyGame.SCREEN_HEIGHT / 2 + buttonHeight, startImg, startImgHover, "START"));

        addButtons(buttonList);
        inputListener = new InputListener();
        Gdx.input.setInputProcessor(inputListener);
    }

    @Override
    public void updateScene() {

    }

    @Override
    public void checkInputs() {
        for (MenuButton button : buttonList) {
            if (button.isMousePointerTouching(inputListener.getMouseX(), inputListener.getMouseY())) {
                button.setHover(true);
                //Checks if leftmouse is clicked while mousepointer is touching button and then checks which button it was.
                if (inputListener.isLeftMouseButtonClicked()) {
                    if ("QUIT".equals(button.getButtonText())) {
                        System.exit(0);
                    }
                    if ("START".equals(button.getButtonText())) {
                        MyGame.sceneManager.nextScene();
                    }
                }
            } else {
                button.setHover(false);
            }
        }
    }

}
