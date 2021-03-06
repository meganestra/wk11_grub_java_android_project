package com.example.user.grub;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 19/08/2016.
 */
public class AddEntryActivity extends AppCompatActivity {

    TextView mHeaderAdd;
    EditText mDescriptionInput;
    EditText mDateConsumed;
    EditText mQuantity;
    EditText mMeasure;
    EditText mCalories;
    EditText mMealType;
    Button mAddEntry;
    Typeface myCustomFont;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/CutiveMono-Regular.ttf");

        createDatabase();

        mHeaderAdd = (TextView)findViewById(R.id.add_header);
        mHeaderAdd.setTypeface(myCustomFont);
        mDescriptionInput = (EditText)findViewById(R.id.description_input);
        mDescriptionInput.setTypeface(myCustomFont);
        mDateConsumed = (EditText)findViewById(R.id.date_consumed_input);
        mDateConsumed.setTypeface(myCustomFont);
        mQuantity = (EditText)findViewById(R.id.quantity_input);
        mQuantity.setTypeface(myCustomFont);
        mMeasure = (EditText)findViewById(R.id.measure_input);
        mMeasure.setTypeface(myCustomFont);
        mCalories = (EditText)findViewById(R.id.calories_input);
        mCalories.setTypeface(myCustomFont);
        mMealType = (EditText)findViewById(R.id.meal_type_input);
        mMealType.setTypeface(myCustomFont);
        mAddEntry = (Button)findViewById(R.id.add_entry_button);
        mAddEntry.setTypeface(myCustomFont);


        mAddEntry.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                insertIntoDB();
            }
        });
    }

    protected void createDatabase(){
        db = openOrCreateDatabase("FoodDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS food(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, description VARCHAR, dateConsumed VARCHAR, quantity INT4, measure VARCHAR, calories INT4, meal_type VARCHAR);");
    }

    protected void insertIntoDB() {

        String descriptionToSave = mDescriptionInput.getText().toString();
        String dateConsumedToSave = mDateConsumed.getText().toString();
        String quantityToSave = mQuantity.getText().toString();
        String measureToSave = mMeasure.getText().toString();
        String caloriesToSave = mCalories.getText().toString();
        String mealTypeToSave = mMealType.getText().toString();

        String query = "INSERT INTO food (description, dateConsumed, quantity, measure, calories, meal_type) VALUES ('"+descriptionToSave+"', '"+dateConsumedToSave+"', '"+quantityToSave+"', '"+measureToSave+"', '"+caloriesToSave+"', '"+mealTypeToSave+"');";

        db.execSQL(query);
        Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_LONG).show();
    }
}
