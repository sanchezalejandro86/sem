package org.example.sem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SEMTest {

    @Test
    public void testAllMinusOne(){
        Map<Integer, Integer> result = SEM.process(new int[]{7, 5, 3, 1});

        Assertions.assertEquals(-1, result.get(7));
        Assertions.assertEquals(-1, result.get(5));
        Assertions.assertEquals(-1, result.get(3));
        Assertions.assertEquals(-1, result.get(1));
    }

    @Test
    public void testExample1(){
        Map<Integer, Integer> result = SEM.process(new int[]{4, 5, 2, 25});

        Assertions.assertEquals(5, result.get(4));
        Assertions.assertEquals(25, result.get(5));
        Assertions.assertEquals(25, result.get(2));
        Assertions.assertEquals(-1, result.get(25));
    }

    @Test
    public void testExample2(){
        Map<Integer, Integer> result = SEM.process(new int[]{13, 7, 6, 12});

        Assertions.assertEquals(-1, result.get(13));
        Assertions.assertEquals(12, result.get(7));
        Assertions.assertEquals(12, result.get(6));
        Assertions.assertEquals(-1, result.get(12));
    }
}
