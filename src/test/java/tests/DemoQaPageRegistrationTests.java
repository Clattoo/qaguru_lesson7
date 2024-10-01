package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class DemoQaPageRegistrationTests extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    Faker faker = new Faker();

    String firstName = RandomUtils.getRandomFirstName(),
            lastName = RandomUtils.getRandomLastName(),
            userEmail = RandomUtils.getRandomEmail(),
            userGender = RandomUtils.getRandomGender(),
            userPhone = RandomUtils.getRandomUserPhone(),
            userIncorrectPhone = RandomUtils.getRandomIncorrectUserPhone(),
            userDayOfBirth = RandomUtils.getRandomDayOfBirth(),
            userMonthOfBirth = RandomUtils.getRandomMonthOfBirth(),
            userYearOfBirth = RandomUtils.getRandomYearOfBirth(),
            userSubjects = RandomUtils.getRandomSubjects(),
            userHobbies = RandomUtils.getRandomHobbies(),
            userUploadPicture = RandomUtils.getRandomUploadPicture(),
            userCurrentAddress = RandomUtils.getRandomCurrentAddress(),
            userState = RandomUtils.getRandomUserState(),
            userCity = RandomUtils.getRandomUserCity(userState);

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhoneNumber(userPhone)
                .setDateOfBirth(userDayOfBirth, userMonthOfBirth, userYearOfBirth)
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .setUserUploadPicture(userUploadPicture)
                .setUserCurrentAddress(userCurrentAddress)
                .setUserState(userState)
                .setUserCity(userCity)
                .clickSubmit();


        // Проверка результатов теста

        registrationPage.checkResults("Student Name", firstName + " " + lastName)
                        .checkResults("Student Email", userEmail)
                        .checkResults("Gender", userGender)
                        .checkResults("Mobile", userPhone)
                        .checkResults("Date of Birth", userDayOfBirth + " " + userMonthOfBirth + "," + userYearOfBirth)
                        .checkResults("Subjects", userSubjects)
                        .checkResults("Hobbies", userHobbies)
                        .checkResults("Picture", userUploadPicture)
                        .checkResults("Address", userCurrentAddress)
                        .checkResults("State and City", userState + " " + userCity);
    }

    @Test
    public void successfulMinDataRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setPhoneNumber(userPhone)
                .clickSubmit();

        // Проверка результатов теста

        registrationPage.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userPhone);
    }

    @Test
    public void negativeRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setPhoneNumber(userIncorrectPhone)
                .clickSubmit();

        // Проверка результатов теста

        registrationPage.checkUnsuccessfulRegistration();
    }

}
