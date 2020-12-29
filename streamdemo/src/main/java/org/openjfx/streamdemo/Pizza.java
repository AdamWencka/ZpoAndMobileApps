/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.streamdemo;

import java.util.Arrays;
import java.util.List;
import static org.openjfx.streamdemo.Ingredients.Ingredient.ARUGULA;
import static org.openjfx.streamdemo.Ingredients.Ingredient.BASIL;
import static org.openjfx.streamdemo.Ingredients.Ingredient.BEAN;
import static org.openjfx.streamdemo.Ingredients.Ingredient.BECON;
import static org.openjfx.streamdemo.Ingredients.Ingredient.BLUE_CHEESE;
import static org.openjfx.streamdemo.Ingredients.Ingredient.BROCCOLI;
import static org.openjfx.streamdemo.Ingredients.Ingredient.CHEESE;
import static org.openjfx.streamdemo.Ingredients.Ingredient.CHICKEN;
import static org.openjfx.streamdemo.Ingredients.Ingredient.CORN;
import static org.openjfx.streamdemo.Ingredients.Ingredient.FETA;
import static org.openjfx.streamdemo.Ingredients.Ingredient.HAM;
import static org.openjfx.streamdemo.Ingredients.Ingredient.MOZARELLA;
import static org.openjfx.streamdemo.Ingredients.Ingredient.MUSHROOMS;
import static org.openjfx.streamdemo.Ingredients.Ingredient.OLIVES;
import static org.openjfx.streamdemo.Ingredients.Ingredient.ONION;
import static org.openjfx.streamdemo.Ingredients.Ingredient.PEPERONI;
import static org.openjfx.streamdemo.Ingredients.Ingredient.PEPPER;
import static org.openjfx.streamdemo.Ingredients.Ingredient.PINEAPPLE;
import static org.openjfx.streamdemo.Ingredients.Ingredient.SALAMI;
import static org.openjfx.streamdemo.Ingredients.Ingredient.SUASAGE;
import static org.openjfx.streamdemo.Ingredients.Ingredient.TABASCO_SUACE;
import static org.openjfx.streamdemo.Ingredients.Ingredient.THICK_CRUST;
import static org.openjfx.streamdemo.Ingredients.Ingredient.THIN_CRUST;
import static org.openjfx.streamdemo.Ingredients.Ingredient.TOMATO;
import static org.openjfx.streamdemo.Ingredients.Ingredient.TOMATO_SUACE;
import static org.openjfx.streamdemo.Ingredients.Ingredient.TUNA;

/**
 *
 * @author Adam
 */
public enum Pizza {
        MARGHERITA("Marrgherita", THIN_CRUST, TOMATO_SUACE, CHEESE),
        CAPRI("Capri", THIN_CRUST, TOMATO_SUACE, CHEESE, HAM, MUSHROOMS),
        HAVAI("Havai", THIN_CRUST, TOMATO_SUACE, CHEESE, HAM, PINEAPPLE),
        CARUSO("Caruso", THIN_CRUST, TOMATO_SUACE, SUASAGE, PEPERONI),
        MAMA_MIA("Mama Mia", THIN_CRUST, TOMATO_SUACE, CHEESE, ONION, MUSHROOMS, BECON),
        SOPRANO("Soprano", THICK_CRUST, TOMATO_SUACE, CHEESE, HAM, MUSHROOMS, ONION, BECON, PEPPER),
        CALABRESE("Calabrese", THICK_CRUST, TOMATO_SUACE, CHEESE, HAM, MUSHROOMS, SUASAGE, ONION, OLIVES),
        VEGETARIANA("Vegetariana", THIN_CRUST, TOMATO_SUACE, CHEESE, ONION, BEAN, CORN, BROCCOLI, ARUGULA),
        CAPRESE("Caprese", THICK_CRUST, TOMATO_SUACE, MOZARELLA, FETA, TOMATO, BASIL),
        PASCETORE("Pascetore", THIN_CRUST, TOMATO_SUACE, CHEESE, TUNA, ONION),
        FOUR_CHEESE("Cztery sery", THIN_CRUST, TOMATO_SUACE, CHEESE, MOZARELLA, FETA, BLUE_CHEESE),
        TABASCO("Tabasco", THICK_CRUST, TOMATO_SUACE, CHEESE, HAM, SALAMI, PEPERONI, CORN, TABASCO_SUACE),
        AMORE("Amore", THIN_CRUST, TOMATO_SUACE, CHEESE, CHICKEN, TOMATO),
        FARMER("Farmerska", THICK_CRUST, TOMATO_SUACE, CHEESE, CHICKEN, BECON, ONION, CORN);
        
        private final String name;
        private final List<Ingredients.Ingredient> ingredients;

        private Pizza(String name, Ingredients.Ingredient... ingredients) {
            this.name = name;
            this.ingredients = Arrays.asList(ingredients);
        }

        public String getName() {
            return name;
        }

        public List<Ingredients.Ingredient> getIngredients() {
            return ingredients;
        }

        @Override
        public String toString() {
            return name;
        }
}
