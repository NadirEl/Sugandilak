package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class juego2 extends AppCompatActivity {
    private static final String IMAGEVIEW_TAG = "Imagen";
    private ImageView img_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego2);

        img_1 = findViewById(R.id.img_1);
        img_1.setTag(IMAGEVIEW_TAG);

        img_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                    ClipData dragData = new ClipData(
                            (CharSequence) v.getTag(),
                            new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                            item);

                    View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img_1);

                    v.startDragAndDrop(dragData, myShadow, null, 0);

                    return true;
                }
                return false;
            }
        });
        LinearLayout containerLayout = findViewById(R.id.lenea1);
        containerLayout.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                switch (action) {
                    case DragEvent.ACTION_DROP:
                        return true;

                    default:
                        return true;
                }
            }
        });
    }
}
