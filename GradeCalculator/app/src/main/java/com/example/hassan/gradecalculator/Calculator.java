package com.example.hassan.gradecalculator;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class Calculator extends ActionBarActivity {
    double grade = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        grade = getIntent().getExtras().getDouble("grade");
        TextView gradeDisplay = (TextView) findViewById(R.id.textView);
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.FLOOR);
        gradeDisplay.setText(df.format(grade) + "");
        TextView cuteDisplay = (TextView) findViewById(R.id.subtext);
        if(grade < 60) {
            gradeDisplay.setTextColor(Color.RED);
            cuteDisplay.setText("let's hope the curve is good, bro");
        } else if(grade < 70) {
            gradeDisplay.setTextColor(Color.BLUE);
            cuteDisplay.setText("well, at least you're not failing");
        } else if(grade < 80) {
            gradeDisplay.setTextColor(Color.YELLOW);
            cuteDisplay.setText("aww yeah, C's get degrees");
        } else if(grade < 90) {
            gradeDisplay.setTextColor(Color.CYAN);
            cuteDisplay.setText("put down the books nerd");
        } else if(grade >= 90) {
            gradeDisplay.setTextColor(Color.GREEN);
            cuteDisplay.setText("tbh, you probably don't need this app to tell you your grade");
        }
        gradeDisplay.setShadowLayer(1, 0, 0, Color.BLACK);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
