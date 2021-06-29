package com.example.dotaviewapp.data.remote;


import com.example.dotaviewapp.model.Hero;
import com.example.dotaviewapp.model.Match;
import com.example.dotaviewapp.model.Player;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenDotaClient {

    String BASE_URL = "https://api.opendota.com/api/";

    @GET("search")
    Call<List<Player>> searchPlayers(@Query("q") String name);

    @GET("players/{account_id}/matches")
    Call<List<Match>> getMatches(@Path("account_id") long playerID, @Query("limit") int limit);

    @GET("players/{account_id}/heroes")
    Call<List<Hero>> getHeroes(@Path("account_id") long playerID);
}
