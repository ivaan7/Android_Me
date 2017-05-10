package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        int headIndex = getIntent().getIntExtra(MainActivity.HEAD_INDEX_KEY,0);
        int bodyIndex =  getIntent().getIntExtra(MainActivity.BODY_INDEX_KEY,0);
        int legIndex =  getIntent().getIntExtra(MainActivity.LEG_INDEX_KEY,0);
        if (savedInstanceState == null) {
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setmImageIds(AndroidImageAssets.getHeads());
            headFragment.setmListIndex(headIndex);
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setmImageIds(AndroidImageAssets.getBodies());
            bodyFragment.setmListIndex(bodyIndex);
            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setmImageIds(AndroidImageAssets.getLegs());
            legFragment.setmListIndex(legIndex);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .add(R.id.body_container, bodyFragment)
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }

    }
}
