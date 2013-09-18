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
 *  ------
 *  | m2 |
 *  ------
 *   |  |
 *   k  c
 *   |  |
 *  ------
 *  | m1 |
 *  ------
 *   |  |
 *   k  c
 *   |  |
 * --------
 * ///m0///
 *
 * @author NAKAJIMA Takaaki <takaaki.nakajima@mac.com>
 */
class System2_0 extends AbstractSystem {
    public void construct() {
        masses = [
            new Mass( 1.0,  0.0, 0.0, 0.0,  0.0, 0.0,  0.0,    false),
            new Mass(10.0,  0.0, 0.0, 1.0,  0.0, 0.0,  0.0,    true),
            new Mass( 1.0,  0.0, 0.0, 2.0,  0.0, 0.0, -1.0e-1, true)
        ] as Mass[]

        elements = [ new Spring(1.0e1, 1.0, masses[0], masses[1]),
                     new Damper(1.0e1, masses[0], masses[1]),
                     new Spring(1.0e0, 1.0, masses[1], masses[2]),
                     new Damper(1.0e0, masses[1], masses[2]),
        ] as AbstractElement[]
    }
}

new System2_0().exec(1000000, 0.01)

