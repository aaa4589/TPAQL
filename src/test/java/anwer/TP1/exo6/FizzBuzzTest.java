package anwer.TP1.exo6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

    @Test
    public void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45));
    }

    @Test
    public void testFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
    }

    @Test
    public void testBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(20));
    }

    @Test
    public void testNombre() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("4", FizzBuzz.fizzBuzz(4));
        assertEquals("7", FizzBuzz.fizzBuzz(7));
        assertEquals("8", FizzBuzz.fizzBuzz(8));
        assertEquals("11", FizzBuzz.fizzBuzz(11));
    }

    @Test
    public void testNombreNegatif() {
        assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz.fizzBuzz(-1);
        });
    }

    @Test
    public void testNombreZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz.fizzBuzz(0);
        });
    }

    @Test
    public void testNombreUn() {
        assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz.fizzBuzz(1);
        });
    }

    @Test
    public void testCasLimites() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("2", FizzBuzz.fizzBuzz(2));
    }
}
