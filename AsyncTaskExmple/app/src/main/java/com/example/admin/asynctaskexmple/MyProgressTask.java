package com.example.admin.asynctaskexmple;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.Toast;
/**
 * Created by Admin on 10/25/2017.
 */

public class MyProgressTask extends AsyncTask<Void,Integer,String> {

    Context context;
    ProgressDialog progressDialog;

    public MyProgressTask(Context context)
    {
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Downloading");
        progressDialog.setMessage("Please wait...");
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                cancel(true);
            }
        });
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            for (int i=0;i<10;i++)
            {
                Thread.sleep(1000);
                publishProgress(i*10);
            }
            return "successfully completed";
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        progressDialog.dismiss();
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int myValue=values[0];
        progressDialog.setProgress(myValue);
    }
}
