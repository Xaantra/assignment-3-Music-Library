package fr.isep.ii3510.assignment3;

import android.content.Context;
import android.content.Intent;
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

public class RecyclerViewAdapterBand extends RecyclerView.Adapter<RecyclerViewAdapterBand.ViewHolder> {

    private ArrayList<String> mBandNames;
    private ArrayList<String> mImages;
    private Context mContext;

    public RecyclerViewAdapterBand(ArrayList<String> mAlbumNames, ArrayList<String> mImages, Context mContext) {
        this.mBandNames = mAlbumNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.bandName.setText(mBandNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mBandNames.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (view.getContext(), AlbumActivity.class);
                intent.putExtra("EXTRA_BAND_NAME", mBandNames.get(position));
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mBandNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView bandName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            bandName = itemView.findViewById(R.id.item_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }


}
