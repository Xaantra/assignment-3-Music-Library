package fr.isep.ii3510.assignment3;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterSong extends RecyclerView.Adapter<RecyclerViewAdapterSong.ViewHolderSong> {

    private ArrayList<String> mSongNames;
    private ArrayList<String> mImages;
    private Context mContext;

    public RecyclerViewAdapterSong(ArrayList<String> mSongNames, ArrayList<String> mImages, Context mContext) {
        this.mSongNames = mSongNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolderSong onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolderSong holder = new ViewHolderSong(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSong holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);
        holder.albumSong.setText(mSongNames.get(position));

    }

    @Override
    public int getItemCount() {
        return mSongNames.size();
    }

    public class ViewHolderSong extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView albumSong;
        RelativeLayout parentLayout;

        public ViewHolderSong(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            albumSong = itemView.findViewById(R.id.item_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }

}
