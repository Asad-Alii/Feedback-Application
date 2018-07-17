package com.asad.myfirstjob;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MyCategoryAdapter extends RecyclerView.Adapter<MyCategoryAdapter.ViewHolder> {

    private List<CategoryListItem> categoryListItems;
    private Context context;

    SimpleDateFormat df = new SimpleDateFormat("HH:mm");

    SimpleDateFormat mts = new SimpleDateFormat("08:00"); // Breakfast start time
    SimpleDateFormat mte = new SimpleDateFormat("11:00"); // breakfast end time

    SimpleDateFormat lts = new SimpleDateFormat("13:00"); // Lunch start time
    SimpleDateFormat lte = new SimpleDateFormat("15:00"); // Lunch end time

    SimpleDateFormat dts = new SimpleDateFormat("19:00"); // Dinner start time
    SimpleDateFormat dte = new SimpleDateFormat("23:00"); // Dinner end time

    SimpleDateFormat cts = new SimpleDateFormat("00:00"); // Coffee start time
    SimpleDateFormat cte = new SimpleDateFormat("23:59"); // Coffee end time

    SimpleDateFormat hts = new SimpleDateFormat("16:00"); // Hitea start time
    SimpleDateFormat hte = new SimpleDateFormat("19:00"); // Hitea end time

    private long currentTime;
    private long breakfastTimeStart, breakfastTimeEnd;
    private long lunchTimeStart, lunchTimeEnd;
    private long dinnerTimeStart, dinnerTimeEnd;
    private long coffeeTimeStart, coffeeTimeEnd;
    private long hiteaTimeStart, hiteaTimeEnd;
    String timing;

    String Breakfast = "Breakfast";
    String Lunch = "Lunch";
    String Dinner = "Dinner";
    String Coffee = "Coffee";
    String Hitea = "Hitea";

    public MyCategoryAdapter(List<CategoryListItem> categoryListItems, Context context) {
        this.categoryListItems = categoryListItems;
        this.context = context;
    }

    @Override
    public MyCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        CategoryListItem categoryListItem = categoryListItems.get(position);

        Calendar c = Calendar.getInstance();
        String formattedTime = df.format(c.getTime());

        String breakfastStart = mts.format(c.getTime());
        String breakfastEnd = mte.format(c.getTime());

        String lunchStart = lts.format(c.getTime());
        String lunchEnd = lte.format(c.getTime());

        String dinnerStart = dts.format(c.getTime());
        String dinnerEnd = dte.format(c.getTime());

        String coffeeStart = cts.format(c.getTime());
        String coffeeEnd = cte.format(c.getTime());

        String hiteaStart = hts.format(c.getTime());
        String hiteaEnd = hte.format(c.getTime());

        currentTime = parseTime(formattedTime).getTime();
        breakfastTimeStart = parseTime(breakfastStart).getTime();
        breakfastTimeEnd = parseTime(breakfastEnd).getTime();
        lunchTimeStart = parseTime(lunchStart).getTime();
        lunchTimeEnd = parseTime(lunchEnd).getTime();
        dinnerTimeStart = parseTime(dinnerStart).getTime();
        dinnerTimeEnd = parseTime(dinnerEnd).getTime();
        coffeeTimeStart = parseTime(coffeeStart).getTime();
        coffeeTimeEnd = parseTime(coffeeEnd).getTime();
        hiteaTimeStart = parseTime(hiteaStart).getTime();
        hiteaTimeEnd = parseTime(hiteaEnd).getTime();

        holder.catid.setText(categoryListItem.getServiceCatID());
        holder.catdesc.setText(categoryListItem.getServiceCatDesc());
        Picasso.get().load("https://i.imgur.com/VQEsGHz.jpg").resize(100, 100).centerCrop().into(holder.catimg);


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isClick) {

                if (holder.catdesc.getText().toString().equals(Breakfast) && breakfastTimeStart < currentTime && breakfastTimeEnd > currentTime)
                {
                    timing = "Good Morning!";
                    Intent in = new Intent(context, RatingActivity.class);
                    in.putExtra("catId", holder.catid.getText().toString());
                    in.putExtra("catDesc", holder.catdesc.getText().toString());
                    in.putExtra("timing", timing);
                    context.startActivity(in);
                    return;
                }

                if (holder.catdesc.getText().toString().equals(Lunch) && lunchTimeStart < currentTime && lunchTimeEnd > currentTime)
                {
                    timing = "Good AfterNoon!";
                    Intent in = new Intent(context, RatingActivity.class);
                    in.putExtra("catId", holder.catid.getText().toString());
                    in.putExtra("catDesc", holder.catdesc.getText().toString());
                    in.putExtra("timing", timing);
                    context.startActivity(in);
                    return;
                }

                if (holder.catdesc.getText().toString().equals(Dinner) && dinnerTimeStart < currentTime && dinnerTimeEnd > currentTime)
                {
                    timing = "Good Night!";
                    Intent in = new Intent(context, RatingActivity.class);
                    in.putExtra("catId", holder.catid.getText().toString());
                    in.putExtra("catDesc", holder.catdesc.getText().toString());
                    in.putExtra("timing", timing);
                    context.startActivity(in);
                    return;
                }

                if ( holder.catdesc.getText().toString().equals(Coffee) && coffeeTimeStart < currentTime && coffeeTimeEnd > currentTime)
                {
                    timing = "Good Evening!";
                    Intent in = new Intent(context, RatingActivity.class);
                    in.putExtra("catId", holder.catid.getText().toString());
                    in.putExtra("catDesc", holder.catdesc.getText().toString());
                    in.putExtra("timing", timing);
                    context.startActivity(in);
                    return;
                }

                if ( holder.catdesc.getText().toString().equals(Hitea) && hiteaTimeStart < currentTime && hiteaTimeEnd > currentTime)
                {
                    timing = "Good Evening!";
                    Intent in = new Intent(context, RatingActivity.class);
                    in.putExtra("catId", holder.catid.getText().toString());
                    in.putExtra("catDesc", holder.catdesc.getText().toString());
                    in.putExtra("timing", timing);
                    context.startActivity(in);
                    return;
                }

                else
                {
                    Toast.makeText(context, "You cannot rate your " + holder.catdesc.getText().toString() + " at this time.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Date parseTime(String time) {

        try {
            return df.parse(time);
        } catch (java.text.ParseException e) {
            return new Date(0);
        }


    }

    @Override
    public int getItemCount() {
        return categoryListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener
    {

        public TextView catid;
        public TextView catdesc;
        public ImageView catimg;

        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);

            catid = itemView.findViewById(R.id.txt_catId);
            catdesc = itemView.findViewById(R.id.txt_catDesc);
            catimg = itemView.findViewById(R.id.txt_catImg);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {

            itemClickListener.onClick(view, getAdapterPosition(), false);

        }

        @Override
        public boolean onLongClick(View view) {

            itemClickListener.onClick(view, getAdapterPosition(), true );
            return true;
        }
    }
}
