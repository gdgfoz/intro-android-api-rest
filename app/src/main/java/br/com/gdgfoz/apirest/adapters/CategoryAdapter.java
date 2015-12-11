package br.com.gdgfoz.apirest.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.gdgfoz.apirest.R;
import br.com.gdgfoz.apirest.models.Category;


/**
 * Created by hussan on 12/3/15.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private CategoryClickListener clickListener;
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Category> items;
    private int mItemLayoutResId = R.layout.list_item_category;


    public CategoryAdapter(Context context, ArrayList<Category> persons) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        items = persons;
    }


    public interface CategoryClickListener
    {
        public void categoryCLicked(Category person);
    }


    public CategoryClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(CategoryClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(mItemLayoutResId, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Category category = items.get(position);

        holder.txtNameCategory.setText(category.getCategory());

        Picasso.with(mContext).load(category.getSrc());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickListener.categoryCLicked(category);
            }
        });

//        if(!person.getFoto().isEmpty())
//            Picasso.with(mContext).load(person.getFoto()).placeholder(R.drawable.gdg).into(holder.imgPhotoPerson);
//
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickListener.personCLicked(items.get(position));
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Category> items){
        this.items = items;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgIconCategory;
        TextView txtNameCategory;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            imgIconCategory = (ImageView) itemView.findViewById(R.id.img_icon_category);
            txtNameCategory = (TextView) itemView.findViewById(R.id.txt_name_category);
            cardView = (CardView) itemView.findViewById(R.id.card_view);

        }
    }
}
