package com.mj.courseraprw3;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<pets> myPetList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);

        setData();

        mRecyclerView = (RecyclerView) findViewById(R.id.rcvMyCarrousel);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(myPetList);
        mRecyclerView.setAdapter(mAdapter);

    }


    public void increaseRank (View v){
        pets tmp = new pets("",0,0);
        TextView myCardTextView = (TextView) findViewById(R.id.actvPetName);
        TextView myCTNLikes = (TextView) findViewById(R.id.actvLikes);
        tmp = myPetList.get(tmp.indexOf(myCardTextView.getText().toString(), myPetList));
        tmp.setLikes(tmp.getLikes()+1);
        myCTNLikes.setText(String.format("%d",tmp.getLikes()));
    }

    public void showTopFive(View view){
        Intent myIntent = new Intent(this, top_five.class);
        startActivity(myIntent);
    }

    void setData () {
        myPetList = new ArrayList<>();

        myPetList.add(new pets("Beary",1, R.drawable.bear));
        myPetList.add(new pets("Beavery",2, R.drawable.beaver));
        myPetList.add(new pets("Caty",3, R.drawable.cat));
        myPetList.add(new pets("Cowy",4, R.drawable.cow));
        myPetList.add(new pets("Doggy",5, R.drawable.dog));
        myPetList.add(new pets("Elephanty",6, R.drawable.elephant));
        myPetList.add(new pets("Goaty",7, R.drawable.goat));
        myPetList.add(new pets("Horsy",8, R.drawable.horse));
        myPetList.add(new pets("Jiraffy",9, R.drawable.jiraff));
        myPetList.add(new pets("Lamby",10, R.drawable.lamb));
        myPetList.add(new pets("Monkey",11, R.drawable.monkey));
        myPetList.add(new pets("Moosy",12, R.drawable.moose));
        myPetList.add(new pets("Owly",13, R.drawable.owl));
        myPetList.add(new pets("Pandy",14, R.drawable.panda));
        myPetList.add(new pets("Piggy",15, R.drawable.pig));
        myPetList.add(new pets("Ramy",16, R.drawable.ram));
        myPetList.add(new pets("Rhiny",17, R.drawable.rhino));
        myPetList.add(new pets("Tiggy",18, R.drawable.tiger));
        myPetList.add(new pets("Turkky",19, R.drawable.turkey));
        myPetList.add(new pets("Zebry",20, R.drawable.zebra));
    }


}
