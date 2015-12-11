package br.com.gdgfoz.apirest.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.gdgfoz.apirest.R;
import br.com.gdgfoz.apirest.models.Category;
import br.com.gdgfoz.apirest.models.Task;


/**
 * Created by hussan on 12/3/15.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private CategoryClickListener clickListener;
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Task> items;
    private int mItemLayoutResId = R.layout.list_item_task;


    public TaskAdapter(Context context, ArrayList<Task> persons) {
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

        final Task task = items.get(position);

        holder.txtNameTask.setText(task.getName());
        holder.txtDescTask.setText(task.getDescription());

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

    public void setItems(List<Task> items){
        this.items = items;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNameTask;
        TextView txtDescTask;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);


            txtNameTask = (TextView) itemView.findViewById(R.id.txt_name_task);
            txtDescTask  = (TextView) itemView.findViewById(R.id.txt_desc_task);
            cardView = (CardView) itemView.findViewById(R.id.card_view);

        }
    }
}
