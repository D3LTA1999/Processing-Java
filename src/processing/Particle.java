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
public class Particle extends PApplet {
    Processing pr = new Processing();
    PVector velocity;
    float lifespan = 255;

    PShape part=new PShape();
    float partSize;

    PVector gravity = new PVector(0, 0.1f);

    public Particle() {
        partSize = random(10, 60);
        part = createShape();
        part.beginShape(QUAD);
        part.noStroke();
        part.texture(pr.sprite);
        part.normal(0, 0, 1);
        part.vertex(-partSize / 2, -partSize / 2, 0, 0);
        part.vertex(+partSize / 2, -partSize / 2, pr.sprite.width, 0);
        part.vertex(+partSize / 2, +partSize / 2, pr.sprite.width, pr.sprite.height);
        part.vertex(-partSize / 2, +partSize / 2, 0, pr.sprite.height);
        part.endShape();
        rebirth(width / 2, height / 2);
        lifespan = random(255);
    }

    PShape getShape() {
        return part;
    }

    void rebirth(float x, float y) {
        float a = random(TWO_PI);
        float speed = random(0.5f, 4);
        velocity = new PVector(cos(a), sin(a));
        velocity.mult(speed);
        lifespan = 255;
        part.resetMatrix();
        part.translate(x, y);
    }

    boolean isDead() {
        if (lifespan < 0) {
            return true;
        } else {
            return false;
        }
    }

    public void update() {
        lifespan = lifespan - 1;
        velocity.add(gravity);
        part.setTint(color(255, lifespan));
        part.translate(velocity.x, velocity.y);
    }

}
