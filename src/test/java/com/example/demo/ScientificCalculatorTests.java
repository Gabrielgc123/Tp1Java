package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ScientificCalculatorTests {

    ScientificCalculator calculadora;

    @BeforeEach
    void setup(){
        calculadora = new ScientificCalculator();
    }


    //Métodos happy path
    @Test
    void testAdditionComDoisNumerosPositivos() {

        //ScientificCalculator soma = new ScientificCalculator();

        double resultado = calculadora.add(5, 10);

        assertEquals(15, resultado);

    }

    @Test
    void testSubtractComDoisNumerosPositivos(){
        // setup
        //ScientificCalculator subtracao = new ScientificCalculator();

        // execution
        double resultado = calculadora.subtract(10, 5);

        // assertion
        assertEquals(5, resultado);
    }

    @Test
    void testSquareRootPositive(){

        double resultado = calculadora.squareRoot(36);

        assertEquals(6, resultado);
    }

    // Métodos happy path e com precisão

    @Test
    void testLogComNumeroPositivo() {

        double resultado = calculadora.log(10);

        assertEquals(Math.log(10), resultado, 0.0001);

    }

    @Test
    void testSinComNumeroPositivo() {

        double resultado = calculadora.sin(90);

        assertEquals(1.0, resultado, 0.0001);

    }

    // Métodos com excecão
    @Test
    void testSquareRootNegative(){

        //double resultado = calculadora.squareRoot(-36);

        //System.out.println(resultado);

        //assertEquals(6, resultado);

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> {double resultado = calculadora.squareRoot(-36);});

        assertEquals("Negative number", excecao.getMessage());

    }

    @Test
    void testDivideByZero(){

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> {double resultado = calculadora.divide(20, 0);});

        assertEquals("Division by zero", excecao.getMessage());
    }




}
