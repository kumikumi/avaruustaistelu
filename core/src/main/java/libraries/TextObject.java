package libraries;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class TextObject extends GameObject{
    
    private int x,y;
    private String txt;
    private float scale;
    private Color color;
    
    public TextObject(String txt, float x, float y){
        super(x, y, null);
        this.scale = 1;
        this.txt = txt;
        this.color = Color.BLACK;
    }

    public String getTxt() {
        return this.txt;
    }
    
    public void setText(String txt){
        this.txt = txt;
    }

    public float getScale() {
        return this.scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public Color getColor(){
        return this.color;
    }
}