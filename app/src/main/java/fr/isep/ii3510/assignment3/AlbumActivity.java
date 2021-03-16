package fr.isep.ii3510.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {


    RecyclerView albumList;
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        albumList = findViewById(R.id.albumList);
        initImageBitmaps();
        readData();
    }

    private void readData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String bandName = extras.getString("EXTRA_BAND_NAME");
            InputStream is = getResources().openRawResource(R.raw.library);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String line = "";
            try {
                while (((line = reader.readLine()) != null)) {
                    String[] tokens = line.split(",");
                    if (mNames.contains(tokens[1]) == false && !tokens[1].equals("Album") && tokens[0].equals(bandName)) {
                        mNames.add(tokens[1]);
                    }

                }
            } catch (IOException e) {
                Log.d("AlbumActivity", "Error reading file on line " + line, e);
                e.printStackTrace();
            }
            initRecyclerView();
        }

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.albumList);
        RecyclerViewAdapterAlbum adapter = new RecyclerViewAdapterAlbum(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initImageBitmaps(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String bandName = extras.getString("EXTRA_BAND_NAME");
            if(bandName.equals("Pink Floyd")){
                mImageUrls.add("https://i.imgur.com/pbqwEZ8.jpg");
                mImageUrls.add("https://i.imgur.com/ND75cw2.jpg");
            } else if (bandName.equals("Queen")){
                mImageUrls.add("https://i.imgur.com/uC2zOuK.jpg");

            } else {
                mImageUrls.add("https://i.imgur.com/tNBOB9C.png");
                mImageUrls.add("https://i.imgur.com/l43FaVF.jpg");

            }
        }
        // FAIL PROOF
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");
        mImageUrls.add("https://i.imgur.com/m92hpDr.png");

    }
}