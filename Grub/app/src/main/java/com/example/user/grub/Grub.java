package com.example.user.grub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 19/08/2016.
 */
public class Grub extends AppCompatActivity {

    TextView mHeader;
    TextView mGoalHeader;
    TextView mGoalValue;
    TextView mRemainingHeader;
    TextView mRemainingValue;
    TextView mAskHeader;
    TextView mAddHeader;
    Button mAddButton;
    Button mAskButton;
    Diary mGrubDiary;
    Goal mGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeader = (TextView) findViewById(R.id.header);
        mGoalHeader = (TextView) findViewById(R.id.goal);
        mGoalValue = (TextView) findViewById(R.id.goal_value);
        mRemainingHeader = (TextView) findViewById(R.id.remaining);
        mRemainingValue = (TextView) findViewById(R.id.remaining_value);
        mAskHeader = (TextView) findViewById(R.id.ask);
        mAddHeader = (TextView) findViewById(R.id.add);
        mAddButton = (Button) findViewById(R.id.add_button);
        mAskButton = (Button) findViewById(R.id.ask_button);

        String goalString = SavedTextPreferences.getStoredText(this);
        mGoalValue.setText(goalString);
//        int goalInt = Integer.parseInt(goalString);
//        mGoal = new Goal(goalInt);
//        mGrubDiary = new Diary(mGoal);
//
//        mRemainingValue.setText(mGoal.calculateRemainingCalories(mGrubDiary, "22.08.2016"));

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Grub: ", "add button clicked");
                Intent intent = new Intent(Grub.this, AddEntryActivity.class);
                startActivity(intent);
            }
        });

        mAskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Grub home ask: ", "home ask button clicked");
                Intent intent = new Intent(Grub.this, AskActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        Intent intentDiary = new Intent(Grub.this, DiarySelectActivity.class);
        Intent intentAddGoal = new Intent(Grub.this, AddTargetActivity.class);

        switch (item.getItemId()) {

            case R.id.action_diary: startActivity(intentDiary);
                return true;

            case R.id.action_add_goal: startActivity(intentAddGoal);
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

}