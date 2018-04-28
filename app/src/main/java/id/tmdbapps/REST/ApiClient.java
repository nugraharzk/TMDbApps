package id.tmdbapps.REST;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    // Base URL for Retrofit
    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private static Retrofit retrofit = null;

    // getClient Method
    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
