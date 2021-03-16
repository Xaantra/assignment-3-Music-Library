package fr.isep.ii3510.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class BandActivity extends AppCompatActivity {

    RecyclerView bandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band);
        initImageBitmaps();
        readData();

        bandList = findViewById(R.id.bandList);

    }

    //private List<SongSample> songSamples = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    private void readData() {
        InputStream is = getResources().openRawResource(R.raw.library);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line = "";
        try {
            while (((line = reader.readLine()) != null)) {
                String[] tokens = line.split(",");
                if (mNames.contains(tokens[0]) == false && !tokens[0].equals("Band")) {
                    mNames.add(tokens[0]);
                }

            }
        } catch (IOException e) {
            Log.d("BandActivity", "Error reading file on line " + line, e);
            e.printStackTrace();
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.bandList);
        RecyclerViewAdapterBand adapter = new RecyclerViewAdapterBand(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initImageBitmaps(){

        mImageUrls.add("https://i.imgur.com/l8NHgsE.jpg");
        mImageUrls.add("https://i.imgur.com/yHFnxGF.jpg");
        mImageUrls.add("https://cdn1.webmanagercenter.com/tekiano/wp-content/uploads/2020/04/radiohead-1.jpg");


    }


}



