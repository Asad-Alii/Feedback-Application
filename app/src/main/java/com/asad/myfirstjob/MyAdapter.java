package com.asad.myfirstjob;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        ListItem listItem = listItems.get(position);

        holder.catid.setText(listItem.getServiceCatID());
        holder.catdesc.setText(listItem.getServiceCatDesc());
        Picasso.get().load("https://i.imgur.com/VQEsGHz.jpg").resize(100, 100).centerCrop().into(holder.catimg);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isClick) {
                //Toast.makeText(context, "Long Click " + listItems.get(position), Toast.LENGTH_LONG).show();

                Intent in = new Intent(context, RatingActivity.class);
                in.putExtra("catDesc", holder.catdesc.getText().toString());
                context.startActivity(in);

                /*if (isClick)
                {
                    Toast.makeText(context, "Long Click " + listItems.get(position), Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(context, " " + listItems.get(position), Toast.LENGTH_LONG).show();
                }*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
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
