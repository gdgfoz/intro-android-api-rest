package br.com.gdgfoz.apirest.api;

import br.com.gdgfoz.apirest.Config;
import br.com.gdgfoz.apirest.models.CategoriesResponse;
import br.com.gdgfoz.apirest.models.TasksResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by hussan on 12/3/15.
 */
public interface TodoApi {

    @GET("/categories")
    @Headers({"Authorization: " + Config.TOKEN_API})
    void listCategories(Callback<CategoriesResponse> callback);


    @GET("/tasks/category/{category}")
    @Headers({"Authorization: " + Config.TOKEN_API})
    void listTasks(@Path("category") int category,Callback<TasksResponse> callback);

//    @GET("/categories")
//    @Headers({"Authorization: "+ Config.TOKEN_API})
//    void listCategorias(Callback<Category> callback);
//
//    @GET("/tasks/category/{category}")
//    void detailPerson(@Path("category") String category, Callback<List<Person>> callback);
}
