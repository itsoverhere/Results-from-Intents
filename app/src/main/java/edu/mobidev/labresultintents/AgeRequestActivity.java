package edu.mobidev.labresultintents;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AgeRequestActivity extends ActionBarActivity {

    EditText etAge;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_request);

        etAge = (EditText) findViewById(R.id.et_gender);
        buttonSubmit = (Button) findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(submit);
    }

    View.OnClickListener submit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // get the result from etAge
            // convert it into an int
            int age = Integer.parseInt(etAge.getText().toString());

            // If the user is less than 18 years old, let's inform her/him to grow older
            if(age < 18) {
                setResult(RESULT_CANCELED);
            }else{
                Intent result = new Intent();
                result.putExtra(MainActivity.EXTRA_AGE, age);
                setResult(RESULT_OK, result);
            }

            finish();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_age_request, menu);
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
