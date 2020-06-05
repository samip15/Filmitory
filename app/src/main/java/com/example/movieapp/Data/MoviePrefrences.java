package com.example.movieapp.Data;

import android.content.Context;

public class MoviePrefrences {
    private static final String PREF_POPULAR = "popular";

    public static String getPreferredSortCriteria(Context context) {
        return PREF_POPULAR;
    }
}
