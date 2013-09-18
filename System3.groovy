/*
 * oomp : object-oriented mechanics of patricles
 *
 * Copyright (c) 2010/06/16 NAKAJIMA Takaaki <takaaki.nakajima@mac.com>.
 * This is provided "AS IS" with no warranty.
 * Entire risk on using it is with you.
 */

import oomp.*;

/**
 * % groovy -cp dist/oomp.jar src/System2.groovy > System2.dat
 *
 * @author NAKAJIMA Takaaki <takaaki.nakajima@mac.com>
 */
class System3_0 extends AbstractSystem {
    public void construct() {
        def m00 = 1e10
        def v00 = 0.08

        def s60 = 0.5 * Math.sqrt(3.0)
        def c60 = 0.5
        masses = [
            new Mass(m00,  1.0, 0.0, 0.0,   0.0,       v00,     0.0,  true),
            new Mass(m00,  -c60, s60, 0.0,  -v00*s60, -v00*c60, 0.0,  true),
            new Mass(m00,  -c60,-s60, 0.0,   v00*s60, -v00*c60, 0.0,  true),
        ] as Mass[]

        elements = [ ] as AbstractElement[]
        for (i in 0 ..< masses.size()) {
            for (j in (i + 1) ..< masses.size()) {
                elements.add(new Gravity(masses[i], masses[j]))
            }
        }
    }
}

new System3_0().exec(2000, 0.01)

