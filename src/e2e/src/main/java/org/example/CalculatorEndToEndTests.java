package org.example;

import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;

import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class CalculatorEndToEndTests {
//    @Test
//    void test(Page page) {
//        page.navigate("http://localhost:8080/");
//        page.getByLabel("Values").click();
//        page.getByLabel("Values").fill("9\n2\n5\n4\n12\n7\n8\n11\n9\n3\n7\n4\n12\n5\n4\n10\n9\n6\n9\n4");
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Sample Standard")).click();
//
//        page.getByText("Sample Standard Deviation", new Page.GetByTextOptions().setExact(true)).click();
//        page.getByText("Sample Standard Deviation3.").click();
//        page.locator("#result").click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear")).click();
//    }
    @Test
    void test(Page page) {
        //preq-E2E-TEST-6

        // Arrange
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("9\n2\n5\n4\n12\n7\n8\n11\n9\n3\n7\n4\n12\n5\n4\n10\n9\n6\n9\n4");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Sample Standard")).click();

        // Assert
        assertThat(page.locator("span")).containsText("3.060787652326");
    }
    @Test
    void test2(Page page) {
        //preq-E2E-TEST-7

        // Arrange
        page.navigate("http://localhost:8080/");

        // Act
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Population Standard")).click();

        // Assert
        assertThat(page.locator("#result")).containsText("Please enter values first!");
    }
    @Test
    void test3(Page page) {
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("5");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Sample Standard")).click();
        assertThat(page.locator("span")).containsText("Invalid input.Invalid input format. Expected at least 2 values, one value per line");
    }



}