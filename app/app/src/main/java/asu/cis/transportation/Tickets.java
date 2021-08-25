package asu.cis.transportation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tickets extends AppCompatActivity {
    private Button btnPlus;
    private Button btnMinus;
    private Button btnSubmit;
    private TextView txtCounter;
    private TextView txtPrice;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        btnPlus = findViewById(R.id.btnIncreaseTickets);
        btnMinus = findViewById(R.id.btnDecreaseTickets);
        btnSubmit = findViewById(R.id.btnSubmit);

        txtCounter = findViewById(R.id.numOfTickets);
        txtPrice = findViewById(R.id.ticketsPrice);

        txtCounter.setText(0 + "");
        txtPrice.setText(0 + "");
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                txtCounter.setText(counter + "");
                txtPrice.setText(counter * 100 + "");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                txtCounter.setText(counter + "");
                txtPrice.setText(counter * 100 + "");
            }
        });
    }
}