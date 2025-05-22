package anwer.TP1.exo3;

import org.junit.jupiter.api.Test;

import anwer.TP1.exo3.BinarySearch;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
    
    @Test
    public void testBinarySearch() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        assertEquals(0, BinarySearch.binarySearch(array, 1));
        assertEquals(4, BinarySearch.binarySearch(array, 5));
        assertEquals(9, BinarySearch.binarySearch(array, 10));
        assertEquals(-1, BinarySearch.binarySearch(array, 11));
    }
    
    @Test
    public void testBinarySearchEmptyArray() {
        int[] emptyArray = {};
        assertEquals(-1, BinarySearch.binarySearch(emptyArray, 1));
    }
    
    @Test
    public void testBinarySearchSingleElement() {
        int[] singleArray = {5};
        assertEquals(0, BinarySearch.binarySearch(singleArray, 5));
        assertEquals(-1, BinarySearch.binarySearch(singleArray, 1));
    }
    
    @Test
    public void testBinarySearchNotSorted() {
        int[] unsortedArray = {5, 2, 8, 1, 9};
        assertEquals(-1, BinarySearch.binarySearch(unsortedArray, 2));
    }
} 