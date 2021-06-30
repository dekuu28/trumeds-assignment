package com.truemeds.assignment.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CountIterationsLogicTest {

    private CountIterationsLogic countIterations;

    @BeforeEach
    void setup(){
        this.countIterations = new CountIterationsLogic();
    }

    @Test
    void givenFirstTestCase(){
        Assertions.assertEquals(2,this.countIterations.processInput("baacdccce"));
    }

    @Test
    void givenSecondTestCase(){
        Assertions.assertEquals(4,this.countIterations.processInput("aabcbb cdee"));
    }

    @Test
    void randomTestCase(){
        Assertions.assertEquals(0,this.countIterations.processInput("abc"));
    }
}
