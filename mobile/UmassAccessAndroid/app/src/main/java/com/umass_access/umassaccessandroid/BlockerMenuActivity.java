package com.umass_access.umassaccessandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class BlockerMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocker_menu);

        GridView blockergrid = (GridView) findViewById(R.id.blockergrid);
        blockergrid.setAdapter(new ImageAdapter(this));

        blockergrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(BlockerMenuActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}


