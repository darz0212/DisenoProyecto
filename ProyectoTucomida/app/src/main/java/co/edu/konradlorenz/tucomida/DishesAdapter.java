package co.edu.konradlorenz.tucomida;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.List;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Dish> dishList;
    DecimalFormat formatea;

    public DishesAdapter(Context mContext, List<Dish> dishList) {
        this.mContext = mContext;
        this.dishList = dishList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, approximatePrice;
        public ImageView thumbnail;
        private View elementView;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.dishName);
            approximatePrice = (TextView) view.findViewById(R.id.dishPrice);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            elementView = view;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DishesAdapter.MyViewHolder holder, int position) {
        final Dish dish = dishList.get(position);

        holder.elementView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Plato seleccionando: "+dish.getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, DishDetailActivity.class);
                intent.putExtra("dishItem", dish);
                mContext.startActivity(intent);
            }
        });
        formatea = new DecimalFormat("###,###.##");

        String formatedPrice = formatea.format(dish.getApproximatePrice());

        holder.name.setText(dish.getName());
        holder.approximatePrice.setText("$"+formatedPrice);
        //holder.approximatePrice.setText("$"+dish.getApproximatePrice());

        Glide.with(mContext).load(dish.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return dishList.size();
    }
}
