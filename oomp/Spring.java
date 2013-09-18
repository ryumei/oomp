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
 * ばね
 * @author NAKAJIMA Takaaki <takaaki.nakajima@mac.com>
 */
public class Spring implements AbstractElement {

    final double k;     // ばね定数
    final double d0;    // 平衡距離
    Mass m1;
    Mass m2;

    public Spring(double k, double d0, Mass m1, Mass m2) {
        this.k = k;
        this.d0 = d0;
        this.m1 = m1;
        this.m2 = m2;
    }

    /*
     * F = -k (X - D0)
     *   = -k (X - d0 X/|X|)
     *   = -k (1 - d0/|X|) X
     */
    public void interact() {
        Vector3d d = new Vector3d(m2.r);
        d.sub(m1.r);    // r2 - r1

        double dnorm = d.length();

        double f0 = -0.5 * k * (1.0 - d0 / dnorm);

        m2.f.scaleAdd(+f0, d, m2.f);
        m1.f.scaleAdd(-f0, d, m1.f);
    }
}
