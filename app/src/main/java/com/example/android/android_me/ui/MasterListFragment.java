package com.example.android.android_me.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;


public class MasterListFragment extends Fragment {

    OnImageClickListener onImageClickCallback;

    //define interface for communicating between fragments through host activity
    public interface OnImageClickListener {
        void onImageSelected(int position);
    }

    public MasterListFragment() {
        // Required empty public constructor
    }

    //check if callback is implemented by host activity, if not throw clascastexception
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onImageClickCallback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement listener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        // Get a reference to the GridView in the fragment_master_list xml layout file
        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        //whenever item is selected notify callback and give him a position of selected image
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onImageClickCallback.onImageSelected(i);
            }
        });

        // Create the adapter
        // This adapter takes in the context and an ArrayList of ALL the image resources to display
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        // Set the adapter on the GridView
        gridView.setAdapter(mAdapter);
        // Return the root view
        return rootView;
    }

}
