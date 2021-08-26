package asu.cis.transportation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tickets extends AppCompatActivity {
    private Button btnPlus;
    private Button btnMinus;
    private Button btnSubmit;
    private TextView txtFrom;
    private TextView txtTo;
    private TextView txtCounter;
    private TextView txtPrice;
    private Dialog paymentPopup;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        btnPlus = findViewById(R.id.btnIncreaseTickets);
        btnMinus = findViewById(R.id.btnDecreaseTickets);
        btnSubmit = findViewById(R.id.btnSubmitTicket);

        txtCounter = findViewById(R.id.numOfTickets);
        txtPrice = findViewById(R.id.ticketsPrice);
        txtFrom = findViewById(R.id.ticketsFrom);
        txtTo = findViewById(R.id.ticketsTo);
        txtFrom.setText(ChoosedAndNeededData.ChoosedTravelModel.getFrom());
        txtTo.setText(ChoosedAndNeededData.ChoosedTravelModel.getTo());
        paymentPopup = new Dialog(Tickets.this);
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

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(Tickets.this);
                databaseHelper.TravelUpdateRowAvailableSeat(ChoosedAndNeededData.ChoosedTravelModel.getDate() , ChoosedAndNeededData.ChoosedTravelModel.getFrom() , ChoosedAndNeededData.ChoosedTravelModel.getTo() , ChoosedAndNeededData.ChoosedTravelModel.getStart() , ChoosedAndNeededData.ChoosedTravelModel.getEnd() , ChoosedAndNeededData.ChoosedTravelModel.getAvailableSeats()-counter);
                paymentPopup.setContentView(R.layout.popup);
                paymentPopup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                paymentPopup.show();
            }
        });
    }
}