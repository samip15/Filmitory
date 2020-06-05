package com.example.movieapp.Utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    private static final String TAG = "NetworkUtils";
    private static final String MOVIEBASEURL = "https://api.themoviedb.org/3";
    private static final String MOVIEPATH = "movie";
    private static final String API_KEY_PARAM = "api_key";
    private static final String API__KEY = "30f0cc39fda572e52bbc94adab7ac7ec";

    public static URL builtMovieUrl(String sortCritirea) {
        Uri builtUri = Uri.parse(MOVIEBASEURL)
                .buildUpon()
                .appendPath(MOVIEPATH)
                .appendQueryParameter(API_KEY_PARAM, API__KEY)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
