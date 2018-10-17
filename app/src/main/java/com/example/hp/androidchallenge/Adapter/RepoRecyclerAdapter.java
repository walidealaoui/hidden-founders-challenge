package com.example.hp.androidchallenge.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.androidchallenge.R;
import com.example.hp.androidchallenge.Model.RepoDataModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp on 29/09/2018.
 */

public class RepoRecyclerAdapter extends RecyclerView.Adapter<RepoRecyclerAdapter.ViewHolder>{

    private Context context;
    List<RepoDataModel> reposList=new ArrayList<>();
    public RepoRecyclerAdapter(Context ctx, List<RepoDataModel> repos) {
        this.context=ctx;
        this.reposList=repos;
    }

    @Override
    public RepoRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.repo_elements,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoRecyclerAdapter.ViewHolder holder, int position) {
        RepoDataModel repo=reposList.get(position);

        String avatar_url=repo.getAvatar();
        holder.repo_name.setText(repo.getRepo_name());
        holder.description.setText(repo.getRepo_description());
        holder.owner_repo.setText(repo.getOwner_name());
        holder.stars.setText(Integer.toString(repo.getNumber_of_stars()));
        Picasso.get().load(avatar_url).into(holder.avatar_owner);
    }

    @Override
    public int getItemCount() {
        return reposList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView description,repo_name,owner_repo,stars;
        ImageView avatar_owner;

        public ViewHolder(View itemView) {
            super(itemView);


            description=(TextView)itemView.findViewById(R.id.description);
            repo_name=(TextView)itemView.findViewById(R.id.reponame);
            owner_repo=(TextView)itemView.findViewById(R.id.ownername);
            avatar_owner=(ImageView)itemView.findViewById(R.id.avatar);
            stars=(TextView)itemView.findViewById(R.id.stars);



        }
    }
}
