package com.mj.courseraprw3.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mj.courseraprw3.R;
import com.mj.courseraprw3.RecyclerItemClickListener;
import com.mj.courseraprw3.pets;
import com.mj.courseraprw3.Adapter.MyAdapter;

import java.util.ArrayList;



public class mainFragment extends Fragment {
    ArrayList<pets> myPetList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_main,container, false);

        setData();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rcvMyCarrousel);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addOnItemTouchListener( new RecyclerItemClickListener( getActivity(), new RecyclerItemClickListener.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {
                mCallback.sendItem(position);
            }
        }));

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(myPetList);
        mRecyclerView.setAdapter(mAdapter);

        return view;
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

    public void increaseRank (View v){
        pets tmp = new pets("",0,0);
        TextView myCardTextView = (TextView) v.findViewById(R.id.actvPetName);
        TextView myCTNLikes = (TextView) v.findViewById(R.id.actvLikes);
        tmp = myPetList.get(tmp.indexOf(myCardTextView.getText().toString(), myPetList));
        tmp.setLikes(tmp.getLikes()+1);
        myCTNLikes.setText(String.format("%d",tmp.getLikes()));
    }

    ItemClicked mCallback;

    public interface ItemClicked{
        public void sendItem(Integer element);
    }

    @Override
    public void  onAttach(Context context){
        super.onAttach(context);
        try{
            mCallback = (ItemClicked) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement TextClicked");
        }

    }

    public void someMethod(){
        mCallback.sendItem(1);
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }
}
