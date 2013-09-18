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
 * 摩擦抵抗
 * @author NAKAJIMA Takaaki <takaaki.nakajima@mac.com>
 */
public class Damper implements AbstractElement {

    final double c;     // 粘性定数
    Mass m1;
    Mass m2;

    Damper(double c, Mass m1, Mass m2) {
        this.c = c;
        this.m1 = m1;
        this.m2 = m2;
    }

    /*
     * F = -c V
     */
    public void interact() {
        Vector3d d = new Vector3d(m2.v);
        d.sub(m1.v);    // v2 - v1
        double f0 = -0.5 * c * d.length();
        m2.f.scaleAdd(+f0, d, m2.f);
        m1.f.scaleAdd(-f0, d, m1.f);
    }
}
