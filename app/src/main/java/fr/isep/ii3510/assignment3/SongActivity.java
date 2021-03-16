package fr.isep.ii3510.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    RecyclerView songList;
    private ArrayList<String> mImageUrls = new ArrayList<>();
    ;
    private ArrayList<String> mNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        songList = findViewById(R.id.songList);
        readData();
        initImageBitmaps();
    }


    private void readData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String albumName = extras.getString("EXTRA_ALBUM_NAME");
            InputStream is = getResources().openRawResource(R.raw.library);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String line = "";
            try {
                while (((line = reader.readLine()) != null)) {
                    String[] tokens = line.split(",");
                    if (mNames.contains(tokens[2]) == false && !tokens[2].equals("Song") && tokens[1].equals(albumName)) {
                        mNames.add(tokens[2]);
                    }

                }
            } catch (IOException e) {
                Log.d("SongActivity", "Error reading file on line " + line, e);
                e.printStackTrace();
            }
            initRecyclerView();
        }

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.songList);
        RecyclerViewAdapterSong adapter = new RecyclerViewAdapterSong(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initImageBitmaps() {
        Bundle extras = getIntent().getExtras();
        Log.d("SongActivity", "mNames contain " + mNames.size());
        if (extras != null) {
            String albumName = extras.getString("EXTRA_ALBUM_NAME");
            if (albumName.equals("Dark Side of the Moon")) {
                Log.d("SongActivity", "IM IN DARK SIDE");
                for (int i = 0; i < mNames.size(); i++) {
                    mImageUrls.add("https://i.imgur.com/pbqwEZ8.jpg");
                }
            } else if (albumName.equals("Wish You Were Here")) {
                for (int i = 0; i < mNames.size(); i++) {
                    mImageUrls.add("https://i.imgur.com/ND75cw2.jpg");
                }
            } else if (albumName.equals("The Platinum Collection")) {
                for (int i = 0; i < mNames.size(); i++) {
                    mImageUrls.add("https://i.imgur.com/uC2zOuK.jpg");
                }
            } else if (albumName.equals("In Rainbows")) {
                for (int i = 0; i < mNames.size(); i++) {
                    mImageUrls.add("https://i.imgur.com/tNBOB9C.png");
                }
            } else if (albumName.equals("OK Computer")) {
                for (int i = 0; i < mNames.size(); i++) {
                    mImageUrls.add("https://i.imgur.com/l43FaVF.jpg");
                }
            }
        }
        // FAIL PROOF
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");

    }

}



