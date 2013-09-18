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
 * 質点
 * @author NAKAJIMA Takaaki <takaaki.nakajima@mac.com>
 */
public class Mass {
    final double m;
    final double im;
    final Vector3d r;
    final Vector3d v;
    final Vector3d f;
    final Vector3d fex;     // 外力
    
    final boolean free;
    
    public Mass(double m,
         double rx, double ry, double rz,
         double vx, double vy, double vz,
         double fex, double fey, double fez, boolean free) {
        this.m = m;
        this.im = 1.0 / m;

        r = new Vector3d(rx, ry, rz);
        v = new Vector3d(vx, vy, vz);
        f = new Vector3d(0.0, 0.0, 0.0);
        this.fex = new Vector3d(fex, fey, fez);

        this.free = free;
    }

    public Mass(double m,
         double rx, double ry, double rz,
         double vx, double vy, double vz, boolean free) {
        this(m, rx, ry, rz, vx, vy, vz, 0.0, 0.0, 0.0, free);
    }
    
    Vector3d getA() {
        Vector3d aa = new Vector3d();
        aa.add(f, fex);
        aa.scale(im);
        return aa;
    }
}
