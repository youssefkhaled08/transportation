package asu.cis.transportation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {
    private CardView busCard;
    private CardView trainCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        busCard = findViewById(R.id.busCard);
        trainCard = findViewById(R.id.trainCard);

        busCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChoosedAndNeededData.TypeOfTravel = "Bus";
                Intent intent = new Intent(Dashboard.this, Travel.class);
                startActivity(intent);
            }
        });

        trainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChoosedAndNeededData.TypeOfTravel = "Train";
                Intent intent = new Intent(Dashboard.this, Travel.class);
                startActivity(intent);
            }
        });
    }
}