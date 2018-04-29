package id.tmdbapps.model;

public class Movie {

    private String title, overview, poster_path, vote_average;

    public Movie() {
    }

    public Movie(String title, String overview, String poster_path, String vote_average) {
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }
}
