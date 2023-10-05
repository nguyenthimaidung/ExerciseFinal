package demowebshop.utils;

import com.github.javafaker.Faker;

public class DataUtils {
    private Faker faker;
    public static DataUtils getData() {
        return new DataUtils();
    }

    private DataUtils() {
        faker = new Faker();
    }

    public String getFirstName() {
        return faker.name().firstName();
    }
    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String getFirstNameAddress() {
        return faker.address().firstName();
    }

    public String getLastNameAddress() {

        return faker.address().lastName();
    }

    public String getCompanyName() {

        return faker.company().name();
    }

    public String getCityName() {
        return faker.address().cityName();
    }

    public String getFullAddress() {
        return faker.address().fullAddress();
    }

    public String getZipCode() {
        return faker.address().zipCode();
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

}
