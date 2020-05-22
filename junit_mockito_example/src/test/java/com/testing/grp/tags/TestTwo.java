package com.testing.grp.tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Development")
public class TestTwo {
    @Test
    public void testTwo(){
        System.out.println("Test 2");
    }
}
