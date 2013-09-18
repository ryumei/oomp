/*
 * oomp : object-oriented mechanics of patricles
 *
 * Copyright (c) 2010/06/16 NAKAJIMA Takaaki <takaaki.nakajima@mac.com>.
 * This is provided "AS IS" with no warranty.
 * Entire risk on using it is with you.
 */

import oomp.*;

/**
 * % groovy -cp dist/oomp.jar src/System1.groovy > System1.dat
 * 
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
class System1_0 extends AbstractSystem {
    public void construct() {
        masses = [
            new Mass(1.0,  0.0, 0.0, 0.0,  0.0, 0.0, 0.0,  false),
            new Mass(1.0,  0.0, 0.0, 1.5,  0.0, 0.0, 0.0,  true)
        ] as Mass[]

        elements = [
            new Spring(1.0, 1.0, masses[0], masses[1]),
            new Damper(1.0, masses[0], masses[1])
        ] as AbstractElement[]
    }
}

new System1_0().exec(20000, 0.01)

