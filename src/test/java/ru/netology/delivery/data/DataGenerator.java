package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    private static Faker faker;

    public static String generateDate(int shift) {
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        return java.time.LocalDate.now()
                .plusDays(shift).format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        var cities = new String[]{"Белгород", "Брянск", "Владимир", "Воронеж", "Иваново", "Калуга", "Кострома", "Курск",
                "Липецк", "Москва", "Орел", "Рязань", "Смоленск", "Тамбов", "Тверь", "Тула", "Ярославль",
                "Архангельск", "Вологда", "Калининград", "Петрозаводск", "Сыктывкар", "Санкт-Петербург", "Мурманск",
                "Салехард", "Великий Новгород", "Псков", "Уфа", "Киров", "Йошкар-Ола", "Саранск", "Нижний Новгород",
                "Оренбург", "Пенза", "Пермь", "Самара", "Саратов", "Казань", "Ижевск", "Ульяновск", "Чебоксары", "Курган",
                "Екатеринбург", "Тюмень", "Ханты-мансийск", "Челябиннск", "Салехард"
        };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }


    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            String city = generateCity(locale);
            String name = generateName(locale);
            String phone = generatePhone(locale);

            UserInfo user = new UserInfo(city, name, phone);
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
