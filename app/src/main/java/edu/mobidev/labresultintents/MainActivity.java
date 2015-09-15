package edu.mobidev.labresultintents;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    static final String EXTRA_GENDER = "gender";
    static final String EXTRA_AGE = "age";
    static final int REQUEST_GENDER = 0;
    static final int REQUEST_AGE = 1;

    Button buttonAge;
    Button buttonGender;
    TextView tvAge;
    TextView tvGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAge = (Button) findViewById(R.id.button_age);
        buttonGender = (Button) findViewById(R.id.button_gender);
        tvAge = (TextView) findViewById(R.id.tv_age);
        tvGender = (TextView) findViewById(R.id.tv_gender);

        buttonAge.setOnClickListener(enterAge);
        buttonGender.setOnClickListener(enterGender);
    }

    View.OnClickListener enterAge = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent();
            i.setClass(getBaseContext(), AgeRequestActivity.class);
            startActivityForResult(i, REQUEST_AGE);
        }
    };

    View.OnClickListener enterGender = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent();
            i.setClass(getBaseContext(), GenderRequestActivity.class);
            startActivityForResult(i, REQUEST_GENDER);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_AGE){
            if(resultCode == RESULT_OK){
                int age = getIntent().getExtras().getInt(EXTRA_AGE);
                tvAge.setText("Age : " + age);
            }
        }else if(resultCode == REQUEST_GENDER){
            if(resultCode == RESULT_OK){
                String gender = getIntent().getExtras().getString(EXTRA_GENDER);
                tvAge.setText("Gender : " + gender);
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(getBaseContext(), "Invalid age, please grow older.", Toast.LENGTH_LONG).show();
            }
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
}
