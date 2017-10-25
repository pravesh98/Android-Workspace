package com.example.admin.asynctaskexmple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyProgressTask myProgressTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomething(View v)
    {
       myProgressTask=new MyProgressTask(MainActivity.this);
        myProgressTask.execute();
    }
}
