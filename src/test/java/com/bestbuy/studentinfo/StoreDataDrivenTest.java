package com.bestbuy.studentinfo;

import com.bestbuy.constants.path;
import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

/**
 * Created by Jay
 */
/*@Concurrent(threads = "8x")
@UseTestDataFrom("src/test/java/resources/testdata/studentinfo.csv")
@RunWith(SerenityParameterizedRunner.class)*/
public class StoreDataDrivenTest extends TestBase {

    public static String getRandomValue() {
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }



    static String name = "Minnetonka" + getRandomValue();
    static String type = "BigBox" + getRandomValue();
    static String address = "13213 Ridgedale Road";
    static String address2 ="";
    static String city = "Washington";
    static String state = "DC";
    static String zip = "55305";
    static double lat = 44.969658;
    static double lng = -93.449539;
    static String hours = " Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9";


    @BeforeClass
    public static void endPath() {
        RestAssured.basePath = path.STORE;
    }

    @Steps
    StoreSteps storeSteps;

    @Title("Data driven test for adding multiple Store to the application")
    @Test
    public void createMultipleStore() {

        storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours).statusCode(201);
    }

}


