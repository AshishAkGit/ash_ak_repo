package com.testing.grp.tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Development")
public class TestOne {
    @Test
    void testOne(){
        System.out.println("test1");
    }
}
