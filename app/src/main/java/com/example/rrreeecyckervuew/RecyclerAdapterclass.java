package com.example.rrreeecyckervuew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterclass extends RecyclerView.Adapter<ViewHolderClass> {

    ArrayList<DataHolder> arrayList;
    public RecyclerAdapterclass(ArrayList<DataHolder> arrayList) {
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        holder.textView.setText(arrayList.get(holder.getAdapterPosition()).stringData);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
