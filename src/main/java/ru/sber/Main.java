package ru.sber;

import ru.sber.model.City;

import java.util.List;

import static ru.sber.CityUtils.*;

public class Main {

    public static void main(String[] args) {
        List<City> cities = getAllCities();
        print(cities);
    }
}