package com.example.brom.listviewjsonapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class MainActivity extends AppCompatActivity {

    private ArrayList<Kost> kostArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new FetchData().execute();
        final ArrayAdapter<Kost> adapter = new ArrayAdapter(getApplicationContext(), R.layout.my_item_textview, R.id.my_list, kostArrayList);
        ListView myListView = (ListView)findViewById(R.id.my_list);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), Kostinfo.class);
                Kost k = adapter.getItem(position);
                intent.putExtra("name", k.getKostName());
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_refresh) {

            new FetchData() .execute();
            kostArrayList.clear();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private class FetchData extends AsyncTask<Void,Void,String>{
        @Override
        protected String doInBackground(Void... params) {
            // These two variables need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a Java string.
            String jsonStr = null;

            try {
                // Construct the URL for the Internet service
                URL url = new URL("http://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=g18marma");

                // Create the request to the PHP-service, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                jsonStr = buffer.toString();
                return jsonStr;
            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in
                // attempting to parse it.
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("Network error", "Error closing stream", e);
                    }
                }
            }
        }
        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);

            try {

                JSONArray json1 = new JSONArray(o);

                for(int i = 0; i<json1.length(); i++){
                    JSONObject mountains = json1.getJSONObject(i);
                    String kostName = mountains.getString("name");
                    String kostType = mountains.getString("location");
                    String kostCompany = mountains.getString("company");
                     int kostPrice = mountains.getInt("category");
                     int kostSize = mountains.getInt("cost");
                     int kostScoop = mountains.getInt("size");

                    kostArrayList.add(new Kost(kostName, kostType, kostCompany, kostSize, kostPrice, kostScoop));

                }

            } catch (JSONException e) {
                Log.e("brom","E:"+e.getMessage());
            }
            final ArrayAdapter<Kost> adapter=new ArrayAdapter<Kost>(MainActivity.this, R.layout.my_item_textview, R.id.list_item_textview,kostArrayList);
            ListView myListView = (ListView)findViewById(R.id.my_list);
            myListView.setAdapter(adapter);


            myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(), kostArrayList.get(position).info(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Kostinfo.class);
                    Kost k = adapter.getItem(position);
                    intent.putExtra("name", k.getKostName());
                    intent.putExtra("type", k.getKostType());
                    intent.putExtra("company", k.getKostCompany());
                    intent.putExtra("price", k.getKostPrice());
                    intent.putExtra("size", k.getKostSize());
                    intent.putExtra("scoop", k.getKostScoop());
                    startActivity(intent);
                }
            });
    }
}
}

