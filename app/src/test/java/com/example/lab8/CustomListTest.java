package com.example.lab8;



import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        Assertions.assertFalse(list.hasCity(city));
        list.addCity(city);
        Assertions.assertTrue(list.hasCity(city));
    }

    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        Assertions.assertTrue(list.hasCity(city));
        list.deleteCity(city);
        Assertions.assertFalse(list.hasCity(city));
    }

    @Test
    public void countCitiesTest(){
        list = MockCityList();
        Assertions.assertEquals(list.getCount(), 0);
        City city = new City("Estevan", "SK");
        list.addCity(city);
        Assertions.assertEquals(list.getCount(), 1);
        City city2 = new City("TestCity", "AB");
        list.addCity(city2);
        Assertions.assertEquals(list.countCities(), 2);
        City city3 = new City("TestCity2", "AB");
        City city4 = new City("TestCity3", "AB");
        list.addCity(city3);
        list.addCity(city4);
        Assertions.assertEquals(list.countCities(), 4);
    }

}
