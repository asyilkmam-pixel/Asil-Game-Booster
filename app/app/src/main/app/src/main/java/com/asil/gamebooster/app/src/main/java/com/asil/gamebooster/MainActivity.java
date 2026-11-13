
package com.asil.gamebooster;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    LinearLayout layout;

    TextView addText(String text, int size) {
        TextView v = new TextView(this);
        v.setText(text);
        v.setTextSize(size);
        v.setTextColor(Color.WHITE);
        v.setGravity(Gravity.CENTER);
        v.setPadding(12, 18, 12, 18);
        return v;
    }

    void addButton(String text) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextColor(Color.WHITE);
        b.setBackgroundTintList(
            android.content.res.ColorStateList.valueOf(
                Color.rgb(25, 105, 180)
            )
        );
        layout.addView(b);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(24, 24, 24, 24);
        layout.setBackgroundColor(Color.rgb(12, 16, 30));

        layout.addView(addText("ASIL GAME BOOSTER", 27));
        layout.addView(addText("ULTIMATE GAMING MODE", 15));
        layout.addView(addText("PUBG MOBILE", 22));

        addButton("START GAME MODE");
        addButton("NETWORK MONITOR");
        addButton("DEVICE INFORMATION");

        layout.addView(addText(
            "Made by ASIL",
            14
        ));

        setContentView(layout);
    }
}
