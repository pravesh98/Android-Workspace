package com.example.admin.sqliteapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id,firstName,lastName,marks;
    Button add,view,update,delete;
    DatabaseHelper databaseHelper;
    EditText editId,editfName,editlName,editMarks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(EditText)findViewById(R.id.id);
        firstName=(EditText)findViewById(R.id.firstName);
        lastName=(EditText)findViewById(R.id.lastName);
        marks=(EditText)findViewById(R.id.marks);
        add=(Button)findViewById(R.id.add);
        view=(Button)findViewById(R.id.viewAll);
        update=(Button)findViewById(R.id.update);
        delete=(Button)findViewById(R.id.delete);
        /*updateData();*/

        editId=(EditText)findViewById(R.id.showDataId);
        editfName=(EditText)findViewById(R.id.showDataFname);
        editlName=(EditText)findViewById(R.id.showDataLname);
        editMarks=(EditText)findViewById(R.id.showDataMarks);


        databaseHelper=new DatabaseHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=databaseHelper.insertData(firstName.getText().toString(),lastName.getText().toString(),marks.getText().toString());
                if(isInserted)
                    Toast.makeText(getApplicationContext(),"Data inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Data not inserted",Toast.LENGTH_SHORT).show();

                updateData();
            }
        });
        updateData();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=databaseHelper.updateData(id.getText().toString(),firstName.getText().toString(),lastName.getText().toString(),marks.getText().toString());
                if(isInserted)
                    Toast.makeText(getApplicationContext(),"Data updated",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Data not updated",Toast.LENGTH_SHORT).show();
                updateData();
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String delete_id=id.getText().toString();
                int d=databaseHelper.deleateData(delete_id);
                Log.v("code",String.valueOf(d));
                Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();
                updateData();
            }
        });

    }

    private void updateData() {
        editId.setText("");
        editMarks.setText("");
        editfName.setText("");
        editlName.setText("");

        Cursor result=databaseHelper.getAllData();
        if(result.getCount()==0)
        {
            Toast.makeText(getApplicationContext(),"Nothing found",Toast.LENGTH_SHORT).show();
        }
        else {
            while (result.moveToNext())
            {
                editId.setText(editId.getText().toString()+"\n"+result.getString(0));
                editfName.setText(editfName.getText().toString()+"\n"+result.getString(1));
                editlName.setText(editlName.getText().toString()+"\n"+result.getString(2));
                editMarks.setText(editMarks.getText().toString()+"\n"+result.getString(3));
            }
/*
                textView.setText(textView.getText()+"\n"+result.getString(0)+" "+result.getString(1)+tab+result.getString(2)+tab+result.getString(3));
*/
        }
    }
}
