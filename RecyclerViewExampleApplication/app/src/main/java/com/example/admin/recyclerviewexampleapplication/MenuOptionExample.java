package com.example.admin.recyclerviewexampleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuOptionExample extends AppCompatActivity {

    TextView textView;
    EditText texxx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_option_example);
        textView=(TextView)findViewById(R.id.txt1);
        texxx=(EditText)findViewById(R.id.ttt);
        CharSequence g=textView.getText();
        CharSequence dd="ss";
        Toast.makeText(getApplicationContext(),dd,Toast.LENGTH_SHORT).show();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),textView.toString(),Toast.LENGTH_LONG).show();
            }
        });

        registerForContextMenu(textView); // for registering the menu associated with the view components.
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        /*super.onCreateContextMenu(menu, v, menuInfo);*/
        switch (v.getId())
        {
            case R.id.male:
                textView.setText("Male");
                break;
            case R.id.female:textView.setText("Female");
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.setting: Toast.makeText(getApplicationContext(),"Setting ",Toast.LENGTH_LONG).show();
                break;
            case R.id.status: Toast.makeText(getApplicationContext(),"Status ",Toast.LENGTH_LONG).show();
                break;
            case R.id.exit: Toast.makeText(getApplicationContext(),"Exit ",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
