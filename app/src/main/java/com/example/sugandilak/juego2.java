package com.example.sugandilak;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class juego2 extends AppCompatActivity implements View.OnLongClickListener {
    //private float x, y;
   // private float dx, dy;
    TextView idtv1;
    ImageView berriotxoa1;

   /* @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            x = event.getX();
            y = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            dx = event.getX() - x;
            dy = event.getY() - y;
            view.setX(view.getX() + dx);
            view.setY(view.getY() + dy);
            x = event.getX();
            y = event.getY();
        }

        return true;
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego2);

        // Set onTouchListener for each ImageView
        berriotxoa1=  findViewById(R.id.berriotxoa1);
        idtv1 = findViewById(R.id.idtv1);
        idtv1.setOnDragListener(drag);
        berriotxoa1.setOnLongClickListener(this);
    }
        @Override
        public boolean onLongClick (View v){
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.

            // Create a new ClipData.Item from the ImageView object's tag.
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());

            ClipData dragData = new ClipData(
                    (CharSequence) v.getTag(),
                    new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                    item);

            // Instantiate the drag shadow builder.
            View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);

            // Start the drag.
            v.startDragAndDrop(dragData,  // The data to be dragged
                    myShadow,  // The drag shadow builder
                    null,      // No need to use local data
                    0          // Flags (not currently used, set to 0)
            );

            // Indicate that the long-click was handled.
            return true;
        }

        View.OnDragListener drag = (v, event) -> {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DROP:

                        Resources res = getResources();
                        Drawable drawable = ResourcesCompat.getDrawable(res, R.drawable.berriotxoa1, null);
                        v.setBackground(drawable);

            }
            return true;
        };


}

