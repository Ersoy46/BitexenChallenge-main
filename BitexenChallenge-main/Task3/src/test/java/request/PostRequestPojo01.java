package request;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;

public class PostRequestPojo01 extends JsonPlaceHolderBaseUrl {

    /*
    Request body{
    "userId": 21,
    "id": 201,
    "title": "Tidy your room",
    "completed": false
    }
    */

    @Test
    public void test01(){

        spec01.pathParams("first","todos");

        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(21,201,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        Response response = given().contentType(ContentType.JSON)
                .spec(spec01)
                .body(expectedData)
                .when()
                .post("/{first}");
        response.prettyPrint();


        // DE-Serialization
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
        // StatusCode 201 döndüğü için 201 assert edildi
        // -istek başarılı-
        Assert.assertEquals(201,response.getStatusCode());
        Assert.assertEquals(expectedData.getId(),actualData.getId());
        Assert.assertEquals(expectedData.getUserId(),actualData.getUserId());
        Assert.assertEquals(expectedData.getTitle(),actualData.getTitle());
        Assert.assertEquals(expectedData.isCompleted(),actualData.isCompleted());


    }

}
