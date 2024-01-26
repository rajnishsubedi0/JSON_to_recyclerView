package com.example.rrreeecyckervuew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<DataHolder> arrayList, arraylist_from_json;

    String url = "https://jsonkeeper.com/b/OYSV";
    String url2="https://api.agify.io?name=meelad";
    String url3="https://mocki.io/v1/8913cc0e-dcec-4e0a-bc52-ddc2c34f85be";
    String url_mocky="https://mocki.io/v1/70ea3f8a-0f8a-4742-a08f-9b2267973303";
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterclass recyclerAdapterclass;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerViewId);
        arrayList=new ArrayList<>();
        addData();
        loadVolleyData();
        recyclerAdapterclass=new RecyclerAdapterclass(arrayList);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapterclass);
    }

    private void loadVolleyData(){
        RequestQueue queue=Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url_mocky, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                    try {
                        JSONArray array=response.getJSONArray("employees");
                        for (int i=0; i<array.length();i++){
                            JSONObject object=array.getJSONObject(i);
                            String name=object.getString("firstname");
                            arrayList.add(new DataHolder(name));
                            Toast.makeText(MainActivity.this, ""+name, Toast.LENGTH_SHORT).show();
                            recyclerAdapterclass.notifyDataSetChanged();
                        }
                        Toast.makeText(MainActivity.this, "Succeed", Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        throw new RuntimeException(e);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
        //recyclerAdapterclass.notifyDataSetChanged();

}




    private void addData() {
        arrayList.add(new DataHolder("Hari"));
        arrayList.add(new DataHolder("Hari"));
        arrayList.add(new DataHolder("Hari"));
        arrayList.add(new DataHolder("Hari"));
        arrayList.add(new DataHolder("Hari"));
        arrayList.add(new DataHolder("Hari"));
        arrayList.add(new DataHolder("Hari"));
        arrayList.add(new DataHolder("Hari"));
    }
}