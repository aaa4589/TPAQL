package anwer.TP1.exo5;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralTest {
    
    @Test
    public void testToRoman() {
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("V", RomanNumeral.toRoman(5));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("X", RomanNumeral.toRoman(10));
        assertEquals("XL", RomanNumeral.toRoman(40));
        assertEquals("L", RomanNumeral.toRoman(50));
        assertEquals("XC", RomanNumeral.toRoman(90));
        assertEquals("C", RomanNumeral.toRoman(100));
        assertEquals("CD", RomanNumeral.toRoman(400));
        assertEquals("D", RomanNumeral.toRoman(500));
        assertEquals("CM", RomanNumeral.toRoman(900));
        assertEquals("M", RomanNumeral.toRoman(1000));
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }
    
    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(-1));
    }
    
    @Test
    public void testEdgeCases() {
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }
} 