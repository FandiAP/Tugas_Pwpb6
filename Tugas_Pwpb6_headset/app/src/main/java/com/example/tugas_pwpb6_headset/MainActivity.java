package com.example.tugas_pwpb6_headset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeadset;
    private ArrayList<Headset> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeadset = findViewById(R.id.rv_headset);
        rvHeadset.setHasFixedSize(true);

        list.addAll(DataHeadset.getListData());
        showRecylerCardView();
    }
    private void showRecylerCardView(){
        rvHeadset.setLayoutManager(new LinearLayoutManager(this));
        CardViewHeadset cardViewHeadset = new CardViewHeadset(list);
        rvHeadset.setAdapter(cardViewHeadset);
    }
}
