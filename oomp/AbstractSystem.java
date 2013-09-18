/*
 * oomp : object-oriented mechanics of patricles
 * 
 * Copyright (c) 2010/06/14 NAKAJIMA Takaaki <takaaki.nakajima@mac.com>.
 * This is provided "AS IS" with no warranty.
 * Entire risk on using it is with you.
 */

package oomp;

import java.util.List;

/**
 * Newton 力学
 * @author NAKAJIMA Takaaki <takaaki.nakajima@mac.com>
 */
public abstract class AbstractSystem {

    protected List<Mass> masses;
    protected List<AbstractElement> elements;

    public AbstractSystem() {
        construct();
    }
    
    /**
     * Construct a system
     */
    public abstract void construct();

    void clearForce() {
        for (Mass m : masses) {
            m.f.set(0.0, 0.0, 0.0);
        }
    }

    void prepareDynamics(double dt) {
        double dt05 = 0.5 * dt;
        for (Mass m : masses) {
            if (m.free) {
                m.v.scaleAdd(dt05, m.getA(), m.v);
                m.r.scaleAdd(dt, m.v, m.r);
            }
        }
    }

    void calculateForce() {
        for (AbstractElement element : elements) {
            element.interact();
        }
    }

    void calculateDynamics(double dt) {
        double dt05 = 0.5 * dt;
        for (Mass m: masses) {
            if (m.free) {
                m.v.scaleAdd(dt05, m.getA(), m.v);
            }
        }
    }

    void display() {
        for (Mass m : masses) {
            System.out.printf("%e %e %e  ", m.r.x, m.r.y, m.r.z);
        }
        System.out.println();
    }

    /**
     * 
     * @param step
     * @param dt
     */
    public void exec(int step, double dt) {
        for (int i = 0; i < step; i++) {
            clearForce();
            
            prepareDynamics(dt);
            calculateForce();
            calculateDynamics(dt);

            display();
        }
    }

}
