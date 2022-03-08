package ru.sber;

import ru.sber.model.City;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityUtils {

    private static final String SEMICOLON = ";";
    private static final String PATH_TO_FILE = "./testdatacity/city_ru.csv";
    private static final String START_LINE_PATTERN = "\\d*";

    public static List<City> getAllCities() {
        final List<City> cities = new ArrayList<>();
        try {
            final Scanner scanner = new Scanner(Paths.get(PATH_TO_FILE)); // Загрузка данных из файла
            while (scanner.hasNextLine()) { // Обработка данных и заполнение массива
                final City currentCity = createCityFromLine(scanner.nextLine().trim());
                cities.add(currentCity);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }

    private static City createCityFromLine(String line) {
        final Scanner scanner = new Scanner(line);
        scanner.useDelimiter(SEMICOLON); // Задается разделитель в строке с данными
        scanner.skip(START_LINE_PATTERN); // Необходимо пропустить значение номера строки по условиям задачи

        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = scanner.hasNext() ? scanner.next() : null; // В файле с городами возможно отсутствие данного значения
        scanner.close();

        return new City(name, region, district, population, foundation);
    }
}