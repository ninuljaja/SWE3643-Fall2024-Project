package org.example;

import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;

import org.junit.jupiter.api.*;

@UsePlaywright
public class E2ETests {
    @Test
    void test(Page page) {
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByLabel("Values").fill("9\n2\n5\n4\n12\n7\n8\n11\n9\n3\n7\n4\n12\n5\n4\n10\n9\n6\n9\n4");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Sample Standard")).click();

        page.getByText("Sample Standard Deviation", new Page.GetByTextOptions().setExact(true)).click();
        page.getByText("Sample Standard Deviation3.").click();
        page.locator("#result").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear")).click();
    }
    @Test
    void test2(Page page) {
        page.navigate("http://localhost:8080/");
        page.getByLabel("Values").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Population Standard")).click();
        page.getByText("Please enter values first!").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear")).click();
    }


}