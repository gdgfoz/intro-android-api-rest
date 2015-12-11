package br.com.gdgfoz.apirest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.gdgfoz.apirest.Constants;
import br.com.gdgfoz.apirest.R;
import br.com.gdgfoz.apirest.adapters.TaskAdapter;
import br.com.gdgfoz.apirest.api.RestClient;
import br.com.gdgfoz.apirest.models.Task;
import br.com.gdgfoz.apirest.models.TasksResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TasksActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView listTask;
    private LinearLayoutManager mLayoutManager;
    private TaskAdapter taskAdapter;
    private ProgressBar mProgressBar;
//    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        setupToolbar();


        Bundle data = getIntent().getExtras();

        int categoryId = data.getInt(Constants.CATEGORY_ID);
        String categoryName = data.getString(Constants.CATEGORY_NAME);

        taskAdapter = new TaskAdapter(this, new ArrayList<Task>());

        setRecyclerView();

        getSupportActionBar().setTitle(categoryName);

        RestClient.get().listTasks(categoryId, new Callback<TasksResponse>() {
            @Override
            public void success(TasksResponse tasksResponse, Response response) {
                mProgressBar.setVisibility(View.GONE);
                taskAdapter.setItems(tasksResponse.getTasks());
                listTask.setVisibility(View.VISIBLE);
            }

            @Override
            public void failure(RetrofitError error) {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(TasksActivity.this, "Falha na api", Toast.LENGTH_LONG).show();
            }
        });

//        person = (Person) data.getSerializable("person");

        setData();
    }
    private void setRecyclerView() {

        listTask = (RecyclerView) findViewById(R.id.list_data);

        mLayoutManager = new LinearLayoutManager(this);
        listTask.setLayoutManager(mLayoutManager);
        listTask.setHasFixedSize(true);
        listTask.setAdapter(taskAdapter);

    }

    private void setData() {

//        getSupportActionBar().setTitle(person.getNome());
//
//        txtNamePerson.setText(person.getNome());
//        txtDatePerson.setText(person.getDataDes());
//
//        if (!person.getFoto().isEmpty())
//            Picasso.with(this).load(person.getFoto()).placeholder(R.drawable.gdg).into(imgPhotoPerson);
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

//        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
//        upArrow.setColorFilter(ContextCompat.getColor(this, android.R.color.white), PorterDuff.Mode.SRC_ATOP);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(upArrow);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        Log.d("h2", android.R.id.home + " -- " + id);
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
