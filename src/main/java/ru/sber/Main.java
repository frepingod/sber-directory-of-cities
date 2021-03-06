package ru.sber;

import ru.sber.model.City;

import java.util.List;
import java.util.Map;

import static ru.sber.CityUtils.*;

public class Main {

    public static void main(String[] args) {
        List<City> cities = getAllCities();
        print(cities);

        sortByNameCaseInsensitive(cities);
        print(cities);

        sortByDistrictAndThenByNameCaseSensitive(cities);
        print(cities);

        Map<Integer, Integer> cityWithHighestPopulation = getCityIndexAndValueWithHighestPopulation(cities);
        printMapPopulation(cityWithHighestPopulation);

        Map<String, Integer> cityNumbersByRegion = getCityNumbersByRegion(cities);
        printMapRegion(cityNumbersByRegion);

        Map<String, Integer> cityNumbersByRegion2 = getCityNumbersByRegion2(cities);
        printMapRegion(cityNumbersByRegion2);
    }
}