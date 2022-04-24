/*
Name: Adam Strahan
Student Number: C00216499
Date: April 2022
File: Java file for the Indoor Maps
 */
package com.example.itcarlowmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class IndoorMapActivity extends AppCompatActivity {

    private ImageView image;
    private ScaleGestureDetector scaleGestureDetector;
    private float FACTOR = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor_map);

        // Create a spinner for the dropdown list of building maps
        Spinner mapList = (Spinner) findViewById(R.id.mapList);
        image = findViewById(R.id.image);

        // Create a gesture detector for the zoom functionality
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        // Creates the string array adapter for the list of maps
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(IndoorMapActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.list));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mapList.setAdapter(myAdapter);

        // Assign the maps to the drop down list
        mapList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        image.setImageResource(R.drawable.campus);
                        break;
                    case 1:
                        image.setImageResource(R.drawable.nore0);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.nore1);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.burrin0);
                        break;
                    case 4:
                        image.setImageResource(R.drawable.burrin1);
                        break;
                    case 5:
                        image.setImageResource(R.drawable.lrc0);
                        break;
                    case 6:
                        image.setImageResource(R.drawable.lrc1);
                        break;
                    case 7:
                        image.setImageResource(R.drawable.lrc2);
                        break;
                    case 8:
                        image.setImageResource(R.drawable.csb0);
                        break;
                    case 9:
                        image.setImageResource(R.drawable.csb1);
                        break;
                    case 10:
                        image.setImageResource(R.drawable.barrow0);
                        break;
                    case 11:
                        image.setImageResource(R.drawable.barrow1);
                        break;
                    case 12:
                        image.setImageResource(R.drawable.haughton0);
                        break;
                    case 13:
                        image.setImageResource(R.drawable.haughton1);
                        break;
                    case 14:
                        image.setImageResource(R.drawable.dargan0);
                        break;
                    case 15:
                        image.setImageResource(R.drawable.dargan1);
                        break;
                    case 16:
                        image.setImageResource(R.drawable.dargan2);
                        break;
                    case 17:
                        image.setImageResource(R.drawable.eng0);
                        break;
                    case 18:
                        image.setImageResource(R.drawable.eng1);
                        break;
                    case 19:
                        image.setImageResource(R.drawable.kill);
                        break;
                    case 20:
                        image.setImageResource(R.drawable.aero);
                        break;
                    case 21:
                        image.setImageResource(R.drawable.gaa0);
                        break;
                    case 22:
                        image.setImageResource(R.drawable.gaa1);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    // Zoom functionality
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            FACTOR *= detector.getScaleFactor();
            FACTOR = Math.max(0.1f, Math.min(FACTOR, 10.0f));
            image.setScaleX(FACTOR);
            image.setScaleY(FACTOR);
            return true;
        }
    }
}