package id.tmdbapps.model;

import java.util.List;

public class MovieResponse {

    private List<Movie> results;

    public MovieResponse() {
    }

    public MovieResponse(List<Movie> movieList) {
        this.results = movieList;
    }

    public List<Movie> getMovieList() {
        return results;
    }

    public void setMovieList(List<Movie> movieList) {
        this.results = movieList;
    }

}
