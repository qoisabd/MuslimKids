package com.android.muslimkids;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Objects;


public class SettingList extends AppCompatActivity {

    CheckBox checkBox;
    RelativeLayout about;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_setting);

        checkBox = findViewById(R.id.checkbox);
        about = findViewById(R.id.about);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutDialog();
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

               }
        });
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(SettingList.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favorit) {

            startActivity(new Intent(this, FavoriteList.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem trash = menu.findItem(R.id.trash);
        MenuItem setting = menu.findItem(R.id.action_settings);
        if (trash != null) {
            trash.setVisible(false);
        }

        if (setting != null) {
            setting.setVisible(true);
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void aboutDialog(){
        dialog = new Dialog(SettingList.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.about_dialog);
        dialog.setCanceledOnTouchOutside(true);
        Button textView = dialog.findViewById(R.id.ok);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        Objects.requireNonNull(dialog.getWindow()).setLayout((6 * width) / 7, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }
}
