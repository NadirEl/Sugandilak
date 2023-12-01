package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2VidaDeSanValentin extends AppCompatActivity implements View.OnLongClickListener {

    private ImageView imas;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2_vida_de_san_valentin);

        imas = findViewById(R.id.idImagensiu);

        tv = findViewById(R.id.idtv1);

        imas.setOnLongClickListener(this);
        tv.setOnDragListener(drag);


    }

    @Override
    public boolean onLongClick(View v) {
        // Create a new ClipData.
        // This is done in two steps to provide clarity. The convenience method
        // ClipData.newPlainText() can create a plain text ClipData in one step.

        // Create a new ClipData.Item from the ImageView object's tag.
        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());

        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This creates a new ClipDescription object within the
        // ClipData and sets its MIME type to "text/plain".
        ClipData dragData = new ClipData(
                (CharSequence) v.getTag(),
                new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN },
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
        switch (dragEvent){
            case DragEvent.ACTION_DROP:

                    Resources res = getResources();
                    Drawable drawable = ResourcesCompat.getDrawable(res, R.drawable.berriotxoa1, null);
                    v.setBackground(drawable);






        }
        return true;
    };
}