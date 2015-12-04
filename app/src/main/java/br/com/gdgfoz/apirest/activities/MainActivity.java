package br.com.gdgfoz.apirest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.gdgfoz.apirest.adapters.PersonAdapter;
import br.com.gdgfoz.apirest.api.PersonApi;
import br.com.gdgfoz.apirest.models.Person;
import br.com.gdgfoz.apirest.R;
import br.com.gdgfoz.apirest.api.RestClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager mLayoutManager;
    private RecyclerView listPerson;
    private PersonAdapter personAdapter;
    private PersonApi service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listPerson = (RecyclerView) findViewById(R.id.list_person);

        personAdapter = new PersonAdapter(this, new ArrayList<Person>());

        setRecyclerView();

        RestClient.get().listPerson(new Callback<List<Person>>() {
            @Override
            public void success(List<Person> items, Response response) {
                personAdapter.setItems(items);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("gdg", "fail" + error.getMessage());
            }
        });

    }

    private void setRecyclerView() {

        mLayoutManager = new LinearLayoutManager(this);
        listPerson.setLayoutManager(mLayoutManager);
        listPerson.setHasFixedSize(true);
        listPerson.setAdapter(personAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
