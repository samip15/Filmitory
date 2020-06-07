package com.example.movieapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int mid;
    /** Title of the movie */
    private String mTitle;
    /** Movie poster image thumbnail */
    private String mThumbnail;
    /** Overview (or plot synopsis) of the movie */
    private String mOverview;
    /** Vote average (or user rating) of the movie */
    private double mVoteAverage;
    /** Release date of the movie */
    private String mReleaseDate;

    /**
     * Constructs a new {@link Movie} object
     *
     * @param title is the original title of the movie
     * @param thumbnail is movie poster image thumbnail
     * @param overview is a plot synopsis of the movie
     * @param voteAverage is user rating of the movie
     * @param releaseDate is the release date of the movie
     */
    public Movie(int mid,String title, String thumbnail, String overview, double voteAverage, String releaseDate) {
        this.mid = mid;
        mTitle = title;
        mThumbnail = thumbnail;
        mOverview = overview;
        mVoteAverage = voteAverage;
        mReleaseDate = releaseDate;
    }

    private Movie(Parcel in) {
        mid = in.readInt();
        mTitle = in.readString();
        mThumbnail = in.readString();
        mOverview = in.readString();
        mVoteAverage = in.readDouble();
        mReleaseDate = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    /**
     * Returns the original title of the movie
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns a movie poster thumbnail image url
     */
    public String getThumbnail() {
        return mThumbnail;
    }

    /**
     * Returns a plot synopsis of the movie
     */
    public String getOverview() {
        return mOverview;
    }

    /**
     * Returns user rating of the movie
     */
    public double getVoteAverage() {
        return mVoteAverage;
    }

    /**
     * Returns release date of the movie
     */
    public String getReleaseData() {
        return mReleaseDate;
    }
    public int getId(){
        return mid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mid);
        dest.writeString(mTitle);
        dest.writeString(mThumbnail);
        dest.writeString(mOverview);
        dest.writeDouble(mVoteAverage);
        dest.writeString(mReleaseDate);
    }
}