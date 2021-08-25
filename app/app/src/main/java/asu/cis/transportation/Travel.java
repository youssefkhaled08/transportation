package asu.cis.transportation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Travel extends AppCompatActivity {

    private Button btnSearch;
    private Spinner fromSpinner;
    private Spinner toSpinner;
    private TextView tvdate;
    private DatePickerDialog.OnDateSetListener setListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        btnSearch = findViewById(R.id.btnSearch);
        fromSpinner = findViewById(R.id.spinnerFrom);
        toSpinner = findViewById(R.id.spinnerTo);

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Alexandria");
        cities.add("Cairo");
        cities.add("Assiut");
        cities.add("Aswan");
        cities.add("Beheira");
        cities.add("Bani Suef");
        cities.add("Daqahliya");
        cities.add("Giza");
        cities.add("Kafr El Sheikh");
        cities.add("Marsa Matrouh");
        ArrayAdapter<String> citiesAdapter= new ArrayAdapter<>(
                this, R.layout.dropdown_item,cities
        );
        citiesAdapter.setDropDownViewResource(R.layout.spinner_dropdown_view);

        fromSpinner.setAdapter(citiesAdapter);

        toSpinner.setAdapter(citiesAdapter);

        tvdate=findViewById(R.id.travelDate);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Travel.this, android.R.style.Theme_Holo_Light_Dialog,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month+1;
                String date = day +"/"+month+"/"+year;
                tvdate.setText(date);
            }
        };
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Travel.this, ResultOfSearch.class);
                startActivity(intent);
            }
        });
    }
}