/*
 	Copyright (c) 2019, 2020 Oracle and/or its affiliates. All rights reserved.
	
	This program and the accompanying materials are made available under the
	terms of the Eclipse Public License v. 2.0, which is available at
	http://www.eclipse.org/legal/epl-2.0.
	
	This Source Code may also be made available under the following Secondary
	Licenses when the conditions for such availability set forth in the
	Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
	version 2 with the GNU Classpath Exception, which is available at
	https://www.gnu.org/software/classpath/license.html.
	
	SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
*/
package org.glassfish.executor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Arun Gupta
 */
public class MyRunnableTask implements Runnable {

    private int id;

    public MyRunnableTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.format("%d (runnable): starting", id);
            System.out.format("%d (runnable): sleeping 2 seconds", id);
            Thread.sleep(2000);
            System.out.format("%d (runnable): complete", id);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestResourceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}