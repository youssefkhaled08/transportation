package asu.cis.transportation;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TicketsReservation extends AppCompatActivity {
    private TextView countertext;
    private Button plusbutton;
    private Button minusbutton;
    private Button resetbtn;
    private int counter;
    private TextView price;

    private View.OnClickListener clickListener = new View.OnClickListener(){
        public void onClick(View view){
            switch (view.getId()){
                case R.id.button:
                    minuscount();
                    incrmantprice();
                    break;
                case R.id.button2:
                    pluscount();
                    incrmantprice();
                    break;
                case R.id.btnTrain:
                    initcounter();
                    price.setText(0+ "");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_reservation);
        countertext = (TextView) findViewById(R.id.textView2);
        minusbutton = (Button) findViewById(R.id.button);
        minusbutton.setOnClickListener(clickListener);
        plusbutton = (Button) findViewById(R.id.button2);
        plusbutton.setOnClickListener(clickListener);
        resetbtn = (Button) findViewById(R.id.btnTrain);
        resetbtn.setOnClickListener(clickListener);
        price = (TextView) findViewById(R.id.textView13);

    }
    private  void initcounter(){
        counter=0;
        countertext.setText(counter + "");
    }
    private void pluscount(){
        counter++;
        countertext.setText(counter + "");
    }
    private void minuscount(){
        counter--;
        countertext.setText(counter + "");
    }
    private void incrmantprice(){
        price.setText(counter * 100 + "");
    }

}