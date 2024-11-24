package org.example;

import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;

import org.junit.jupiter.api.*;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@UsePlaywright
public class CalculatorEndToEndTests {



    @Test
    void WebCalculator_PageTitle_ReturnsCalculator(Page page) {
        //preq-E2E-TEST-5

        // Arrange
        String pageTitle = "Calculator";
        page.navigate("http://localhost:8080/");


        // Assert
        assertThat(page).hasTitle(Pattern.compile(pageTitle));
    }

    @Test
    void WebCalculator_ComputeSampleStdDev_ReturnsResult(Page page) {
        //preq-E2E-TEST-6

        // Arrange
        double expectedResult = 3.060787652326;
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("9\n2\n5\n4\n12\n7\n8\n11\n9\n3\n7\n4\n12\n5\n4\n10\n9\n6\n9\n4");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Sample Standard")).click();
        String resultText = page.locator("#result").textContent();
        double result = Double.parseDouble(resultText.trim());

        // Assert
        assertEquals(expectedResult, result, 1e-10);

    }
    @Test
    void WebCalculator_ComputePopulationStdDevWithEmptyInputBox_ReturnsInvalidInputError(Page page) {
        //preq-E2E-TEST-7

        // Arrange
        page.navigate("http://localhost:8080/");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Population Standard")).click();

        // Assert
        assertThat(page.locator("#resultLabel")).containsText("Please enter values first");
    }
    @Test
    void WebCalculator_ComputeSampleStdDevWithOneValue_ReturnInvalidInputError(Page page) {
        //preq-E2E-TEST-8

        // Arrange
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("5");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Sample Standard")).click();

        // Assert
        assertThat(page.locator("#resultLabel")).containsText("Invalid input format. Expected at least 2 values, one value per line");
    }

    @Test
    void WebCalculator_ComputeMean_ReturnResult(Page page) {
        //preq-E2E-TEST-9

        // Arrange
        double expectedResult = 7;
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("9\n2\n5\n4\n12\n7\n8\n11\n9\n3\n7\n4\n12\n5\n4\n10\n9\n6\n9\n4");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Mean | one value per")).click();
        String resultText = page.locator("#result").textContent();
        double result = Double.parseDouble(resultText.trim());

        // Assert
        assertEquals(expectedResult, result, 1e-10);
    }
    @Test
    void WebCalculator_ComputeZScore_ReturnResult(Page page) {
        //preq-E2E-TEST-11

        // Arrange
        double expectedResult = -0.49007;
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("5.5,7,3.060787652326");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Z Score | value, mean")).click();
        String resultText = page.locator("#result").textContent();
        double result = Double.parseDouble(resultText.trim());

        // Assert
        assertEquals(expectedResult, result, 1e-7);
    }


    @Test
    void WebCalculator_ComputeLinearRegressionFormula_ReturnResult(Page page) {
        //preq-E2E-TEST-11

        // Arrange
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("5,3\n3,2\n2,15\n1,12.3\n7.5,-3\n4,5\n3,17\n4,3\n6.42,4\n34,5\n12,17\n3,-1");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Single Linear")).click();

        // Assert
        assertThat(page.locator("#resultLabel")).containsText("y = -0.0459615329x + 6.9335877814");
    }

    @Test
    void WebCalculator_PredictY_ReturnResult(Page page) {
        //preq-E2E-TEST-12

        // Arrange
        double expectedResult = 6.65784;
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("6,-0.04596,6.9336");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Predict Y from Linear")).click();
        String resultText = page.locator("#result").textContent();
        double result = Double.parseDouble(resultText.trim());

        // Assert
        assertEquals(expectedResult, result, 1e-10);
    }
    @Test
    void WebCalculator_PressClearButton_ValuesTextAreaCleared(Page page) {
        // Arrange
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("5\n4\n");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear")).click();

        // Assert
        String valueAfterClear = page.getByLabel("Values").inputValue();
        assertEquals("", valueAfterClear);


    }
    @Test
    void WebCalculator_NonNumericInput_InvalidInputError(Page page) {
        // Arrange
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("5\nd\n5");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Sample Standard")).click();

        // Assert
        assertThat(page.locator("#resultLabel")).containsText("Invalid Input, Numbers Only");
    }

    @Test
    void WebCalculator_ComputePopulationStdDev_ReturnsResult(Page page) {
        //preq-E2E-TEST-6

        // Arrange
        double expectedResult = 1.4142135623731;
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("9\n6\n8\n5\n7");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Population Standard")).click();
        String resultText = page.locator("#result").textContent();
        double result = Double.parseDouble(resultText.trim());

        // Assert
        assertEquals(expectedResult, result, 1e-10);

    }












}