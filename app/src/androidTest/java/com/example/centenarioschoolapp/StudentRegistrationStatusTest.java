package com.example.centenarioschoolapp;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import com.example.centenarioschoolapp.StudentRegistrationStatus;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class StudentRegistrationStatusTest {

    @Test
    public void useAppContext() {
        // Test case 1 frontend: Test if the whole app render successfully
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.centenarioschoolapp", appContext.getPackageName());

        // Test case 2 frontend: Test render if the return student registration is true

        /*
        ON HOLD FOR　API

        boolean mockAPIReturnStatus = true;
        BackendService mockBackendService = mock(BackendService.class);
        when(mockBackendService.getBooleanValue()).thenReturn(backendValue);

        StudentRegistrationStatus testPage = new StudentRegistrationStatus(mockBackendService);
        boolean result = testPage.setApiReturnStatus();

        assertEquals(true, result);
         */

        // Test case 3 Test render if the return data student registration is false

        /*
        ON HOLD FOR　API

        boolean mockAPIReturnStatus = false;
        BackendService mockBackendService = mock(BackendService.class);
        when(mockBackendService.getBooleanValue()).thenReturn(backendValue);

        StudentRegistrationStatus testPage = new StudentRegistrationStatus(mockBackendService);
        boolean result = testPage.setApiReturnStatus();

        assertEquals(false, result);*/
    }
}