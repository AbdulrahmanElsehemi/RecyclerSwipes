package com.minerva.recyclerswipes;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by Abdulrahman on 9/6/2018.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    public List<Player> players;

    public PlayerAdapter(List<Player> players) {
        this.players = players;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_row, parent, false);

        return new PlayerViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {

        Player player = players.get(position);
        holder.name.setText(player.getName());
        holder.nationality.setText(player.getNationality());
        holder.club.setText(player.getClub());
        holder.rating.setText(player.getRating().toString());
        holder.age.setText(player.getAge().toString());
        holder.cardView.setCardBackgroundColor(holder.getRandomColorCode());
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name, nationality, club, rating, age;
        private CardView cardView;
        public PlayerViewHolder(View itemView)
        {
            super(itemView);
            cardView=itemView.findViewById(R.id.card_view_item);
            name =  itemView.findViewById(R.id.name);
            nationality =  itemView.findViewById(R.id.nationality);
            club =  itemView.findViewById(R.id.club);
            rating = itemView.findViewById(R.id.rating);
            age =  itemView.findViewById(R.id.age);
        }

        public int getRandomColorCode(){

            int[] androidColors = itemView.getResources().getIntArray(R.array.androidcolors);

            int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
            return  randomAndroidColor;

        }
    }



 }

