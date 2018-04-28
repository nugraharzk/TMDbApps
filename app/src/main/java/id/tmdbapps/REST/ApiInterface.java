package id.tmdbapps.REST;

import id.tmdbapps.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("popular")
    Call<MovieResponse> getPopular(@Query("api_key") String api_key);

}
