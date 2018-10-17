package com.example.hp.androidchallenge.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.hp.androidchallenge.Adapter.RepoRecyclerAdapter;
import com.example.hp.androidchallenge.R;
import com.example.hp.androidchallenge.Model.RepoDataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //Create the base URL
    private  String github_endpoint = "https://api.github.com/search/repositories?q=created:>2018-08-29&sort=stars&order=desc";
    private RequestQueue q;
    private RecyclerView recyclerView;
    private RepoRecyclerAdapter recyclerAdapter;
    private List<RepoDataModel> repos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        q= Volley.newRequestQueue(this);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        repos=new ArrayList<>();
       fetchGithubEndPoint(github_endpoint);
       Log.d("taille",""+repos.size());




    }





    public void fetchGithubEndPoint(String url)
    {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Log.d("data",response.toString());

                        try {
                            JSONArray items=response.getJSONArray("items");
                            for(int i=0;i<items.length();i++)
                            {
                                RepoDataModel repo=new RepoDataModel();

                                JSONObject object=items.getJSONObject(i);
                                JSONObject owner=object.getJSONObject("owner");

                                repo.setRepo_name(object.getString("name"));
                                repo.setRepo_description(object.getString("description"));
                                repo.setOwner_name(owner.getString("login"));
                                repo.setAvatar(owner.getString("avatar_url"));
                                repo.setNumber_of_stars(object.getInt("stargazers_count"));

                                repos.add(repo);

                            }
                            recyclerAdapter=new RepoRecyclerAdapter(getApplicationContext(),repos);
                            recyclerView.setAdapter(recyclerAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        q.add(jsonObjectRequest);

    }




    }

