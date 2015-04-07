package com.chema.jack.wolfdrink;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JACK on 05/04/2015.
 */
public class CCerveza extends ActionBarActivity {

    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
   /* ListViewAdapter adapter;*/
    private List<CDrink> BarList = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.activity_main);
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
       /* @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(CCerveza.this);
            // Set progressdialog title
            mProgressDialog.setTitle("");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }*/

        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            BarList = new ArrayList<CDrink>();
            try {
                // Locate the class table named "Country" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Productos");

                // by ascending
                query.orderByAscending("createdAt");

                ob = query.find();

                for (ParseObject baresito : ob) {
                    CDrink tienda = new CDrink();
                    ParseFile picBar = baresito.getParseFile("Image");

                     tienda.setName((String) baresito.get("name"));
                     tienda.setDescription((String) baresito.get("description"));
                     tienda.setPrecio((String) baresito.get("precio"));


                   tienda.setImage(picBar.getData());

                    BarList.add(tienda);
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }
/*
        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in activity_main.xml
            listview = (ListView) findViewById(R.id.TblData);

            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(CCerveza.this, BarList);

            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
