package com.example.tugas_pwpb6_headset;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewHeadset extends RecyclerView.Adapter<CardViewHeadset.ViewHolder> {
    private ArrayList<Headset> listHeadset;

    public CardViewHeadset(ArrayList<Headset> listGuitar){
        this.listHeadset = listGuitar;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_headset, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {

        final Headset headset = listHeadset.get(i);
        Glide.with(holder.itemView.getContext())
                .load(headset.getPhoto())
                .apply(new RequestOptions().override(800,800))
                .into(holder.imgPhoto);

        holder.tvNama.setText(headset.getNama());
        holder.tvDeskripsi.setText(headset.getDeskripsi());

        holder.card_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), HeadsetDetail.class);
                HeadsetDetail detail = new HeadsetDetail();
                intent.putExtra(detail.EXTRA_GAMBAR, headset.getPhoto());
                intent.putExtra(detail.EXTRA_NAMA, headset.getNama());
                intent.putExtra(detail.EXTRA_HARGA, headset.getHarga());
                intent.putExtra(detail.EXTRA_DESKRIPSI, headset.getDeskripsi());

                holder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listHeadset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView card_View;
        ImageView imgPhoto;
        TextView tvNama, tvDeskripsi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvNama = itemView.findViewById(R.id.tv_item_name);
            tvDeskripsi = itemView.findViewById(R.id.tv_desc);
            card_View = itemView.findViewById(R.id.card_view);
        }
    }
}
