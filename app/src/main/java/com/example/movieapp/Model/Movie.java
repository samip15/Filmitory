package com.example.movieapp.Model;

public class Movie {
    private String mtitle;
    private String mthumbnel;
    private String moverview;
    private double mVoteAvegrage;
    private String mRelagedate;

    public Movie(String mtitle, String mthumbnel, String moverview, double mVoteAvegrage, String mRelagedate) {
        this.mtitle = mtitle;
        this.mthumbnel = mthumbnel;
        this.moverview = moverview;
        this.mVoteAvegrage = mVoteAvegrage;
        this.mRelagedate = mRelagedate;
    }

    public String gettitle() {
        return mtitle;
    }

    public String getthumbnel() {
        return mthumbnel;
    }

    public String getMoverview() {
        return moverview;
    }

    public double getVoteAvegrage() {
        return mVoteAvegrage;
    }

    public String getRelagedate() {
        return mRelagedate;
    }
}
