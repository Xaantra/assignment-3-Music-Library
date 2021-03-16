package fr.isep.ii3510.assignment3;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
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

public class RecyclerViewAdapterAlbum extends RecyclerView.Adapter<RecyclerViewAdapterAlbum.ViewHolderAlbum> {

    private ArrayList<String> mAlbumNames;
    private ArrayList<String> mImages;
    private Context mContext;

    public RecyclerViewAdapterAlbum(ArrayList<String> mAlbumNames, ArrayList<String> mImages, Context mContext) {
        this.mAlbumNames = mAlbumNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolderAlbum onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolderAlbum holder = new ViewHolderAlbum(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAlbum holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.albumName.setText(mAlbumNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RecyclerViewAdapter", "onClick: clicked on: " + mAlbumNames.get(position));
                Toast.makeText(mContext, mAlbumNames.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (view.getContext(), SongActivity.class);
                intent.putExtra("EXTRA_ALBUM_NAME", mAlbumNames.get(position));
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mAlbumNames.size();
    }

    public class ViewHolderAlbum extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView albumName;
        RelativeLayout parentLayout;

        public ViewHolderAlbum(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            albumName = itemView.findViewById(R.id.item_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }

}
