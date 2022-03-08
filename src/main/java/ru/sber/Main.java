package ru.sber;

import ru.sber.model.City;

import java.util.List;

import static ru.sber.CityUtils.*;

public class Main {

    public static void main(String[] args) {
        List<City> originCities = getAllCities();
        print(originCities);

        List<City> citiesSortedByName = sortByNameCaseInsensitive(originCities);
        print(citiesSortedByName);

        List<City> citiesSortedByDistrictAndThenByName = sortByDistrictAndThenByNameCaseSensitive(originCities);
        print(citiesSortedByDistrictAndThenByName);
    }
}