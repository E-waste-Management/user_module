package com.example.princy.user_module;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class Cartviewholder  extends RecyclerView.Adapter<Cartviewholder.ViewHolder> {
    TextView prd_name , prd_quantity,prd_cat,prd_subcat;
    ImageView prd_image;
    Context mContext;
    ArrayList<data> Mlist_order;
    public Cartviewholder(Context mContext, ArrayList<data> mlistOrder) {
        this.mContext = mContext;
        Mlist_order = mlistOrder;
        Log.d("mList", ""+ Mlist_order);
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        LayoutInflater layoutInflator = LayoutInflater.from(mContext);
        View view =  layoutInflator.inflate(R.layout.cart_item_layout, parent ,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        data pdItem  =  Mlist_order.get(position);
        getIp ip = new getIp();
        String del = ip.getIp();

        String index1, index2,index3;
        index1 = pdItem.getProduct();
        index2 = pdItem.getquantity();
        index3 = pdItem.getImages();

        Log.d("tag", "jholu    "+pdItem);
        Picasso.get().load(""+index3).centerCrop().fit().error(R.drawable.ic_launcher_background).into(prd_image);



        prd_name.setText(index1);
        prd_quantity.setText(index2);


    }

    @Override
    public int getItemCount() {
        return Mlist_order.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            prd_image  = itemView.findViewById(R.id.product_order_image);
            prd_name = itemView.findViewById(R.id.catgory);
            prd_quantity  = itemView.findViewById(R.id.subcatgory);

        }
    }
}
