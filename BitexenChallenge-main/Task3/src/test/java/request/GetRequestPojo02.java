package request;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;

public class GetRequestPojo02 extends JsonPlaceHolderBaseUrl {

    // https://jsonplaceholder.typicode.com/todos/1
    /*
    {
    "userId": 1,
    "id": 1,
    "title": "delectus aut autem",
    "completed": false
    }
    */

    @Test
    public void test01(){

        spec01.pathParams("param1","todos","param2","1");

        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(1,1,"delectus aut autem",false);

        Response response = given().contentType(ContentType.JSON)
                .spec(spec01)
                .when()
                .get("/{param1}/{param2}");

        response.prettyPrint();

        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getUserId(),actualData.getUserId());
        Assert.assertEquals(expectedData.getId(),actualData.getId());
        Assert.assertEquals(expectedData.getTitle(),actualData.getTitle());
        Assert.assertEquals(expectedData.isCompleted(),actualData.isCompleted());

    }
}
