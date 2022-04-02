package com.example.demo.another;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class GraderTest {

    Grader grader = new Grader();

    @Test
    void negativeOneShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                ()-> {
                    grader.determineLetterGrade(-1);
                });

        assertEquals('F', grader.determineLetterGrade(0));
    }

    @Test
    void fiftyNineShouldReturnF() {
        assertEquals('F', grader.determineLetterGrade(59));
    }

    @Test
    void zeroShouldReturnF() {
        assertEquals('F', grader.determineLetterGrade(0));
    }

    @Test
    void sixtyNineShouldReturnD() {
        assertEquals('D', grader.determineLetterGrade(69));
    }

    @Test
    void sixtyShouldReturnD() {
        assertEquals('D', grader.determineLetterGrade(60));
    }

    @Test
    void seventyNineShouldReturnC() {
        assertEquals('C', grader.determineLetterGrade(79));
    }

    @Test
    void seventyShouldReturnC() {
        assertEquals('C', grader.determineLetterGrade(70));
    }

    @Test
    void eightyNineShouldReturnB() {
        assertEquals('B', grader.determineLetterGrade(89));
    }

    @Test
    void eightyShouldReturnB() {
        assertEquals('B', grader.determineLetterGrade(80));
    }

    @Test
    void ninetyNineShouldReturnA() {
        assertEquals('A', grader.determineLetterGrade(99));
    }

    @Test
    void ninetyShouldReturnA() {
        assertEquals('A', grader.determineLetterGrade(90));
    }

}