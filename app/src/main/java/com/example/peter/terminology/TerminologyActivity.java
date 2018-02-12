package com.example.peter.terminology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;


public class TerminologyActivity extends AppCompatActivity implements Serializable, TerminologyFragment
        .CallbackTerminology {
    public static String key = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dental_terminology);

        getSupportFragmentManager().beginTransaction().add(R.id.activity_dental_terminology, new TerminologyFragment()).commit();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onItemSelecteddd(int position) {
        if (position == 0 && MainActivity.choice == 1) {
            // open DentalSuffix
//            startActivity(new Intent(TerminologyActivity.this,DentalSuffixActivity.class));
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_dental_terminology, new DentalSuffixFragment()).commit();
        } else if (position == 1 && MainActivity.choice == 1) {
            // open DentalAbbreviation
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_dental_terminology, new DentalAbbreviationFragment()).commit();

        } else if (position == 0 && MainActivity.choice == 2) {
            // open non dental suffix
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_dental_terminology, new NonDentalSuffixFragment()).commit();

        } else if (position == 1 && MainActivity.choice == 2) {
            // open non dental Abbreviation
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_dental_terminology, new NonDentalAbbreviationFragment()).commit();

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.hmBtn) {
            startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}
