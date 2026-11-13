MainActivity.ja
package com.asil.gamebooster;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.content.res.ColorStateList;
import android.content.Intent;
import android.content.pm.PackageManager;

public class MainActivity extends Activity {

    private LinearLayout layout;

    private int blue = Color.rgb(25, 105, 180);
    private int background = Color.rgb(12, 16, 30);

    private TextView addText(String text, int size) {
        TextView v = new TextView(this);
        v.setText(text);
        v.setTextSize(size);
        v.setTextColor(Color.WHITE);
        v.setGravity(Gravity.CENTER);
        v.setPadding(12, 18, 12, 18);
        return v;
    }

    private void addButton(String text, Runnable action) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextColor(Color.WHITE);
        b.setBackgroundTintList(
            ColorStateList.valueOf(blue)
        );

        b.setOnClickListener(view -> action.run());

        layout.addView(b);
    }

    private void showMessage(String message) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        ).show();
    }

    private void showDeviceInfo() {
        String info =
            "اسم الجهاز: " + android.os.Build.MODEL +
            "\nإصدار Android: " +
            android.os.Build.VERSION.RELEASE;

        new android.app.AlertDialog.Builder(this)
            .setTitle("معلومات الجهاز")
            .setMessage(info)
            .setPositiveButton("موافق", null)
            .show();
    }

    private void openPUBG() {
        String packageName = "com.tencent.ig";

        Intent intent =
            getPackageManager().getLaunchIntentForPackage(packageName);

        if (intent != null) {
            startActivity(intent);
        } else {
            showMessage("لم يتم العثور على PUBG Mobile");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(24, 24, 24, 24);
        layout.setBackgroundColor(background);

        layout.addView(addText("ASIL GAME BOOSTER", 27));
        layout.addView(addText("ULTIMATE GAMING MODE", 16));
        layout.addView(addText("PUBG MOBILE", 23));

        addButton("START GAME MODE", () -> {
            showMessage("تم تفعيل وضع اللعب داخل التطبيق");
        });

        addButton("OPEN PUBG MOBILE", () -> {
            openPUBG();
        });

        addButton("DEVICE INFORMATION", () -> {
            showDeviceInfo();
        });

        addButton("NETWORK MONITOR", () -> {
            showMessage("مراقبة الشبكة غير مفعلة في هذه النسخة");
        });

        layout.addView(addText("Made by ASIL", 14));

        setContentView(layout);
    }
}

vaMainActivity.java
