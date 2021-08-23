package asu.cis.transportation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class From extends AppCompatActivity {

    private Spinner fromSpinner;
    private Spinner toSpinner;
    private Button btnSearch;

    TextView tvdate ;
    DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.searchBtn);
        tvdate=findViewById(R.id.tvdate);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        From.this, android.R.style.Theme_Holo_Light_Dialog,setListener,year,month,day);
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

        fromSpinner=findViewById(R.id.fromSpinner);
        toSpinner=findViewById(R.id.toSpinner);
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
                this, android.R.layout.simple_spinner_dropdown_item,cities
        );
        fromSpinner.setAdapter(citiesAdapter);
        toSpinner.setAdapter(citiesAdapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(From.this, res.class);
                startActivity(intent);
            }
        });
    }
}