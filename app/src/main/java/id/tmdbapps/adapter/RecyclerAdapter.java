package id.tmdbapps.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.tmdbapps.R;
import id.tmdbapps.model.Movie;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Movie> movieList;
    private Context context;
    private LayoutInflater inflater;

    public RecyclerAdapter(Context context, List<Movie> movieList) {
        this.movieList = movieList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView average, title, overview;

        MyViewHolder(View itemView) {
            super(itemView);
            average = itemView.findViewById(R.id.average);
            poster = itemView.findViewById(R.id.poster);
            title = itemView.findViewById(R.id.title);
            overview = itemView.findViewById(R.id.overview);
            itemView.setClickable(true);
            itemView.setEnabled(true);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_content, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);

        holder.average.setText("Ratings " + movie.getVote_average() + " of 10");
        holder.title.setText(movie.getTitle());
        holder.overview.setText(movie.getOverview());
        Glide.with(context).load("http://image.tmdb.org/t/p/w200"+movie.getPoster_path()).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
