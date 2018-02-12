package com.example.peter.terminology;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable, HomeFragment.Callback {
    static int choice;

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onItemSelected(int pos) {


        if (pos == 0) {
            choice = 1;
//            getSupportFragmentManager().beginTransaction().add(R.id.activity_dental_terminology,new TerminologyFragment()).commit();
            startActivity(new Intent(this, TerminologyActivity.class).putExtra("dental", pos));
        } else if (pos == 1) {
            choice = 2;
            startActivity(new Intent(this, TerminologyActivity.class).putExtra("dental", pos));
        } else if (pos == 2) {
            // to do
            getSupportFragmentManager().beginTransaction().replace(R.id.mainActivity, new CreditFragment()).commit();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.mainActivity, new HomeFragment()).commit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.hmBtn) {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainActivity, new HomeFragment()).commit();
        }
        return super.onOptionsItemSelected(item);
    }





}

