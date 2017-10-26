package com.example.admin.recyclerviewexampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String string1[],string2[];
    int imgId[]={R.drawable.cat,R.drawable.cow,R.drawable.dog,R.drawable.elephant,R.drawable.parrot,R.drawable.snake};
    MyOwnAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recycle);
        string1=getResources().getStringArray(R.array.pet_name);
        string2=getResources().getStringArray(R.array.description);
        adapter=new MyOwnAdapter(getApplicationContext(),string1,string2,imgId);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        }

        public void dooo(View v)
        {
            Intent intent=new Intent(MainActivity.this,MenuOptionExample.class);
            startActivity(intent);
        }
}
