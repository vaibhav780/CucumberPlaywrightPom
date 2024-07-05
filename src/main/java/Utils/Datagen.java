package Utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Datagen {

    Faker faker = new Faker(new Locale("en-IND"));

    String fname;
    String lastname;
    String middlename;
    String telephone;
    String password;
    String email;

    public String getFnam() {
        return String.valueOf(faker.name().firstName());
    }

    public String getLastname() {
        return String.valueOf(faker.name().lastName());
    }


    public String getMiddlename() {
        return String.valueOf(faker.name().nameWithMiddle());
    }

    public String getTelephone() {
        return String.valueOf(faker.phoneNumber().cellPhone());
    }

    public String getPassword() {
        return String.valueOf(faker.internet().password());
    }

    public String getEmail() {
        return String.valueOf(faker.internet().emailAddress());
    }
}
