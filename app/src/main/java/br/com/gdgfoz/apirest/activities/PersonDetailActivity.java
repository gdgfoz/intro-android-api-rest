package br.com.gdgfoz.apirest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.gdgfoz.apirest.R;
import br.com.gdgfoz.apirest.models.Person;

public class PersonDetailActivity extends AppCompatActivity {

    private TextView txtNamePerson;
    private TextView txtDatePerson;
    private ImageView imgPhotoPerson;
    private Toolbar toolbar;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        setupToolbar();

        txtNamePerson = (TextView) findViewById(R.id.txt_name_person);
        txtDatePerson = (TextView) findViewById(R.id.txt_date_person);
        imgPhotoPerson = (ImageView) findViewById(R.id.img_photo_person);

        Bundle data = getIntent().getExtras();
        person = (Person) data.getSerializable("person");

        setData();
    }

    private void setData() {

        getSupportActionBar().setTitle(person.getNome());

        txtNamePerson.setText(person.getNome());
        txtDatePerson.setText(person.getDataDes());

        if (!person.getFoto().isEmpty())
            Picasso.with(this).load(person.getFoto()).placeholder(R.drawable.gdg).into(imgPhotoPerson);
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
