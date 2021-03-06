package com.example.user.grub;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 19/08/2016.
 */
public class AddTargetActivity extends AppCompatActivity {

    TextView mGoalHeader;
    EditText mGoalInput;
    Button mGoalButton;
    Typeface myCustomFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_target);

        myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/CutiveMono-Regular.ttf");

        mGoalHeader = (TextView) findViewById(R.id.headerGoal);
        mGoalHeader.setTypeface(myCustomFont);
        mGoalInput = (EditText) findViewById(R.id.editGoal);
        mGoalInput.setTypeface(myCustomFont);
        mGoalButton = (Button) findViewById(R.id.goalButton);
        mGoalButton.setTypeface(myCustomFont);

        mGoalButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("Grub: ", "clicked goal button");

                String inputToSave = mGoalInput.getText().toString();

                Log.d("Grub: ", inputToSave);

                Context context = view.getContext();
                SavedTextPreferences.setStoredText(context, inputToSave);
                Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_LONG).show();


            }
        });
    }
}