package com.example.idan.persistingstate;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class SerialCalculator extends ActionBarActivity {

    private static final String COUNTER_STATE_KEY = "counter";
    TextView mDisplay;
    int counter = 0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ;
    boolean demoOn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_calculator);

        if (demoOn && savedInstanceState != null){
            counter = savedInstanceState.getInt(COUNTER_STATE_KEY);
        }

        mDisplay = (TextView)findViewById(R.id.display);
        mDisplay.setText(counter + "");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_serial_calculator, menu);
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

    public void inc(View view) {
        counter++;
        mDisplay.setText(counter + "");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(COUNTER_STATE_KEY, counter);
    }
}
