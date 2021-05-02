package com.org.utb.app.librarytech;

import com.org.utb.app.librarytech.validators.TimeValidator;
import org.junit.Test;

import static org.junit.Assert.*;


public class TimeValidatorTest {

    // Instance of validator
    private final TimeValidator timeValidator = new TimeValidator();

    @Test
    public void isValidTimeReturnFalse(){
        assertFalse(timeValidator.isValid(2026, null));
        assertFalse(timeValidator.isValid(2022, null));
        assertFalse(timeValidator.isValid(2023, null));
        assertFalse(timeValidator.isValid(2024, null));
        assertFalse(timeValidator.isValid(2025, null));
    }

    @Test
    public void isValidTimeReturnTrue(){
        assertTrue(timeValidator.isValid(2020, null));
        assertTrue(timeValidator.isValid(2010, null));
        assertTrue(timeValidator.isValid(2015, null));
        assertTrue(timeValidator.isValid(2012, null));
        assertTrue(timeValidator.isValid(2021, null));
    }

}
