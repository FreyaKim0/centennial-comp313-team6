package com.example.centenarioschoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class StudentRegistrationStatus extends AppCompatActivity {
    TextView nav_registration_status_message;
    // Test: "API return 'Mock Server Error'"
    // Test: "API return 'Student name not existing'"
    String mockStatus="";
    private EditText searchInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration_status);

        searchInput = findViewById(R.id.search_input);
        Button searchButton = findViewById(R.id.search_button);
        resultText = findViewById(R.id.result_text);

        if (mockStatus.equals("API return 'Mock Server Error'"))
        {
          nav_registration_status_message=(TextView)findViewById(R.id.nav_registration_status_message);
          nav_registration_status_message.setText("Server Error...");
        }
        if (mockStatus.equals("API return 'Student name not existing'"))
        {
          nav_registration_status_message.setText("This Student Not Existing");
        }



        Button searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = searchInput.getText().toString();
                sendRequestToServer(input);
            }

        });
    
    }

    public String setMockStatus(String status) {
        String mockStatus = status;
        return status;
    }


        private void sendRequestToServer(String input) {
            String url = "https://yourserver.com/search";
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, getRequestBody(input),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String registrationNumber = response.getString("registrationNumber");
                                boolean isRegistered = response.getBoolean("isRegistered");
                                String registrationDate = response.getString("registrationDate");

                                String result = "Registration Number: " + registrationNumber + "\n" +
                                        "Is Registered: " + isRegistered + "\n" +
                                        "Registration Date: " + registrationDate;

                                resultText.setText(result);
                                resultText.setVisibility(View.VISIBLE);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Error", "Error Occurred: " + error.getMessage());
                        }
                    });
            Volley.newRequestQueue(this).add(request);
        }
        private JSONObject getRequestBody(String input) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("registrationNumber", input);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject;
        }


}

