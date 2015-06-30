package com.teamdroid.algoninja;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    RadioButton easyRadio, mediumRadio, difficultRadio, radioButton;
    RadioGroup radioGroup;
    Button startTrainingButton;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //easyRadio = (RadioButton)findViewById(R.id.easyLevelRadio);
        //mediumRadio = (RadioButton)findViewById(R.id.mediumLevelRadio);
        //difficultRadio = (RadioButton)findViewById(R.id.difficultLevelRadio);
        toolbar = (Toolbar) findViewById(R.id.appBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        startTrainingButton = (Button) findViewById(R.id.startTrainingButton);
        startTrainingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlgoListActivity.class);
                startActivity(intent);
            }
        });
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int selectID = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectID);
        radioButton.setTextColor(getResources().getColor(R.color.primaryColor));
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton.setTextColor(getResources().getColor(R.color.textColor));
                radioButton = (RadioButton) findViewById(checkedId);
                radioButton.setTextColor(getResources().getColor(R.color.primaryColor));
                String text = radioButton.getText().toString();
                Toast.makeText(getApplicationContext(), "You selected " + text, Toast.LENGTH_SHORT).show();

            }
        });



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
