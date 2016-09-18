package com.mj.courseraprw3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class top_five extends AppCompatActivity {
    ArrayList<pets> myPetList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_five);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBarTopFive);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setData();

        mRecyclerView = (RecyclerView) findViewById(R.id.rcvMyCarrouselTopFive);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(myPetList);
        mRecyclerView.setAdapter(mAdapter);
    }

    void setData () {
        myPetList = new ArrayList<pets>();
        myPetList.add(new pets("Ramy",16, R.drawable.ram));
        myPetList.add(new pets("Rhiny",17, R.drawable.rhino));
        myPetList.add(new pets("Tiggy",18, R.drawable.tiger));
        myPetList.add(new pets("Turkky",19, R.drawable.turkey));
        myPetList.add(new pets("Zebry",20, R.drawable.zebra));
    }


}
