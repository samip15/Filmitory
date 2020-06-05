package com.example.movieapp.Utilities;

import android.text.TextUtils;

import com.example.movieapp.Model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String TAG = "JsonUtils";
    private static final String KEY_RESULTS = "results";
    private static final String KEY_ORIGINAL_TITLE = "original_title";
    private static final String KEY_POSTER_PATH = "poster_path";
    private static final String KEY_OVERVIEW = "overview";
    private static final String KEY_VOTE_AVERAGE = "vote_average";
    private static final String KEY_REALEASE_DATE = "release_date";
    private static final String KEY_STATUS_CODE = "status_code";
    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    private static final String IMAGE_FILE_SIZE  = "w185";

     public static List<Movie> parseMovieJson(String movieJsonStr)throws JSONException {
        //IF THE JSON STR IS EMPTY OR NOT
        if (TextUtils.isEmpty(movieJsonStr)){
            return null;
        }
        List<Movie> movies  = new ArrayList<>();
        //create a main json object
        JSONObject movieBaseJson = new JSONObject(movieJsonStr);
        if (movieBaseJson.has(KEY_STATUS_CODE)){
            int errorcode = movieBaseJson.getInt(KEY_STATUS_CODE);
            switch (errorcode){
                case HttpURLConnection
                        .HTTP_OK:
                    break;

                case HttpURLConnection
                        .HTTP_NOT_FOUND:
                    return null;
                default:
                    return null;

            }
        }

        //parsing all values

        JSONArray resultArray = movieBaseJson.getJSONArray(KEY_RESULTS);
        for (int i=0;i<resultArray.length();i++){
            JSONObject currentMovie = resultArray.getJSONObject(i);
            //poster path
            String posterpath = null;
            if (currentMovie.has(KEY_POSTER_PATH)){
                posterpath = currentMovie.getString(KEY_POSTER_PATH);

            }
            String thumbnelUrl = IMAGE_BASE_URL+IMAGE_FILE_SIZE+posterpath;

            //original title
            String originaltitle = null;
            if (currentMovie.has(KEY_ORIGINAL_TITLE)){
                originaltitle = currentMovie.getString(KEY_ORIGINAL_TITLE);
            }

            //overview
            String overview = null;
            if (currentMovie.has(KEY_OVERVIEW)){
                originaltitle = currentMovie.getString(KEY_OVERVIEW);
            }

            //release date
            String releasedate = null;
            if (currentMovie.has(KEY_REALEASE_DATE)){
                originaltitle = currentMovie.getString(KEY_REALEASE_DATE);
            }

            //AVG VOTE
            double averagevote = 0;
            if (currentMovie.has(KEY_VOTE_AVERAGE)){
                originaltitle = currentMovie.getString(KEY_VOTE_AVERAGE);
            }
            // Movie Object
            Movie movie = new Movie(originaltitle,thumbnelUrl,overview,averagevote,releasedate);
            movies.add(movie);
        }
        return movies;

    }
}
