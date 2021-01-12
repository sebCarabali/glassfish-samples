/*
 * Copyright (c) 2019, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package jsf2.demo.scrum.model.entities;

import jsf2.demo.scrum.web.controller.SprintManager;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SprintNameUniquenessConstraintValidator implements ConstraintValidator<SprintNameUniquenessConstraint, String> {
    
    @Inject
    private SprintManager sprintManager;

    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        
        boolean result = true;
        String message = sprintManager.
                checkUniqueSprintNameApplicationValidatorMethod(value);
        if (message != null) {
            result = false;
            ConstraintValidatorContext.ConstraintViolationBuilder builder =
                    ctx.buildConstraintViolationWithTemplate(message);
            builder.addConstraintViolation();
        }

        
        return result;
    }

    public void initialize(SprintNameUniquenessConstraint arg0) {
    }
    
}
