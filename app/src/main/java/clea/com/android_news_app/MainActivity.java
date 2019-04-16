package clea.com.android_news_app;

import android.app.AlertDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import clea.com.android_news_app.Interface.NewsService;
import clea.com.android_news_app.Model.Website;
import clea.com.android_news_app.adapter.ListSourceAdapter;
import dmax.dialog.SpotsDialog;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView listWebsite;
    RecyclerView.LayoutManager layoutManager;
    NewsService mservice;
    AlertDialog alertDialog;
    ListSourceAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        74881819f4a944379382bebf6e8b7f5a

        //for cache
        Paper.init(this);

        //init views
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadWebSiteSource(true);

            }
        });



        listWebsite=(RecyclerView)findViewById(R.id.list_source);
        listWebsite.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        listWebsite.setLayoutManager(layoutManager);


        alertDialog= new SpotsDialog.Builder().setContext(this).build();

        loadWebSiteSource(false);


    }

    private void loadWebSiteSource(boolean isRefreshed) {
        if(!isRefreshed){
            String cache=Paper.book().read("cache");
            if(cache !=null && !cache.isEmpty()){ //if cache is there

                Website website=new Gson().fromJson(cache,Website.class); //convert cache from json to object
                adapter=new ListSourceAdapter(getBaseContext(),website);
                adapter.notifyDataSetChanged();
                listWebsite.setAdapter(adapter);

            }else { //if not have cache
                alertDialog.show();

                //fetch
                mservice.getSources().enqueue(new Callback<Website>() {
                    @Override
                    public void onResponse(Call<Website> call, Response<Website> response) {
                        adapter=new ListSourceAdapter(getBaseContext(),response.body());
                        adapter.notifyDataSetChanged();
                        listWebsite.setAdapter(adapter);


                        //save cache
                        Paper.book().write("cache",new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<Website> call, Throwable t) {

                    }
                });

            }
        }
        else {
            //from swipe to refreshed same copy
            mservice.getSources().enqueue(new Callback<Website>() {
                @Override
                public void onResponse(Call<Website> call, Response<Website> response) {
                    adapter=new ListSourceAdapter(getBaseContext(),response.body());
                    adapter.notifyDataSetChanged();
                    listWebsite.setAdapter(adapter);


                    //save cache
                    Paper.book().write("cache",new Gson().toJson(response.body()));

                    //stop refreshing
                    swipeRefreshLayout.setRefreshing(false);
                }

                @Override
                public void onFailure(Call<Website> call, Throwable t) {

                }
            });


        }

    }
}
