package br.com.gdgfoz.apirest.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.gdgfoz.apirest.models.Person;
import br.com.gdgfoz.apirest.R;


/**
 * Created by hussan on 12/3/15.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private final PersonClickListener clickListener;
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Person> items;
    private int mItemLayoutResId = R.layout.list_item_person;


    public PersonAdapter(Context context, ArrayList<Person> persons, PersonClickListener clickListener) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        items = persons;
        this.clickListener = clickListener;
    }

    public interface PersonClickListener
    {
        public void personCLicked(Person person);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(mItemLayoutResId, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Person person = items.get(position);

        Log.d("gdg", person.getNome());

        holder.txtNamePerson.setText(person.getNome());
        holder.txtDatePerson.setText(person.getDataDes());

        if(!person.getFoto().isEmpty())
            Picasso.with(mContext).load(person.getFoto()).placeholder(R.drawable.gdg).into(holder.imgPhotoPerson);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.personCLicked(items.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Person> items){
        this.items = items;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhotoPerson;
        TextView txtNamePerson;
        TextView txtDatePerson;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            imgPhotoPerson = (ImageView) itemView.findViewById(R.id.img_photo_person);
            txtNamePerson = (TextView) itemView.findViewById(R.id.txt_name_person);
            txtDatePerson = (TextView) itemView.findViewById(R.id.txt_date_person);
            cardView = (CardView) itemView.findViewById(R.id.card_view);

        }
    }
}
