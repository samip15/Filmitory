package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.movieapp.Data.MoviePrefrences;
import com.example.movieapp.Model.Movie;
import com.example.movieapp.Utilities.JsonUtils;
import com.example.movieapp.Utilities.NetworkUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView mRecyclerview;
    private static final int GRIDSPANCOUNT = 3;
    private MovieAdapter mMovieAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.rv_movie);
        //layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(this,GRIDSPANCOUNT);
        mRecyclerview.setLayoutManager(layoutManager);
        //performance
        mRecyclerview.setHasFixedSize(true);
        List<Movie> movies = new ArrayList<>();
        mMovieAdapter = new MovieAdapter(movies);
        mRecyclerview.setAdapter(mMovieAdapter);
        loadMovieData();
    }
    private void loadMovieData() {
        String sort = MoviePrefrences.getPrehredshortcritirea(this);
        new FetchMovieTask().execute(sort);
    }
    public class FetchMovieTask extends AsyncTask<String, Void, List<Movie>> {

        @Override
        protected List<Movie> doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }

            String url = params[0];
            URL movieRequestUrl = NetworkUtils.builtMovieUrl(url);

            try {
                String jsonMovieResponse = NetworkUtils.getResponseFromHttpUrl(movieRequestUrl);

                List<Movie> jsonMovieData = JsonUtils.parseMovieJson(jsonMovieResponse);

                return jsonMovieData;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                Log.e(TAG, "Problem retrieving the Movie Database JSON results.");
            }
            return null;
        }

        /**
         * Display the result fo the network request
         */
        @Override
        protected void onPostExecute(List<Movie> movies) {
            // Clear the adapter of the previous movie data
            mMovieAdapter.cl

            // Add the movie data
            if (movies != null && !movies.isEmpty()) {
                mMovieAdapter.addAll(movies);
            }
        }
    }
}