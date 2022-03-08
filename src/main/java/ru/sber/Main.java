package ru.sber;

import ru.sber.model.City;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static final String SEMICOLON = ";";
    private static final String NO_DATA = "N/A";
    private static final String PATH_TO_FILE = "./testdatacity/city_ru.csv";

    private static final List<City> CITIES = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(Paths.get(PATH_TO_FILE));

        while(scanner.hasNextLine()) {
            final City currentCity = createCityFromLine(scanner.nextLine().trim());
            CITIES.add(currentCity);
        }
        scanner.close();

        CITIES.forEach(System.out::println);
    }

    private static City createCityFromLine(String line) {
        final List<String> cityData = new ArrayList<>(Arrays.asList(line.split(SEMICOLON)));
        // N/A - если нет данных о дате основания или первом упоминании (на конце строки)
        if (cityData.size() == 5 && line.endsWith(SEMICOLON)) {
            cityData.add(NO_DATA);
        }
        // N/A - если нет каких-либо данных в середине строки
        IntStream.range(0, cityData.size()).filter(i -> cityData.get(i).isEmpty()).forEach(i -> cityData.set(i, NO_DATA));
        // строка начинается с №п/п - пропускаем его
        return new City(cityData.get(1), cityData.get(2), cityData.get(3), cityData.get(4), cityData.get(5));
    }
}