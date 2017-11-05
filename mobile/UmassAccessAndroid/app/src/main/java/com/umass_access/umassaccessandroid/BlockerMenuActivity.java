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
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.model.Marker;

public class BlockerMenuActivity extends AppCompatActivity {

    GridView grid;
    static String[] web = {
            "Ambulence",
            "Down Power Line",
            "Broken Power Door",
            "Car Accident",
            "Car Blockage",
            "Construction",
            "Dead Animal",
            "Fallen Branches",
            "Firetruck",
            "Flooded Area",
            "Closed Path",
            "PotHole"
    };
    static int[] imageId = {
            R.drawable.ambulance,
            R.drawable.brokenpowerline,
            R.drawable.brokenwheelchairdoor,
            R.drawable.caraccident,
            R.drawable.carwalkwayblockage,
            R.drawable.constructionblockage,
            R.drawable.deadanimal,
            R.drawable.fallentree,
            R.drawable.firetruck,
            R.drawable.floodedarea,
            R.drawable.pathclosed,
            R.drawable.potholelargehole
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
                /*
                Intent markerintent = new Intent(BlockerMenuActivity.this, MapsActivity.class);
                markerintent.putExtra("intVariableName", position);
                startActivity(markerintent);
                */
                Intent resultIntent = new Intent();
                // TODO Add extras or a data URI to this intent as appropriate.
                resultIntent.putExtra("result", position);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }


}


