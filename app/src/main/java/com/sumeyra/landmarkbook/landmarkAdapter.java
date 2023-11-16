package com.sumeyra.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sumeyra.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class landmarkAdapter extends RecyclerView.Adapter< landmarkAdapter.LandmarkHolder>{
    ArrayList<Landmark> landmarkArrayList;

    public landmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //xml i bağlama işlemini burada yapacağız
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {
    //Viewholder bağlandığı zaman neler olacak onu göreceğimiz method
        //layout içinde hangi verileri göstereceksek burada göstereceğiz 3
        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent =new Intent(holder.itemView.getContext(),DetailsActivity.class);
                 intent.putExtra("landmark",landmarkArrayList.get(position));
                 holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //xml in kaç kere oluşturulacağını söyleyecek 1
        return landmarkArrayList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder{
//bu sınıfı sadece görünümlerimizi tutması için yapıyoruz yardımcı bir sınıf 2
        private RecyclerRowBinding binding;
        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding =binding;
        }
    }}
