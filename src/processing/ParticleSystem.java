/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import java.util.ArrayList;
import processing.core.*;

/**
 *
 * @author daalb
 */
public class ParticleSystem extends PApplet {

    ArrayList<Particle> particles;

    PShape particleShape;
    public ParticleSystem(int n) {
        particles = new ArrayList<Particle>();
        System.out.println(PShape.GROUP);
        //particleShape = createShape(0);
        for (int i = 0; i < n; i++) {
            Particle p = new Particle();
            particles.add(p);
            particleShape.addChild(p.getShape());
        }
    }

    public void update() {
        for (Particle p : particles) {
            p.update();
        }
    }

    public void setEmitter(float x, float y) {
        for (Particle p : particles) {
            if (p.isDead()) {
                p.rebirth(x, y);
            }
        }
    }

    public void display() {
        shape(particleShape);
    }
}
