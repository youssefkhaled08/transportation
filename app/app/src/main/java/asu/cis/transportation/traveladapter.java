package asu.cis.transportation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class traveladapter extends ArrayAdapter<TravelsModel> {
    private Context context;
    private int mRes;
    public traveladapter(@NonNull Context context, int resource, @NonNull ArrayList<TravelsModel> objects) {
        super(context, resource, objects);
        this.context=context;
        this.mRes=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(mRes,parent,false);
        TextView txtfrom=convertView.findViewById(R.id.textfrom);
        TextView txtto=convertView.findViewById(R.id.textto);
        TextView txtdate=convertView.findViewById(R.id.textdate);
        TextView txttimeout=convertView.findViewById(R.id.txttimeout);
        TextView txtarrive=convertView.findViewById(R.id.textarrive);
        TextView txtprice=convertView.findViewById(R.id.textprice);
        TextView txtseats=convertView.findViewById(R.id.textseats);
        TextView from=convertView.findViewById(R.id.from);
        TextView to=convertView.findViewById(R.id.to);
        TextView date=convertView.findViewById(R.id.date);
        TextView timeout=convertView.findViewById(R.id.timeout);
        TextView arrive=convertView.findViewById(R.id.arrive);
        TextView price=convertView.findViewById(R.id.price);
        TextView seats=convertView.findViewById(R.id.seats);


        from.setText(getItem(position).getFrom());
        to.setText(getItem(position).getTo());
        date.setText(getItem(position).getDate());
        timeout.setText(getItem(position).getStart());
        arrive.setText(getItem(position).getEnd());
        price.setText(Float.toString(getItem(position).getPrice()));
        seats.setText(Integer.toString(getItem(position).getAvailableSeats()));

        return convertView;
    }
}
