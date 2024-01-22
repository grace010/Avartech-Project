package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
    private Locale local = new Locale("en");
    private Faker faker = new Faker(local);
    public static DataHelper getDatHelper(){
        return new DataHelper();
    }

    public String getFirstName(){
        return faker.address().firstName();
    }

    public String getLastName(){
        return faker.address().lastName();
    }

    public String getEmailAddress(){
        return faker.internet().emailAddress();
    }

    public String getCity(){
        return faker.address().city();
    }
    public String getCityName(){
        return faker.address().city();
    }

    public String getPhoneNumber(){
        return faker.phoneNumber().phoneNumber();
    }

    public String getAddress(){
        return faker.address().streetAddress();
    }

    public String getPassword() {
        return faker.internet().password(8, 12);
    }
}
