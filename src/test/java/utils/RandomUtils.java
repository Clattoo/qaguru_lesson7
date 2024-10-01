package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class RandomUtils {

    static Faker faker = new Faker();

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getRandomUserPhone() {
        return faker.number().digits(10);
    }

    public static String getRandomIncorrectUserPhone() {
        return faker.number().digits(9);
    }

    public static String getRandomDayOfBirth() {
        return String.format("%02d", faker.number().numberBetween(1,28));
        }
//    }

    public static String getRandomMonthOfBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public static String getRandomYearOfBirth() {
        return new SimpleDateFormat("yyyy").format(faker.date().birthday());
    }

    public static String getRandomSubjects() {
        return faker.options().option("Arts", "Accounting", "Math", "Social Studies");
    }

    public static String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getRandomUploadPicture() {
        return faker.options().option("1.jpg", "2.jpg", "3.jpg");
    }

    public static String getRandomCurrentAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomUserState() {
        String randomState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

        return randomState;
    }

    public static String getRandomUserCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut" );
            case "Haryana" -> faker.options().option("Karnal", "Panipap");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalStateException("Unexpected value: " + state);
        };

    }
}
