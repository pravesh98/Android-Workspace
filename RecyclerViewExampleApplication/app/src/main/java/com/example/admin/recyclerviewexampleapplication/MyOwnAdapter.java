package com.example.admin.recyclerviewexampleapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 10/13/2017.
 */

public class MyOwnAdapter extends RecyclerView.Adapter<MyOwnAdapter.MyOwnHolder> {

    String data1[],data2[];
    int img[];
    Context context;

    MyOwnAdapter(Context context,String string1[],String string2[],int ids[])
    {
        this.context=context;
        data1=string1;
        data2=string2;
        img=ids;
    }

    @Override
    public MyOwnAdapter.MyOwnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.my_row,parent,false);
        return new MyOwnHolder(view);
    }

    @Override
    public void onBindViewHolder(MyOwnAdapter.MyOwnHolder holder, int position) {
        holder.textView1.setText(data1[position]);
        holder.textView2.setText(data2[position]);
        holder.imageView.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyOwnHolder extends RecyclerView.ViewHolder {

        TextView textView1,textView2;
        ImageView imageView;

        public MyOwnHolder(View itemView) {
            super(itemView);
            textView1=(TextView)itemView.findViewById(R.id.textView);
            textView2=(TextView)itemView.findViewById(R.id.textView2);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}
