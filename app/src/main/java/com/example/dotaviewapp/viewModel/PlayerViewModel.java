package com.example.dotaviewapp.viewModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dotaviewapp.model.Player;
import com.example.dotaviewapp.view.activity.DetailActivity;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class PlayerViewModel {

    private Context context;
    private Player player;

    public PlayerViewModel(Context context, Player player) {
        this.context = context;
        this.player = player;
    }

    public String getImageUrl() {
        return player.getAvatarUrl();
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getPlayerID() {
        return String.valueOf(player.getID());
    }

    @BindingAdapter("avatarUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        RequestOptions option = new RequestOptions().circleCrop();
        Glide.with(imageView.getContext())
                .load(url)
                .apply(option)
                .transition(withCrossFade())
                .into(imageView);
    }

    @BindingAdapter("circleAvatarUrl")
    public static void setImageUrl(CircleImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    public void onClick(View v){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("player-parcelable", player);
        context.startActivity(intent);
    }
}
