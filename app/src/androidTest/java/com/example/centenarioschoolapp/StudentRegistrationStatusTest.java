package com.example.centenarioschoolapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;

public class StudentRegistrationStatusTest {
    private OkHttpClient httpClient;

    @Before
    public void setUp() {
        httpClient = new OkHttpClient();
    }

    // Frontend: App render properly
    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.centenarioschoolapp", appContext.getPackageName());
    }

    // Backend: Student registration GET api return values
    @Test
    public void testGetStudentRegistrationStatusReturnTrue() throws IOException {
        String apiUrl = "mongodb+srv://zannatulsakina: gAQEnlXLX8ejm3Rm>@team6centenario.0vezpan.mongodb.net/?retryWrites=true&w=majority";

        Request request = new Request.Builder()
                .url(apiUrl + "?name=Alice")
                .build();

        // Send GET requrest to MongoDB Atlas
        Response response = httpClient.newCall(request).execute();

        // Check the response is not null
        assertNotNull(response);

        // Check the response status is 200
        assertEquals(200, response.code());

        // Get the response data string
        String responseBody = response.body().string();

        // Check the response data string is not null
        assertNotNull(responseBody);

        // Extract the registration status and check it's true for 'Alice'
        assertTrue(responseBody.contains("\"registration\": true"));
    }

    @Test
    public void testGetStudentRegistrationStatusReturnFalse() throws IOException {

        String apiUrl = "mongodb+srv://zannatulsakina: gAQEnlXLX8ejm3Rm>@team6centenario.0vezpan.mongodb.net/?retryWrites=true&w=majority";

        Request request = new Request.Builder()
                .url(apiUrl + "?name=Mary Jane")
                .build();

        Response response = httpClient.newCall(request).execute();
        assertNotNull(response);
        assertEquals(200, response.code());
        String responseBody = response.body().string();
        assertNotNull(responseBody);
        assertTrue(responseBody.contains("\"registration\": false"));
    }

    @Test
    public void testGetStudentRegistrationStatusReturnNull() throws IOException {
        String apiUrl = "mongodb+srv://zannatulsakina: gAQEnlXLX8ejm3Rm>@team6centenario.0vezpan.mongodb.net/?retryWrites=true&w=majority";
        Request request = new Request.Builder()
                .url(apiUrl + "?name=Null")
                .build();
        Response response = httpClient.newCall(request).execute();
        assertNotNull(response);
        assertEquals(200, response.code());
        String responseBody = response.body().string();
        assertNull(responseBody);
    }

    @Test
    public void testGetStudentRegistrationStatusReturn500() throws IOException {
        String apiUrl = "mongodb+srv://zannatulsakina: gAQEnlXLX8ejm3Rm>@team6centenario.0vezpan.mongodb.net/?retryWrites=true&w=majority";
        Request request = new Request.Builder()
                .url(apiUrl + "?birthday=2023.04.16")
                .build();
        Response response = httpClient.newCall(request).execute();
        assertNotNull(response);
        assertEquals(500, response.code());
    }
}
