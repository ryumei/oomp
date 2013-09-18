/*
 * oomp : object-oriented mechanics of patricles
 * 
 * Copyright (c) 2010/06/14 NAKAJIMA Takaaki <takaaki.nakajima@mac.com>.
 * This is provided "AS IS" with no warranty.
 * Entire risk on using it is with you.
 */

package oomp;

import javax.vecmath.Vector3d;

/**
 * 万有引力
 * @author NAKAJIMA Takaaki <takaaki.nakajima@mac.com>
 */
public class Gravity implements AbstractElement {

    static final double G = 6.67300e-11; // 万有引力定数 m3 kg-1 s-2
    Mass m1;
    Mass m2;

    public Gravity(Mass m1, Mass m2) {
        this.m1 = m1;
        this.m2 = m2;
    }

    public void interact() {
        Vector3d d21 = new Vector3d(m2.r);
        d21.sub(m1.r);    // r2 - r1

        double d = d21.length();
        double f0 = -0.5 * G * m1.m * m2.m / (d * d * d);
        m2.f.scaleAdd(+f0, d21, m2.f);
        m1.f.scaleAdd(-f0, d21, m1.f);
    }
}
