package com.codewithishita.letsgrowmore_task1;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    public static List<Model> modelList = new ArrayList<>();
    Model model;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        fetchData();

    }

    private void fetchData() {
        // The Link Through Which We Can Fetch Data
        String url = "https://api.covid19india.org/state_district_wise.json";

        StringRequest req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    // Creating JSON Object
                    JSONObject object = new JSONObject(response);
                    Iterator<String> keys=object.keys();

                    while(keys.hasNext()){
                        String key=keys.next();
                        JSONObject obj1 = object.getJSONObject(key);
                        JSONObject obj2 = obj1.getJSONObject("districtData");
                        Iterator<String> subkeys=obj2.keys();

                        while(subkeys.hasNext()){
                            String subkey=subkeys.next();
                            JSONObject obj3 = obj2.getJSONObject(subkey);
                            JSONObject obj4 = obj3.getJSONObject("delta");

                            String active = obj3.getString("active");
                            String confirmed = obj3.getString("confirmed");
                            String deceased = obj3.getString("deceased");
                            String recovered = obj3.getString("recovered");

                            String confInc = obj4.getString("confirmed");
                            String confDec = obj4.getString("deceased");
                            String confRec = obj4.getString("recovered");

                            model = new Model(subkey, deceased, recovered, active,confirmed,
                                    confInc, confDec, confRec);
                            // placing data into the app using AdapterClass
                            modelList.add(model);
                        }
                    }

                    adapter = new Adapter(MainActivity.this, modelList);
                    listView.setAdapter(adapter);



                    // In case of error it will run
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // In case of error it will run
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue reqQueue = Volley.newRequestQueue(this);
        reqQueue.add(req);
    }
}
