package com.example.movieapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.Model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    List<Movie> mMovies;

    public MovieAdapter(List<Movie> movies){
        this.mMovies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list_item,viewGroup,false);
       return  new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = mMovies.get(position);
        String title = movie.gettitle();
        String thumbnel = movie.getthumbnel();
        double voteavg = movie.getVoteAvegrage();

        holder.titletext_view.setText(title);
        holder.vote_avgtext_view.setText(String.valueOf(voteavg));
        Picasso.get().load(thumbnel).into(holder.thumbnelimgview);
    }

    @Override
    public int getItemCount() {
        if (mMovies==null){
            return 0;
        }else{
            return mMovies.size();
        }
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView titletext_view,vote_avgtext_view;
        ImageView thumbnelimgview;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnelimgview = itemView.findViewById(R.id.iv_thumbnail);
            titletext_view = itemView.findViewById(R.id.tv_title);
            vote_avgtext_view = itemView.findViewById(R.id.tv_vote_average);
        }
    }
}
