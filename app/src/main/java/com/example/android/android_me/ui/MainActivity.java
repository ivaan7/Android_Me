package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    public static final String HEAD_INDEX_KEY = "com.example.android.android_me.ui.head.index.key";
    public static final String BODY_INDEX_KEY = "com.example.android.android_me.ui.body.index.key";
    public static final String LEG_INDEX_KEY = "com.example.android.android_me.ui.leg.index.key";
    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(MainActivity.this, "Poition clicked " + position, Toast.LENGTH_SHORT).show();
        int bodyPart = position / 12;
        int listIndex = position - 12 * bodyPart;

        switch (bodyPart) {
            case 0:
                headIndex = listIndex;
                break;
            case 1:
                bodyIndex = listIndex;
                break;
            case 2:
                legIndex = listIndex;
                break;
            default:
                break;
        }

        Button bNext = (Button) findViewById(R.id.bNext);

        Bundle bundle = new Bundle();
        bundle.putInt(HEAD_INDEX_KEY, headIndex);
        bundle.putInt(BODY_INDEX_KEY, bodyIndex);
        bundle.putInt(LEG_INDEX_KEY, legIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(bundle);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }

}
