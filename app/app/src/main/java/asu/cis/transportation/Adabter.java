package asu.cis.transportation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adabter extends RecyclerView.Adapter <Adabter.MyviewHolder>{
    String fromdata[],todata[],timeoutdata[],arrivetimedata[];
    int icon;
    Context context;
    public Adabter(Context ct,String from[],String to[],String timeout[],String arrivetime[],int img)
    {
        context=ct;
        fromdata=from;
        todata=to;
        timeoutdata=timeout;
        arrivetimedata=arrivetime;
        icon=img;

    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.eachtravel,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.from.setText(fromdata[position]);
        holder.to.setText(todata[position]);
        holder.timeout.setText(timeoutdata[position]);
        holder.timein.setText(arrivetimedata[position]);
        holder.icom.setImageResource(icon);

    }

    @Override
    public int getItemCount() {
        return fromdata.length;
    }

    public class MyviewHolder extends  RecyclerView.ViewHolder {
        TextView from,to,timeout,timein;
        ImageView icom;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            from= itemView.findViewById(R.id.from);
            to= itemView.findViewById(R.id.to);
            timeout= itemView.findViewById(R.id.timeout);
            timein= itemView.findViewById(R.id.arrivetime);
        }
    }
}