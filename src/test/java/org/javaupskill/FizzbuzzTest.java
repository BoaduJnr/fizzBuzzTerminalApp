package org.javaupskill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzbuzzTest {

    Fizzbuzz fizzbuzz ;
    @BeforeEach
    void setup(){
        fizzbuzz = new FizzbuzzImpl();
    }
    @Test
    void checkNumber() {

    }
}