package br.com.gdgfoz.apirest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import br.com.gdgfoz.apirest.R;
import br.com.gdgfoz.apirest.adapters.PersonAdapter;
import br.com.gdgfoz.apirest.api.RestClient;
import br.com.gdgfoz.apirest.models.Person;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity implements PersonAdapter.PersonClickListener{

    private LinearLayoutManager mLayoutManager;
    private RecyclerView listPerson;
    private PersonAdapter personAdapter;
    private ProgressBar mProgressBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        setSupportActionBar(toolbar);

        listPerson = (RecyclerView) findViewById(R.id.list_person);

        personAdapter = new PersonAdapter(this, new ArrayList<Person>(), this);

        setRecyclerView();

        RestClient.get().listPerson(new Callback<List<Person>>() {
            @Override
            public void success(List<Person> items, Response response) {
                mProgressBar.setVisibility(View.GONE);
                listPerson.setVisibility(View.VISIBLE);
                personAdapter.setItems(items);
            }

            @Override
            public void failure(RetrofitError error) {
                mProgressBar.setVisibility(View.GONE);
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
//        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void personCLicked(Person person) {
        Intent mIntent = new Intent(this, PersonDetailActivity.class);

        Bundle data = new Bundle();
        data.putSerializable("person", person);

        mIntent.putExtras(data);

        startActivity(mIntent);
    }
}
