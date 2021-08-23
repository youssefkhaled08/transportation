package asu.cis.transportation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseTrainOrBus extends AppCompatActivity {
    Button btnBus , btnTrain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_train_or_bus);
        btnBus = findViewById(R.id.btnBus);
        btnTrain = findViewById(R.id.btnTrain);

        btnBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseTrainOrBus.this , ChooseTravelFromTo.class);
                startActivity(intent);
            }
        });
        btnTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseTrainOrBus.this , ChooseTravelFromTo.class);
                startActivity(intent);

            }
        });
    }
}