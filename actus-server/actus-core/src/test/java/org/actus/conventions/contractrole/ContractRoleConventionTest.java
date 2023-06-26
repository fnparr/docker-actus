/*
 * Copyright (C) 2016 - present by ACTUS Financial Research Foundation
 *
 * Please see distribution for license.
 */
package org.actus.conventions.contractrole;

import org.actus.AttributeConversionException;
import org.actus.conventions.contractrole.ContractRoleConvention;

import org.actus.types.ContractRole;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContractRoleConventionTest {

    @Test
    public void test_AttributeConversionException() {
        assertThrows(AttributeConversionException.class, () ->
            ContractRoleConvention.roleSign(null));
    }

    @Test
    public void test_RPA() {
        int expectedSign = 1;
        assertEquals(expectedSign, ContractRoleConvention.roleSign(ContractRole.RPA));
    }
    
    @Test
    public void test_RPL() {
        int expectedSign = -1;
        assertEquals(expectedSign, ContractRoleConvention.roleSign(ContractRole.RPL));
    }
    
}
