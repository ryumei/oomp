/*
 * oomp : object-oriented mechanics of patricles
 *
 * Copyright (c) 2010/06/14 NAKAJIMA Takaaki <takaaki.nakajima@mac.com>.
 * This is provided "AS IS" with no warranty.
 * Entire risk on using it is with you.
 */

package oomp;

import java.util.ArrayList;

/**
 *
 * @author NAKAJIMA Takaaki <takaaki.nakajima@mac.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new AbstractSystem() {
            public void construct() {
                Mass m0 = new Mass(1.0,  0.0, 0.0, 0.0,
                        0.0, 0.0, 0.0,  false);
                Mass m1 = new Mass(1.0,  0.0, 0.0, 1.5,
                        0.0, 0.0, 0.0,  true);

                masses = new ArrayList<Mass>();
                masses.add(m0);
                masses.add(m1);

                elements = new ArrayList<AbstractElement>();
                elements.add(new Spring(1.0, 1.0, m0, m1));
                elements.add(new Damper(1.0, m0, m1));
            }
        }.exec(1000, 0.01);

    }
}
