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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
        DatabaseHelper databaseHelper = new DatabaseHelper(Travel.this);
        List<String>Duplicates = databaseHelper.GetAllCities();
        Set<String>removeDuplicates = new LinkedHashSet(Duplicates);
        ArrayList<String> cities = new ArrayList<>(removeDuplicates);
        /*cities.add("Alexandria");
        cities.add("Cairo");
        cities.add("Assiut");
        cities.add("Aswan");
        cities.add("Beheira");
        cities.add("Bani Suef");
        cities.add("Daqahliya");
        cities.add("Giza");
        cities.add("Kafr El Sheikh");
        cities.add("Marsa Matrouh");*/
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

                String date;
                if (month/10 == 0 && day/10 == 0)
                {
                    date = year+"-0"+month +"-0"+day;
                }
                else if (month/10 == 0)
                {
                    date = year+"-0"+month+"-"+day;
                }
                else if (day/10 == 0)
                {
                    date = year+"-"+month+"-0"+day;
                }
                else
                {
                    date = year+"-"+month+"-"+day;
                }
                ChoosedAndNeededData.ChoosedDate = date;
                tvdate.setText(date);
            }
        };
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChoosedAndNeededData.ChoosedFrom = fromSpinner.getSelectedItem().toString();
                ChoosedAndNeededData.ChoosedTo = toSpinner.getSelectedItem().toString();
                Intent intent = new Intent(Travel.this, ResultOfSearch.class);
                startActivity(intent);
            }
        });
    }
}