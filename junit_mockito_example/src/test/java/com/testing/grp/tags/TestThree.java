package com.testing.grp.tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Production")
public class TestThree {
    @Test
    public void testThree(){
        System.out.println("Test 3");
    }
}
