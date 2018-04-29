package id.tmdbapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import id.tmdbapps.REST.ApiClient;
import id.tmdbapps.REST.ApiInterface;
import id.tmdbapps.adapter.RecyclerAdapter;
import id.tmdbapps.model.Movie;
import id.tmdbapps.model.MovieResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private MovieResponse movieResponse;

    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvList);
        movieList = new ArrayList<>();
//        movieList.add(new Movie("Avengers: Infinity War", "koko", "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiService.getPopular("16ca32f03b6943a2e4c893b7ea87276b");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movieResponse = response.body();
                Log.d(TAG, "onResponse: "+response.body().getMovieList());
                movieList = movieResponse.getMovieList();
                adapter = new RecyclerAdapter(getApplicationContext(), movieList);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));
                recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(), LinearLayoutManager.VERTICAL));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: ",t);
            }
        });

    }
}
