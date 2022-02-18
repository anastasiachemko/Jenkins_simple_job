package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATest extends TestBase {

    @Test
    public void fillForm() {

        String
                firstName = "Egor",
                lastName = "Me",
                userEmail = "ya@ya.ru",
                gender = "Male",
                userNumber = "1234567890",
                subject = "Physics",
                hobbySport = "Sports",
                uploadPicture = "Test.jpeg",
                currentAddress = "Somewhere",
                state = "NCR",
                city = "Noida";

        open("");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2000");
        $x("//div[contains(text(),'11')]").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbySport)).click();
        $("#uploadPicture").uploadFromClasspath(uploadPicture);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table tbody").shouldHave(text("Egor Me"),
                text("ya@ya.ru"),
                text("Male"),
                text("1234567890"),
                text("11 May,2000"),
                text("Sport"),
                text("Test.jpeg"),
                text("Somewhere"),
                text("NCR Noida"));
    }
}






