package com.asad.myfirstjob;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.SmileRating;

import java.util.ArrayList;
import java.util.List;


public class MyRatingAdapter extends RecyclerView.Adapter<MyRatingAdapter.ViewHolder> {

    private List<RatingListItem> ratingListItems;
    private Context context;
    int rating;
    //String test;
    List<String> val= new ArrayList();
    List<String> test= new ArrayList();


    public MyRatingAdapter(List<RatingListItem> ratingListItems, Context context) {
        this.ratingListItems = ratingListItems;
        this.context = context;
    }

    @Override
    public MyRatingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rating_list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyRatingAdapter.ViewHolder holder, int position) {

        SharedPreferences sharedpref = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = sharedpref.edit();

        RatingListItem ratingListItem = ratingListItems.get(position);

        holder.catdesc.setText(ratingListItem.getServiceDesc());

        holder.smrating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                val.add(String.valueOf(holder.smrating.getRating()));
                test.add(holder.catdesc.getText().toString());
                Toast.makeText(context, test + val.toString(), Toast.LENGTH_SHORT).show();
                editor.putString("ServiceArray", String.valueOf(test));
                editor.putString("RatingArray", String.valueOf(val));
                editor.putInt("ServiceSize", test.size());
                editor.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ratingListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView catdesc;
        public SmileRating smrating;
        public Button feedback;

        public ViewHolder(View itemView) {
            super(itemView);

            catdesc = itemView.findViewById(R.id.txt_catDesc);
            smrating = itemView.findViewById(R.id.service_rating);

        }

    }
}
