/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.streamdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.openjfx.streamdemo.Pizza.*;

/**
 *
 * @author Adam
 */
public class AppTest {

    /**
     * Test of findCheapestSpicy method, of class App.
     */
    @Test

    public void testFindCheapestSpicy0() {
        System.out.println("findCheapestSpicy");
        List<Pizza> pizzas = Arrays.asList(MARGHERITA, AMORE, TABASCO, FARMER, MAMA_MIA);
        App instance = new App();
        Pizza expResult = TABASCO;
        Pizza result = instance.findCheapestSpicy(pizzas);
        assertEquals(expResult, result);
    }
    @Test
    public void testFindCheapestSpicy1() {
        System.out.println("findCheapestSpicy");
        List<Pizza> pizzas = Arrays.asList(TABASCO, SOPRANO, CARUSO);
        App instance = new App();
        Pizza expResult = CARUSO;
        Pizza result = instance.findCheapestSpicy(pizzas);
        assertEquals(expResult, result);
    }

    /**
     * Test of findMostExpensiveVegetarian method, of class App.
     */
    @Test
    public void testFindMostExpensiveVegetarian0() {
        System.out.println("findMostExpensiveVegetarian0");
        List<Pizza> pizzas = Arrays.asList(HAVAI, VEGETARIANA, TABASCO);
        App instance = new App();
        Pizza expResult = VEGETARIANA;
        Pizza result = instance.findMostExpensiveVegetarian(pizzas);
        assertEquals(expResult, result);
    }
    @Test
    public void testFindMostExpensiveVegetarian1() {
        System.out.println("findExpensiveVegetarian1");
        List<Pizza> pizzas = Arrays.asList(MARGHERITA, FOUR_CHEESE, SOPRANO);
        App instance = new App();
        Pizza expResult = FOUR_CHEESE;
        Pizza result = instance.findMostExpensiveVegetarian(pizzas);
        assertEquals(expResult, result);
    }
    @Test
    public void testFindMostExpensiveVegetarian2() {
        System.out.println("findExpensiveVegetarian2");
        List<Pizza> pizzas = Arrays.asList(FARMER,  CARUSO);
        App instance = new App();
        Pizza expResult = null;
        Pizza result = instance.findMostExpensiveVegetarian(pizzas);
        assertEquals(expResult, result);
    }

    /**
     * Test of iLikeMeat method, of class App.
     */
    @Test
    public void testILikeMeat0() {
        System.out.println("iLikeMeat0");
        List<Pizza> pizzas = Arrays.asList(MARGHERITA, HAVAI);
        App instance = new App();
        List<Pizza> expResult = Arrays.asList(HAVAI);
        List<Pizza> result = instance.iLikeMeat(pizzas);
        assertEquals(expResult, result);
    }
    @Test
    public void testILikeMeat1() {
        System.out.println("iLikeMeat1");
        List<Pizza> pizzas =  Arrays.asList(
                MARGHERITA,
                CAPRI,
                HAVAI,
                CARUSO,
                MAMA_MIA,
                SOPRANO,
                CALABRESE,
                VEGETARIANA,
                CAPRESE,
                PASCETORE,
                FOUR_CHEESE,
                TABASCO,
                AMORE,
                FARMER);
        App instance = new App();
        List<Pizza> expResult = Arrays.asList(SOPRANO, CALABRESE, TABASCO, FARMER, CAPRI, HAVAI, CARUSO, MAMA_MIA, AMORE);
        List<Pizza> result = instance.iLikeMeat(pizzas);
        assertEquals(expResult, result);
    }
    /**
     * Test of groupByPrice method, of class App.
     */
    @Test
    public void testGroupByPrice() {
        System.out.println("groupByPrice");
        List<Pizza> pizzas = Arrays.asList(AMORE, FOUR_CHEESE, VEGETARIANA, TABASCO, CAPRESE);
        App instance = new App();
        Map<Integer, List<Pizza>> expResult = new HashMap<>();
        expResult.put(16, new ArrayList<>(Arrays.asList(AMORE)));
        expResult.put(19, new ArrayList<>(Arrays.asList(CAPRESE, FOUR_CHEESE)));
        expResult.put(20, new ArrayList<>(Arrays.asList(VEGETARIANA)));
        expResult.put(22, new ArrayList<>(Arrays.asList(TABASCO)));
        Map<Integer, List<Pizza>> result = instance.groupByPrice(pizzas);
        assertEquals(expResult, result);
    }
    @Test
    public void testGroupByPrice1() {
        System.out.println("groupByPrice");
        List<Pizza> pizzas = Arrays.asList(TABASCO, HAVAI, FARMER, CAPRESE, CAPRI, FOUR_CHEESE, MAMA_MIA);
        App instance = new App();
        Map<Integer, List<Pizza>> expResult = new HashMap<>();
            expResult.put(17, new ArrayList<>(Arrays.asList(CAPRI, HAVAI)));
			expResult.put(19, new ArrayList<>(Arrays.asList(CAPRESE, FOUR_CHEESE)));
            expResult.put(18, new ArrayList<>(Arrays.asList(MAMA_MIA)));
            expResult.put(22, new ArrayList<>(Arrays.asList(TABASCO, FARMER)));
        Map<Integer, List<Pizza>> result = instance.groupByPrice(pizzas);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatedMenu method, of class App.
     */
    @Test
    public void testFormatedMenu() {
        System.out.println("formatedMenu");
        List<Pizza> pizzas = Arrays.asList(SOPRANO, CAPRI, FOUR_CHEESE);
        App instance = new App();
        String expResult = "Soprano: grube ciasto, sos pomidorowy, ser, szynka, pieczarki, cebula, bekon, pieprz - 23\n"
                + "Capri: cienkie ciasto, sos pomidorowy, ser, szynka, pieczarki - 17\n"
                + "Cztery sery: cienkie ciasto, sos pomidorowy, ser, mozarella, ser feta, ser pleśniowy - 19";
        String result = instance.formatedMenu(pizzas);
        assertEquals(expResult, result);
    }
    @Test
    public void testFormatedMenu1() {
        System.out.println("formatedMenu1");
        List<Pizza> pizzas = Arrays.asList(MARGHERITA, CAPRI, HAVAI, CARUSO, MAMA_MIA, SOPRANO,CALABRESE, VEGETARIANA, CAPRESE, PASCETORE, FOUR_CHEESE, TABASCO, AMORE, FARMER);
        App instance = new App();
        String expResult = "Marrgherita: cienkie ciasto, sos pomidorowy, ser - 13\n" +
                            "Capri: cienkie ciasto, sos pomidorowy, ser, szynka, pieczarki - 17\n" +
                            "Havai: cienkie ciasto, sos pomidorowy, ser, szynka, ananas - 17\n" +
                            "Caruso: cienkie ciasto, sos pomidorowy, kiełbasa, papryka peperoni - 15\n" +
                            "Mama Mia: cienkie ciasto, sos pomidorowy, ser, cebula, pieczarki, bekon - 18\n" +
                            "Soprano: grube ciasto, sos pomidorowy, ser, szynka, pieczarki, cebula, bekon, pieprz - 23\n" +
                            "Calabrese: grube ciasto, sos pomidorowy, ser, szynka, pieczarki, kiełbasa, cebula, oliwki - 24\n" +
                            "Vegetariana: cienkie ciasto, sos pomidorowy, ser, cebula, fasola, kukurydza, brokuły, rukola - 20\n" +
                            "Caprese: grube ciasto, sos pomidorowy, mozarella, ser feta, pomidor, bazylia - 19\n" +
                            "Pascetore: cienkie ciasto, sos pomidorowy, ser, tuńczyk, cebula - 16\n" +
                            "Cztery sery: cienkie ciasto, sos pomidorowy, ser, mozarella, ser feta, ser pleśniowy - 19\n" +
                            "Tabasco: grube ciasto, sos pomidorowy, ser, szynka, salami, papryka peperoni, kukurydza, tabasco - 22\n" +
                            "Amore: cienkie ciasto, sos pomidorowy, ser, kurczak, pomidor - 16\n" +
                            "Farmerska: grube ciasto, sos pomidorowy, ser, kurczak, bekon, cebula, kukurydza - 22";
        String result = instance.formatedMenu(pizzas);
        assertEquals(expResult, result);
    }
    @Test
    public void testFormatedMenu2() {
        System.out.println("formatedMenu2");
        List<Pizza> pizzas = Arrays.asList(MARGHERITA, CAPRI);
        App instance = new App();
        String expResult = "Marrgherita: cienkie ciasto, sos pomidorowy, ser - 13\n" +
                            "Capri: cienkie ciasto, sos pomidorowy, ser, szynka, pieczarki - 17";
                            
        String result = instance.formatedMenu(pizzas);
        assertEquals(expResult, result);
    }
}
