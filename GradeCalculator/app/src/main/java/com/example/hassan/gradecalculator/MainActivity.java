package com.example.hassan.gradecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;
import android.text.TextWatcher;
import android.text.Editable;


public class MainActivity extends Activity {



    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3)
        {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            Button btn = (Button) findViewById(R.id.button);

            btn.setClickable(true);

        }
    };

    private int totalCategories;
    private EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setClickable(false);

        editText1 = (EditText) findViewById(R.id.num);
        editText1.addTextChangedListener(textWatcher);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Button btn = (Button) findViewById(R.id.button);
        btn.setClickable(true);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayCategories(View view) {
        EditText num = (EditText) findViewById(R.id.num);
        Button btn = (Button) findViewById(R.id.button);
        totalCategories = Integer.parseInt(num.getText().toString());
        btn.setEnabled(true);
        btn.setClickable(true);
        if(totalCategories > 0){
            Intent jump = new Intent(this, Category.class);
            jump.putExtra("Category count", totalCategories);
            startActivity(jump);
        }
    }
}
