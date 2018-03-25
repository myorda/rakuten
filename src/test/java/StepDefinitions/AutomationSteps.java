package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AutomationSteps {

    /* Elements locators listed here*/
    private final By searchBarLocator = By.id("q");
    private final By searchButtonLocator = By.className("b-btn-search tr_header_search_icon");
    private final By autocompleteListLocator = By.id("search_term_list");
    private final By autocompleteFirstElementtLocator = By.cssSelector("li.searchlist:nth-child(2)");
    private final By productsListLocator = By.id("products-list");
    private final By firstProducttLocator = By.xpath("//ul[@class='row-0']/li[1]");
    private final By addToCartButtonLocator = By.xpath("//input[@name='button'][@value='in den Warenkorb']");
    private final By fancyBoxButtonLocator = By.id("atc_b_tsc");
    private final By goToCheckoutButtonLocator = By.id("go_to_checkout");
    private final By clientEmailFieldLocator = By.id("client_email");
    private final By clientPasswordFieldLocator = By.id("password");
    private final By goToMyDataButtonLocator = By.id("go_to_next_step");
    private final By paymentMethodsLocator = By.id("content");
    private final By clientAddressLocator = By.id("top-address");



    private WebDriver driver;
    private String rakutenLoginPage = "https://www.rakuten.de/";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
                options.addArguments("no-sandbox");
                options.addArguments("--start-maximized");
                options.addArguments("ignore-certificate-errors");
                options.addArguments("--allow-running-insecure-content");
        this.driver = new ChromeDriver(options);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("^I am on rakuten homepage$")
    public void iAmOnRakutenHomepage() {
        driver.navigate().to(rakutenLoginPage);
        WebElement searchBar = driver.findElement(searchBarLocator);
        assertTrue("Rakuten.de homepage is not available", searchBar.isDisplayed());
    }


    @When("^I insert \"([^\"]*)\" in the search bar$")
    public void iInsertInTheSearchBar(String product) {
        WebElement searchBar = driver.findElement(searchBarLocator);
        searchBar.sendKeys(product);
    }

    @And("^I select any item from the autocomplete list$")
    public void iSelectAnyItemFromTheAutocompleteList() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(autocompleteListLocator));
        WebElement firstElementFromList = driver.findElement(autocompleteFirstElementtLocator);
        firstElementFromList.click();
    }

    @Then("^Search results page should be opened$")
    public void searchResultsPageShouldBeOpened() {
        WebElement productsList = driver.findElement(productsListLocator);
        assertTrue(productsList.isDisplayed());
    }

    @And("^I select any product from the search result page$")
    public void iSelectAnyProductFromTheSearchResultPage() {
        WebElement firstProduct = driver.findElement(firstProducttLocator);
        firstProduct.click();
    }

    @And("^I add the product to the Shopcart$")
    public void iAddTheProductToTheShopcart() {
        WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
        addToCartButton.click();
        WebElement fancyBoxButton = driver.findElement(fancyBoxButtonLocator);
        fancyBoxButton.click();
    }

    @And("^I proceed to checkout page$")
    public void iProceedToCheckoutPage() {
        WebElement goToChechoutButton = driver.findElement(goToCheckoutButtonLocator);
        goToChechoutButton.click();
    }

    @And("^I proceed with my client profile$")
    public void iProceedWithMyClientProfile() {
        WebElement email = driver.findElement(clientEmailFieldLocator);
        email.sendKeys("mblg@mail.bg");
        WebElement password = driver.findElement(clientPasswordFieldLocator);
        password.sendKeys("Password@2");
        WebElement goToMyDataButton = driver.findElement(goToMyDataButtonLocator);
        goToMyDataButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(clientAddressLocator));
        WebElement goToPaymentMethods = driver.findElement(goToMyDataButtonLocator);
        goToPaymentMethods.click();
    }

    @Then("^Payment methods selection page should be displayed$")
    public void paymentMethodsSelectionPageShouldBeDisplayed() {
        WebElement paymentMethods = driver.findElement(paymentMethodsLocator);
        assertTrue(paymentMethods.isDisplayed());
    }
}
