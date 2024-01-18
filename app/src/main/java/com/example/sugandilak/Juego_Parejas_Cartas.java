package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.lang.reflect.Field;

public class Juego_Parejas_Cartas extends AppCompatActivity implements EasyFlipView.OnFlipAnimationListener {

    private EasyFlipView[] easyViews = new EasyFlipView[8];
    private EasyFlipView[] eayViews = new EasyFlipView[8];
    private EasyFlipView lastFlippedEasy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_parejas_cartas);

        for (int i = 0; i < 8; i++) {
            int easyId = getResources().getIdentifier("cambiar" + (i + 1), "id", getPackageName());
            int eayId = getResources().getIdentifier("vuelta" + (i + 1), "id", getPackageName());

            easyViews[i] = findViewById(easyId);
            eayViews[i] = findViewById(eayId);

            easyViews[i].setToHorizontalType();
            eayViews[i].setToHorizontalType();

            setFlipListener(easyViews[i], eayViews[i]);
        }
    }

    private void setFlipListener(EasyFlipView flipView1, EasyFlipView flipView2) {
        flipView1.setOnFlipListener(this);
        flipView2.setOnFlipListener(this);
    }

    @Override
    public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
        easyFlipView.flipTheView();

        if (easyFlipView == lastFlippedEasy) {
            EasyFlipView matchedEay = getMatchedEay(easyFlipView);

            if (areDrawablesEqual(easyFlipView.getForeground(), matchedEay.getForeground())) {
                showToast("¡Enhorabuena! Has volteado una pareja correcta");
                easyFlipView.setFlipEnabled(false);
                matchedEay.setFlipEnabled(false);
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        easyFlipView.flipTheView();
                        matchedEay.flipTheView();
                    }
                }, 1000);
            }

            lastFlippedEasy = null;
        } else {
            lastFlippedEasy = easyFlipView;
        }
    }

    private EasyFlipView getMatchedEay(EasyFlipView sourceEasyView) {
        for (int i = 0; i < 8; i++) {
            if (easyViews[i] == sourceEasyView) {
                return eayViews[i];
            }
        }
        return null;
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private boolean areDrawablesEqual(Drawable drawable1, Drawable drawable2) {
        // Compara las drawables basadas en los identificadores de recursos
        return getResIdFromDrawable(drawable1) == getResIdFromDrawable(drawable2);
    }

    private int getResIdFromDrawable(Drawable drawable) {
        // Obtiene el ID del recurso desde la drawable
        return drawable != null ? drawable.hashCode() : 0;
    }
}
