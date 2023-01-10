package com.bestbuy.cucumber.steps;

import com.bestbuy.studentinfo.StoreSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStoreSteps {
    static ValidatableResponse response;
    static int storeID;
    StoreSteps storeSteps;

    @When("^User sends a GET request to list endpoint for store$")
    public void userSendsAGETRequestToListEndpointForStore() {
        response = storeSteps.getAllStoreList();
    }

    @Then("^User must get back a valid status code (\\d+) for successful store create$")
    public void userMustGetBackAValidStatusCodeForSuccessfulStoreCreate() {
        response.statusCode(200);

    }

    @When("^I create a new store by providing the information name \"([^\"]*)\" type \"([^\"]*)\" address \"([^\"]*)\" address(\\d+) \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" lat \"([^\"]*)\" lng \"([^\"]*)\" hours \"([^\"]*)\"$")
    public void iCreateANewStoreByProvidingTheInformationNameTypeAddressAddressCityStateZipLatLngHours(String name, String type, String address, String address2, String city, String state,
                                                                                                       String zip, double lat, double lng, String hours)  {
response=storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours);
    }

    @Then("^I verify that the store with \"([^\"]*)\" is created$")
    public void iVerifyThatTheStoreWithIsCreated(String name)  {
        HashMap<String, Object> productMap = storeSteps.getStoreInfoByStoreID(storeID);
        Assert.assertThat(productMap, hasValue(name));

    }

    @And("^I update the store with information name \"([^\"]*)\" type \"([^\"]*)\" address \"([^\"]*)\" address(\\d+) \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" lat \"([^\"]*)\" lng \"([^\"]*)\" hours \"([^\"]*)\"$")
    public void iUpdateTheStoreWithInformationNameTypeAddressAddressCityStateZipLatLngHours(String name, String type, String address, String address2, String city, String state,
                                                                                            String zip, double lat, double lng, String hours)  {
        name = name + "_updated";
        storeSteps.updateStore(storeID, name, type, address, address2, city, state, zip, lat, lng, hours);
        HashMap<String, Object> storeMap = storeSteps.getStoreInfoByStoreID(storeID);
        Assert.assertThat(storeMap, hasValue(name));

    }

    @And("^I delete the store that created with name \"([^\"]*)\"$")
    public void iDeleteTheStoreThatCreatedWithName(String arg0)  {
        response= storeSteps.deleteStoreByID(storeID);

    }

    @Then("^The store deleted successfully from the list$")
    public void theStoreDeletedSuccessfullyFromTheList() {
        response.statusCode(204);
        storeSteps.getStoreById(storeID).statusCode(404);
    }
}
