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
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.maps.model.Marker;

public class BlockerMenuActivity extends AppCompatActivity {

    GridView grid;
    String[] web = {
            "Google",
            "Github",
            "Instagram",
            "Facebook",
            "Flickr"
    } ;
    int[] imageId = {
            R.drawable.icons8_car,
            R.drawable.icons8_ellipse,
            R.drawable.icons8_evergreen,
            R.drawable.icons8_penguin,
            R.drawable.icons8_vlc

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocker_menu);

        CustomGrid adapter = new CustomGrid(BlockerMenuActivity.this, web, imageId);
        grid=(GridView)findViewById(R.id.blockergrid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(BlockerMenuActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                //TODO: Create a new marker and send it to the server
                
            }
        });

    }
}


