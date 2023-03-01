package com.federicocotogno.currencyconversionapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class tConv extends Activity {
    EditText text;
    RadioGroup rgg;
    RadioButton celsiusButton, fahrenheitButton;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempconv);
        text=findViewById(R.id.inputTemp);
        celsiusButton=findViewById(R.id.rb1);
        fahrenheitButton=findViewById(R.id.rb2);
        tv=findViewById(R.id.result);

        rgg = findViewById(R.id.rg);
        rgg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                String s= text.getText().toString();
                Float temp = Float.parseFloat(s);
                Float x=0.0f;
                switch (checkedId){
                    case R.id.rb1:
                        x=convertFahrenheitToCelsius(temp);
                        break;
                    case R.id.rb2:
                        x=convertCelsiusToFahrenheit(temp);
                        break;
                }
                String str=String.valueOf(x);
                tv.setText("Result:"+str);
            }
        });

        Button btnBack = (Button) findViewById(R.id.btn2);

        // view products click event
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching All products Activity
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });



    }

    public void onClick(View view){
        String s= text.getText().toString();
        Float temp = Float.parseFloat(s);
        Float x;
        switch (view.getId()){
            case R.id.button1:
                if(celsiusButton.isChecked())
                    x=convertFahrenheitToCelsius(temp);
                else
                    x=convertCelsiusToFahrenheit(temp);
                String str=String.valueOf(x);
                tv.setText("Result:"+str);
                break;
        }

    }

    public static float convertFahrenheitToCelsius(float fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    // converts to fahrenheit
    public static float convertCelsiusToFahrenheit(float celsius) {
        return ((celsius * 9) / 5) + 32;
    }
}
