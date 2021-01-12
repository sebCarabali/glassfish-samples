/*
 	Copyright (c) 2020 Oracle and/or its affiliates. All rights reserved.
	
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
package com.oracle.jakartaee9.samples.batch.partition;

import java.io.Serializable;
import java.util.List;
import jakarta.batch.api.chunk.AbstractItemWriter;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import javax.naming.InitialContext;

@Named("SimpleItemWriter")
public class SimpleItemWriter
    extends AbstractItemWriter {
    
    @EJB
    private SampleDataHolderBean bean;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        super.open(checkpoint);
        try {
            InitialContext ctx = new InitialContext();
            bean = (SampleDataHolderBean) ctx.lookup("java:global/payroll/SampleDataHolderBean");
        } catch (Exception ex) {
            //
        }
    }

    public void writeItems(List list) throws Exception {
        for (Object obj : list) {
            bean.addPayrollRecord((PayrollRecord) obj);
        }
    }
    
}
