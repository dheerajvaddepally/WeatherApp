package com.dheeraj.weatherapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    TextInputEditText cityName;
    Button mButton;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mButton.setOnClickListener(view -> {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(cityName.getWindowToken(), 0);
            doGetRequest();
        });
    }

    private void initViews() {
        cityName = findViewById(R.id.edit_text);
        mButton = findViewById(R.id.button1);
        mTextView = findViewById(R.id.weather_reponse_text);
    }

    private void doGetRequest() {
        Uri.Builder builder = new Uri.Builder();
        //https://api.openweathermap.org/data/2.5/weather?q=cityName"
        builder.scheme("https")
                .authority("api.openweathermap.org")
                .appendPath("data")
                .appendPath("2.5")
                .appendPath("weather")
                .appendQueryParameter("q", cityName.getText().toString())
                .appendQueryParameter("appid", "722ceb9af7936ce9bfa1a740af16e659");

        String url = builder.build().toString();

        MyRequestQueue.requestQueue(this).add(new StringRequest(url, this::onSuccess, this::onError));

    }

    private void onError(VolleyError volleyError) {
        Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
    }

    private void onSuccess(String s) {
        Log.i("response", s);
        Gson gson = new Gson();
        WeatherResponse weatherResponse = gson.fromJson(s, WeatherResponse.class);
        if(weatherResponse.getWeather().get(0).getMain() != null) {
            mTextView.setText(weatherResponse.getWeather().get(0).getMain());
        }
    }

}
