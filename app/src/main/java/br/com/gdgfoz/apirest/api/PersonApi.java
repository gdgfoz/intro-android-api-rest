package br.com.gdgfoz.apirest.api;

import java.util.List;

import br.com.gdgfoz.apirest.models.Person;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by hussan on 12/3/15.
 */
public interface PersonApi {

    @GET("/pessoas")
    void listPerson(Callback<List<Person>> callback);

    @GET("/pessoas/{id}")
    void detailPerson(@Path("id") String id, Callback<List<Person>> callback);
}
