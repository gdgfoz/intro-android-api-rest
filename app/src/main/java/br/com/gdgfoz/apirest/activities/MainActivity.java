package br.com.gdgfoz.apirest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.gdgfoz.apirest.Constants;
import br.com.gdgfoz.apirest.R;
import br.com.gdgfoz.apirest.adapters.CategoryAdapter;
import br.com.gdgfoz.apirest.api.RestClient;
import br.com.gdgfoz.apirest.models.CategoriesResponse;
import br.com.gdgfoz.apirest.models.Category;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity implements CategoryAdapter.CategoryClickListener{

    private LinearLayoutManager mLayoutManager;
    private RecyclerView listCategory;
    private CategoryAdapter categoryAdapter;
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

        listCategory = (RecyclerView) findViewById(R.id.list_data);

        categoryAdapter = new CategoryAdapter(this, new ArrayList<Category>());
        categoryAdapter.setClickListener(this);

        setRecyclerView();

        RestClient.get().listCategories(new Callback<CategoriesResponse>() {
            @Override
            public void success(CategoriesResponse categoriesResponse, Response response) {
                mProgressBar.setVisibility(View.GONE);
                categoryAdapter.setItems(categoriesResponse.getData());
                listCategory.setVisibility(View.VISIBLE);
            }

            @Override
            public void failure(RetrofitError error) {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Falha na api", Toast.LENGTH_LONG).show();
            }
        });

//        RestClient.get().listCategory(new Callback<List<Person>>() {
//            @Override
//            public void success(List<Person> items, Response response) {
//                mProgressBar.setVisibility(View.GONE);
//                listCategory.setVisibility(View.VISIBLE);
//                categoryAdapter.setItems(items);
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                mProgressBar.setVisibility(View.GONE);
//                Log.d("gdg", "fail" + error.getMessage());
//            }
//        });

    }

    private void setRecyclerView() {

        mLayoutManager = new LinearLayoutManager(this);
        listCategory.setLayoutManager(mLayoutManager);
        listCategory.setHasFixedSize(true);
        listCategory.setAdapter(categoryAdapter);

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
    public void categoryCLicked(Category category) {

        Intent mIntent = new Intent(this, TasksActivity.class);

        Bundle data = new Bundle();

        data.putInt(Constants.CATEGORY_ID, category.getId());
        data.putString(Constants.CATEGORY_NAME, category.getCategory());

        mIntent.putExtras(data);

        startActivity(mIntent);

    }
//
//    @Override
//    public void personCLicked(Person person) {
//        Intent mIntent = new Intent(this, TasksActivity.class);
//
//        Bundle data = new Bundle();
//        data.putSerializable("person", person);
//
//        mIntent.putExtras(data);
//
//        startActivity(mIntent);
//    }


}
