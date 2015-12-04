package br.com.gdgfoz.apirest.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import br.com.gdgfoz.apirest.Utils;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

public class RestClient {
    private static PersonApi REST_CLIENT;

    private static final RestAdapter.Builder builder;

    static {
        Gson gson = new GsonBuilder()
                .create();
        RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.FULL;
        builder = new RestAdapter.Builder();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(15, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(15, TimeUnit.SECONDS);
        builder.setEndpoint(Utils.PERSON_API)
                .setConverter(new GsonConverter(gson))
                .setClient(new OkClient(okHttpClient))
                .setLogLevel(logLevel);
        RestAdapter restAdapter = builder.build();
        REST_CLIENT = restAdapter.create(PersonApi.class);
    }

    public static PersonApi get() {
        return REST_CLIENT;
    }
}

