package com.yasarapaydin.instagramclonejava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yasarapaydin.instagramclonejava.databinding.ReceyclerRowBinding;
import com.yasarapaydin.instagramclonejava.model.Post;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private ArrayList<Post> postArrayList;

    public PostAdapter(ArrayList<Post> postArrayList) {
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ReceyclerRowBinding receyclerRowBinding = ReceyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
                return new PostHolder(receyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
holder.receyclerRowBinding.recyclerViewUserEmail.setText(postArrayList.get(position).email);
holder.receyclerRowBinding.recyclerViewCommentText.setText(postArrayList.get(position).comment);
        Picasso.get().load(postArrayList.get(position).downloadUrl).into(holder.receyclerRowBinding.recyclerViewImageView);
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

class PostHolder extends RecyclerView.ViewHolder{
        ReceyclerRowBinding receyclerRowBinding;
    public PostHolder(ReceyclerRowBinding receyclerRowBinding) {
        super(receyclerRowBinding.getRoot());
    this.receyclerRowBinding = receyclerRowBinding;

    }
}


}