package com.example.centenarioschoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StudentRegistrationStatus extends AppCompatActivity {
    TextView nav_registration_status_message;
    // Test: "API return 'Mock Server Error'"
    // Test: "API return 'Student name not existing'"
    String mockStatus="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration_status);
       if(mockStatus=="API return 'Mock Server Error'")
        {
          nav_registration_status_message=(TextView)findViewById(R.id.nav_registration_status_message);
          nav_registration_status_message.setText("Server Error...");
        }
        if(mockStatus=="API return 'Student name not existing'")
        {
          nav_registration_status_message.setText("This Student Not Existing");
        }
    }
}