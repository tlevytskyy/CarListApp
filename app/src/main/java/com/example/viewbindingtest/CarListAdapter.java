package com.example.viewbindingtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarListHolder> {

    private Context context;
    private ArrayList<CarInfo> cars;
    private RecyclerViewClickListener listener;

    public CarListAdapter(Context context, ArrayList<CarInfo> cars, RecyclerViewClickListener listener) {
        this.context = context;
        this.cars = cars;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CarListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarListHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.car_list_item,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CarListHolder holder, int position) {
        CarInfo car = cars.get(position);

        holder.tvTitle.setText(car.Name);
        holder.tvPrice.setText("$" + car.Price);
        holder.tvMiles.setText(car.Miles+ " miles");
        holder.tvDescription.setText(car.Description);
        holder.Image.setImageResource(car.Image);

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class CarListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvTitle;
        TextView tvPrice;
        TextView tvMiles;
        TextView tvDescription;
        ImageView Image;

        public CarListHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvCardListItem_title);
            tvPrice = itemView.findViewById(R.id.tvCardListitem_price);
            tvMiles = itemView.findViewById(R.id.tvCatListItem_miles);
            tvDescription = itemView.findViewById(R.id.tvCardListItem_desc);
            Image = itemView.findViewById(R.id.cardCarListItem_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
}
}
