/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import processing.core.*;

/**
 *
 * @author daalb
 */
public class Processing extends PApplet {

    public static void main(String[] args) {
        PApplet.main(new String[]{processing.Processing.class.getName()});
    }

    public Processing() {

    }
    ParticleSystem ps;
    PImage sprite;

    @Override
    public void settings() {
        size(1024, 768, P2D);
        orientation(LANDSCAPE);
        sprite = loadImage("sprite.png");
        ps = new ParticleSystem(10);
        hint(DISABLE_DEPTH_MASK);
    }

    @Override
    public void draw() {
        background(0);
        ps.update();
         ps.display();
         ps.setEmitter(mouseX, mouseY);
        fill(255);
        textSize(16);

    }

}
