package com.bestbuy.cucumber.steps;

import com.bestbuy.studentinfo.ProductSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyProductSteps {

    static ValidatableResponse response;


    static int productID;


    ProductSteps productSteps;

    @When("^User sends a GET request to list endpoint$")
    public void userSendsAGETRequestToListEndpoint() {
        response=  productSteps.getAllProductList();
    }

    @Then("^User must get back a valid status code (\\d+)$")
    public void userMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }


    @When("^I create a new product by providing the information name \"([^\"]*)\" type \"([^\"]*)\" price \"([^\"]*)\" shipping \"([^\"]*)\" upc \"([^\"]*)\" description \"([^\"]*)\" manufacturer \"([^\"]*)\" model \"([^\"]*)\" url \"([^\"]*)\" image \"([^\"]*)\"$")
    public void iCreateANewProductByProvidingTheInformationNameTypePriceShippingUpcDescriptionManufacturerModelUrlImage(String name, String type, Double price, int shipping, String upc, String description, String manufacturer, String model, String url, String image)  {
        response= productSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image);
    }



    @Then("^I verify that the product with \"([^\"]*)\" is created$")
    public void iVerifyThatTheProductWithIsCreated(String name)  {
        HashMap<String, Object> productMap = productSteps.getProductInfoByProductName(productID);
        Assert.assertThat(productMap, hasValue(name));
    }

    @And("^I update the product with information name \"([^\"]*)\" type \"([^\"]*)\" price \"([^\"]*)\" shipping \"([^\"]*)\" upc \"([^\"]*)\" description \"([^\"]*)\" manufacturer \"([^\"]*)\" model \"([^\"]*)\" url \"([^\"]*)\" image \"([^\"]*)\"$")
    public void iUpdateTheProductWithInformationNameTypePriceShippingUpcDescriptionManufacturerModelUrlImage( String name, String type, Double price, int shipping, String upc, String description, String manufacturer, String model, String url, String image)  {
        name = name + "_updated";
        productSteps.updateProduct(productID, name, type, price, shipping, upc, description, manufacturer, model, url, image);
        HashMap<String, Object> productMap = productSteps.getProductInfoByProductName(productID);
        Assert.assertThat(productMap, hasValue(name));
    }



    @And("^I delete the product that created with name \"([^\"]*)\"$")
    public void iDeleteTheProductThatCreatedWithName()  {
        productSteps.deleteProduct(productID).statusCode(200);
    }

    @Then("^The product deleted successfully from the list$")
    public void theProductDeletedSuccessfullyFromTheList() {
        productSteps.getProduct(productID).statusCode(404);
    }
}
