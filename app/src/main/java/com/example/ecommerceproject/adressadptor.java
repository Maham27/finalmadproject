package com.example.ecommerceproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adressadptor  extends RecyclerView.Adapter<adressadptor.Viewholder>

{
    List<adressdata> d;
    private Context context;
    clickedadess c;
    private  RadioButton clicked
    public  interface clickedadess{
        void setAddress(String address)
    }
    public adressadptor(Context context,List<adressdata>  d,clickedadess c) {
        this.d=d;
        this.context=context;
        this.c=c;

    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView tadressadd;
        RadioButton clickaddress;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tadressadd=itemView.findViewById(R.id.tadressadd);
            clickaddress=itemView.findViewById(R.id.clickaddress
            )
        }
    }



    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=(LayoutInflater.from(parent.getContext()).inflate(R.layout.addressitem_layout,parent, false));
        return new itemsadaptor.ViewHolder(v)
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.tadressadd.setText(d.get(position).getAddress());
        holder.clickaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (adressdata a:d) {
                    a.setClickaddress(false);
                }
                d.get(position).setClickaddress(true);
                if (clicked!=null)
                {
                    clicked.setChecked(false);
                }
                clicked=(RadioButton) v;
                clicked.setChecked(true) v;
                c.setAddress(d.get(position).getAddress());


            }
        });


    }

    @Override
    public int getItemCount() {
        return d.size();
    }


}
