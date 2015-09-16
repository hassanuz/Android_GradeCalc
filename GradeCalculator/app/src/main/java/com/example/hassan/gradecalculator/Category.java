package com.example.hassan.gradecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class Category extends Activity {
    private ArrayList<EditText> weights;
    private ArrayList<EditText> scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        weights = new ArrayList<EditText>();
        scores = new ArrayList<EditText>();

        Bundle extras = getIntent().getExtras();
        int totalCategories = extras.getInt("Category count");

        LinearLayout categories = (LinearLayout) findViewById(R.id.categories2);
        categories.setGravity(Gravity.CENTER);
        for(int i = 1; i <= totalCategories; i++) {
            LinearLayout row = new LinearLayout(this);
            row.setGravity(Gravity.CENTER);
            row.setOrientation(LinearLayout.HORIZONTAL);
            TextView title = new TextView(this);
            String text = "Category " + i + ": ";
            title.setText((CharSequence) text);
            row.addView(title);

            TextView title2 = new TextView(this);
            String weight_title = " Weight: ";
            title2.setText((CharSequence) weight_title);
            row.addView(title2);
            EditText weight = new EditText(this);
            weight.setGravity(Gravity.CENTER);
            weight.setEms(3);
            weight.setInputType(InputType.TYPE_CLASS_NUMBER  | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
            weights.add(weight);

            row.addView(weight);

            TextView title3 = new TextView(this);
            String score_title = " Score: ";
            title3.setText((CharSequence) score_title);
            row.addView(title3);
            EditText score = new EditText(this);
            score.setGravity(Gravity.CENTER);
            score.setEms(3);
            score.setInputType(InputType.TYPE_CLASS_NUMBER  | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
            row.addView(score);
            scores.add(score);

            categories.addView(row);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void calculate(View view) {
        Intent jump = new Intent(this, Calculator.class);
        double grade = 0;
        for(int i = 0; i < weights.size(); i++) {
            if(!weights.get(i).getText().toString().isEmpty() && !scores.get(i).getText().toString().isEmpty())
            grade += ((Double.parseDouble(weights.get(i).getText().toString()))/100.0) *
                    Double.parseDouble(scores.get(i).getText().toString());
        }

        jump.putExtra("grade", grade);
        startActivity(jump);
    }
}
