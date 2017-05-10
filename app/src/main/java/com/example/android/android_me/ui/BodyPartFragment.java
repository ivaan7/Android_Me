package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private final String LIST_INDEX_STATE = "com.example.android.android_me.ui.list.index.state";
    private final String IMAGE_IDS = "com.example.android.android_me.ui.image.ids.state";

    //Mandatory empty constructor for instantiating fragment
    public BodyPartFragment() {
    }

    private List<Integer> mImageIds;
    private int mListIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState!=null){
            mListIndex = savedInstanceState.getInt(LIST_INDEX_STATE);
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_IDS);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);
        if (mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mListIndex));
        } else {
            Log.i("IMAGE ID", "no selected image");
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListIndex < mImageIds.size()-1) {
                    mListIndex++;
                } else {
                    mListIndex = 0;
                }
                imageView.setImageResource(mImageIds.get(mListIndex));
            }
        });
        return rootView;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(LIST_INDEX_STATE, mListIndex);
        outState.putIntegerArrayList(IMAGE_IDS, (ArrayList<Integer>) mImageIds);
    }
}
