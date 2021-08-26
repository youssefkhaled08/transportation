package asu.cis.transportation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultOfSearch extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_search);
        listView = findViewById(R.id.listview);
        // accsses data
        DatabaseHelper databaseHelper = new DatabaseHelper(ResultOfSearch.this);
        ChoosedAndNeededData.RequiredTravelModels = databaseHelper.GetTravelsFromToAtDate(ChoosedAndNeededData.ChoosedDate , ChoosedAndNeededData.ChoosedFrom ,ChoosedAndNeededData.ChoosedTo);
        ArrayList<TravelsModel> arrayList = (ArrayList<TravelsModel>)ChoosedAndNeededData.RequiredTravelModels;
        /*arrayList.add(new TravelsModel("Cairo","Alex","13/4/2021","12:30AM","2:00PM",100.00f,5));
        arrayList.add(new TravelsModel("Cairo","Alex","13/4/2021","1:30AM","3:00PM",100.00f,4));
        arrayList.add(new TravelsModel("Cairo","Alex","13/4/2021","8:30AM","6:00PM",100.00f,3));
        arrayList.add(new TravelsModel("Cairo","Alex","13/4/2021","12:30AM","2:00PM",100.00f,1));*/

        //make adapter
        traveladapter traveladapter=new traveladapter(this,R.layout.travelrow,arrayList);
        listView.setAdapter(traveladapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ChoosedAndNeededData.ChoosedTravelModel =(TravelsModel) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ResultOfSearch.this, Tickets.class);
                startActivity(intent);
            }
        });

    }
}