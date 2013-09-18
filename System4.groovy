/*
 * oomp : object-oriented mechanics of patricles
 *
 * Copyright (c) 2010/06/16 NAKAJIMA Takaaki <takaaki.nakajima@mac.com>.
 * This is provided "AS IS" with no warranty.
 * Entire risk on using it is with you.
 */

import oomp.*;

/**
 * =>m4---m5
 *    |\ /|
 *    | X |
 *    |/ \|
 *   m2---m3
 *    |\ /|
 *    | X |
 *    |/ \|
 * --m0---m1--
 * ///////////
 *
 * % groovy -cp dist/oomp.jar src/System2.groovy > System2.dat
 *
 * @author NAKAJIMA Takaaki <takaaki.nakajima@mac.com>
 */
class System4_0 extends AbstractSystem {
    public void construct() {
        masses = [
            new Mass(1.0,  0.0, 0.0, 0.0,  0.0, 0.0, 0.0,  false),
            new Mass(1.0,  1.0, 0.0, 0.0,  0.0, 0.0, 0.0,  false),
            new Mass(1.0,  0.0, 0.0, 1.0,  0.0, 0.0, 0.0,  true),
            new Mass(1.0,  1.0, 0.0, 1.0,  0.0, 0.0, 0.0,  true),
            new Mass(1.0,  0.0, 0.0, 2.0,  0.1, 0.0, 0.0,  true),
            new Mass(1.0,  1.0, 0.0, 2.0,  0.0, 0.0, 0.0,  true),
        ] as Mass[]

        double sqrt2 = Math.sqrt(2.0)
        elements = [
            new Spring(1.0, 1.0, masses[0], masses[2]),
            new Spring(1.0, 1.0, masses[1], masses[3]),
            new Spring(1.0, 1.0, masses[2], masses[3]),
            new Spring(1.0, 1.0, masses[2], masses[4]),
            new Spring(1.0, 1.0, masses[3], masses[5]),
            new Spring(1.0, 1.0, masses[4], masses[5]),

            new Damper(1.0, masses[0], masses[2]),
            new Damper(1.0, masses[1], masses[3]),
            new Damper(1.0, masses[2], masses[3]),
            new Damper(1.0, masses[2], masses[4]),
            new Damper(1.0, masses[3], masses[5]),
            new Damper(1.0, masses[4], masses[5]),

            // 斜交い
            new Spring(1.0, sqrt2, masses[1], masses[2]),
            new Spring(1.0, sqrt2, masses[0], masses[3]),
            new Damper(1.0, masses[1], masses[2]),
            new Damper(1.0, masses[0], masses[3]),

            new Spring(1.0, sqrt2, masses[2], masses[5]),
            new Spring(1.0, sqrt2, masses[3], masses[4]),
            new Damper(1.0, masses[2], masses[5]),
            new Damper(1.0, masses[3], masses[4]),
        ] as AbstractElement[]
    }
}

new System4_0().exec(100000, 0.01)

