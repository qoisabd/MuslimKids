package com.android.muslimkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class FavoriteList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_favorite);
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(FavoriteList.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            startActivity(new Intent(this, SettingList.class));
        }

        if (id == R.id.trash) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem favorite = menu.findItem(R.id.action_favorit);

        if (favorite != null) {
            favorite.setVisible(true);
        }
        return super.onCreateOptionsMenu(menu);
    }
}
