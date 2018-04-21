package com.example.baovy.ex2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Spinner spinnerFrom, spinnerTo;
    EditText amount;
    TextView result;

    String arr[]={"USD", "VND", "EUR"};

    private final double VND2USD = 0.00004;
    private final double USD2VND = 22774.9;
    private final double VND2EUR = 0.00004;
    private final double EUR2VND = 27991.5;
    private final double EUR2USD = 1.22905;
    private final double USD2EUR = 0.81364;

    private final char EUROSYM = '\u20AC';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        ArrayAdapter<String> adapterFrom= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);
        adapterFrom.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerFrom.setAdapter(adapterFrom);
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, spinnerFrom.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        ArrayAdapter<String> adapterTo= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);
        adapterTo.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerTo.setAdapter(adapterTo);
        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, spinnerTo.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        amount = (EditText) findViewById(R.id.amount);
        result = (TextView) findViewById(R.id.result);

        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    if (spinnerFrom.getSelectedItem().toString() == "VND" && spinnerTo.getSelectedItem().toString() == "USD") {
                        result.setText(String.format("%.2f", Double.parseDouble(amount.getText().toString()) * VND2USD));
                    } else if (spinnerFrom.getSelectedItem().toString() == "USD" && spinnerTo.getSelectedItem().toString() == "VND") {
                        result.setText(String.format("%.2f", Double.parseDouble(amount.getText().toString()) * USD2VND));
                    } else if (spinnerFrom.getSelectedItem().toString() == "VND" && spinnerTo.getSelectedItem().toString() == "EUR") {
                        result.setText(String.format("%.2f", Double.parseDouble(amount.getText().toString()) * VND2EUR));
                    } else if (spinnerFrom.getSelectedItem().toString() == "EUR" && spinnerTo.getSelectedItem().toString() == "VND") {
                        result.setText(String.format("%.2f", Double.parseDouble(amount.getText().toString()) * EUR2VND));
                    } else if (spinnerFrom.getSelectedItem().toString() == "USD" && spinnerTo.getSelectedItem().toString() == "EUR") {
                        result.setText(String.format("%.2f", Double.parseDouble(amount.getText().toString()) * USD2EUR));
                    } else {
                        result.setText(String.format("%.2f", Double.parseDouble(amount.getText().toString()) * EUR2USD));
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
