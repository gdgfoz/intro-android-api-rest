package br.com.gdgfoz.apirest.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.gdgfoz.apirest.Utils;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class RestClient {

    private static PersonApi REST_CLIENT;
    private static Gson gson = new GsonBuilder().create();
    private static RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.FULL;

    private static RestAdapter.Builder builder = new RestAdapter.Builder()
            .setEndpoint(Utils.PERSON_API)
            .setConverter(new GsonConverter(gson))
            .setLogLevel(logLevel);

    public static <S> S createService(Class<S> serviceClass) {
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }

    public static PersonApi get() {
        REST_CLIENT = builder.build().create(PersonApi.class);
        return REST_CLIENT;
    }

//    private static PersonApi REST_CLIENT;
//
//    static {
//
//
//        builder = new RestAdapter.Builder();
//        builder.setEndpoint(Utils.PERSON_API)
//                .setConverter(new GsonConverter(gson))
//                .setLogLevel(logLevel);
//        RestAdapter restAdapter = builder.build();
//        REST_CLIENT = restAdapter.create(PersonApi.class);
//    }
//
//    public static PersonApi get() {
//        return REST_CLIENT;
//    }
}

