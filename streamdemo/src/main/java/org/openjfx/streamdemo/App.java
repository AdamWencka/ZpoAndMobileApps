/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.streamdemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.*; 
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;

import static org.openjfx.streamdemo.Pizza.*;


/**
 *
 * @author Adam
 */
public class App  {
    
    public Pizza findCheapestSpicy(List <Pizza> pizzas){
        return pizzas.stream()
                .filter(p->p.getIngredients().stream().anyMatch(i->i.isSpicy()))
                .min((p1, p2) ->
                    p1.getIngredients().stream().mapToInt(i->i.getPrice()).sum()-
                    p2.getIngredients().stream().mapToInt(i->i.getPrice()).sum())
                .orElse(null);
       
    }
    
    public Pizza findMostExpensiveVegetarian(List <Pizza> pizzas){
        return pizzas.stream()
                .filter(p -> p.getIngredients().stream().noneMatch(i -> i.isMeat()))
                .max((p1,p2) ->
                    p1.getIngredients().stream().mapToInt(i->i.getPrice()).sum()-
                    p2.getIngredients().stream().mapToInt(i->i.getPrice()).sum())
                .orElse(null);
    }
    
    public List <Pizza> iLikeMeat(List <Pizza> pizzas){
        return pizzas.stream()                
                .filter(p -> p.getIngredients().stream().anyMatch(i -> i.isMeat()))         
                .sorted((Pizza p1, Pizza p2)->{
                    return(int) (p2.getIngredients().stream()
                                .filter(i->i.isMeat()).count()-
                                p1.getIngredients().stream()
                                .filter(i->i.isMeat()).count());        
                }).collect(toList());
    }
    public Map<Integer, List<Pizza>> groupByPrice(List<Pizza> pizzas){
        return pizzas.stream()
                .sorted()
                .collect(Collectors.groupingBy(p1 ->
                        p1.getIngredients().stream().mapToInt(i->i.getPrice()).sum())); 
    }
    
    public String formatedMenu(List <Pizza> pizzas){
        return pizzas.stream()
                .map(p -> p.getName() +
                        ": " +
                        p.getIngredients().stream()
                            .map(i ->i.getName()).collect(Collectors.joining(", "))+
                        " - " +
                        p.getIngredients().stream().mapToInt(i -> i.getPrice()).sum())
                        .collect(Collectors.joining("\n"));
    }
    
    public static void main(String[] args) {
        List<Pizza> pizzas = Arrays.asList(SOPRANO, CAPRI, FOUR_CHEESE);
        String result = pizzas.stream()
                .map(p -> p.getName() +
                        ": " +
                        p.getIngredients().stream()
                            .map(i ->i.getName()).collect(Collectors.joining(", "))+
                        "- " +
                        p.getIngredients().stream().mapToInt(i -> i.getPrice()).sum())
                        .collect(Collectors.joining("\n"));
                
                System.out.println(result);
                
    }


}
