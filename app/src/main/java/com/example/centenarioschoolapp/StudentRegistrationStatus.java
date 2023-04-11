package com.example.centenarioschoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

public class StudentRegistrationStatus extends AppCompatActivity {
    TextView nav_registration_status_message;
    // Test: "API return 'Mock Server Error'"
    // Test: "API return 'Student name not existing'"
    String mockStatus = "";
    private ImageView imageViewCheckValidName;

    private EditText searchInput;
    private Button searchButton;
    // private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration_status);

        searchInput = findViewById(R.id.nav_registration_search_name_input);
        searchButton = findViewById(R.id.nav_registration_search_button);
        
        imageViewCheckValidName = findViewById(R.id.imageView_check_valid_name);
        //resultText = findViewById(R.id.result_text);

        if (mockStatus.equals("API return 'Mock Server Error'")) {
            nav_registration_status_message = (TextView) findViewById(R.id.nav_registration_status_message);
            nav_registration_status_message.setText("Server Error...");
        }
        if (mockStatus.equals("API return 'Student name not existing'")) {
            nav_registration_status_message.setText("This Student Not Existing");
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputName = searchInput.getText().toString();
                // Call GET api here - Justin's task

                if (setApiReturnStatus()) {
                    imageViewCheckValidName.setImageResource(R.drawable.yes);
                } else {
                    imageViewCheckValidName.setImageResource(R.drawable.no);
                }
            }
        });
    }

    // Update backend status from here - Freya's task
    public boolean setApiReturnStatus() {
        if(1==1/*Return registration is true*/){
            return true;
        }
        else{
            return false;
        }
    }
}

