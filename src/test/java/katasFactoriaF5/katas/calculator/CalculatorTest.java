package katasFactoriaF5.katas.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc;

    @BeforeEach
    void setUp(){
        calc = new Calculator();
    }

    @Test
    void calculatorStartsWithTotalEqualZero() {
        assertThat(calc.getTotal(), equalTo(0.0) );
    }


    @Test
    void canAddTotal(){
        double rand = Math.random();

        calc.add(rand);

        assertThat(calc.getTotal(),equalTo(rand));
    }

    @Test
    void canDivideTotal(){
        calc.setTotal(2);

        calc.divide(2);

        assertThat(calc.getTotal(), equalTo(1.0));
    }


    @Test
    void cantDivideWith0(){
        calc.setTotal(2);

        Throwable exception = assertThrows(RuntimeException.class, () -> calc.divide(0));
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    void getSumArray(){
        List<Double> list = new ArrayList<>();
        list.add(1d);
        list.add(2d);
        list.add(3d);

        calc.add(list);

        assertEquals(6, calc.getTotal());
    }

    @Test
    void getGreaterThan5(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(9);
        list.add(10);
        list.add(11);

        List<Integer> filteredList = calc.getGreaterThan5(list);
      //  assertThat( filteredList, hasSize(3));
        assertThat(filteredList,contains(5,9,10,11));
    }
}