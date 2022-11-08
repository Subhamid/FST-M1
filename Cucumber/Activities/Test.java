package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test extends BaseClass{

    @Given("^user is on TS Home page$")
    public void openTSHomePage()

    {
        driver.get("https://training-support.net");
    }

    @When("^user click on About us button")
    public void clickAboutusBtn()
    {
        driver.findElement(By.id("about-link")).click();
    }

    @Then("^user is taken to About us page$")
            public void aboutUsPageVerification(){
            String AboutusPageTitle=driver.findElement(By.xpath("//h1[@class='ui header']")).getText();
            Assert.assertEquals("About Us", AboutusPageTitle);
}

}
