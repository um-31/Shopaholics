package com.example.shopaholics;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CheckOutActivity extends AppCompatActivity {

    EditText checkoutfname,checkoutlname,checkoutadd,checkoutste,checkoutcty,checkoutpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        checkoutfname = (EditText) findViewById(R.id.checkoutfirstname);
        checkoutlname = (EditText) findViewById(R.id.checkoutlastname);
        checkoutadd = (EditText) findViewById(R.id.checkoutaddress);
        checkoutste = (EditText) findViewById(R.id.checkoutState);
        checkoutcty = (EditText) findViewById(R.id.checkoutCity);
        checkoutpin = (EditText) findViewById(R.id.checkoutpincode);

    }
    public void onPayment(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.arshdeep.store", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (checkoutfname.getText().toString().length() == 0) {
            checkoutfname.setError("Compulsory Field");
        } else if (checkoutlname.getText().toString().length() == 0) {
            checkoutlname.setError("Compulsory Field");
        } else if (checkoutadd.getText().toString().length() == 0) {
            checkoutadd.setError("Compulsory Field");
        } else if (checkoutste.getText().toString().length() == 0) {
            checkoutste.setError("Compulsory Field");
        } else if (checkoutcty.getText().toString().length() == 0) {
            checkoutcty.setError("Compulsory Field");
        } else if (checkoutpin.getText().toString().length() == 0) {
            checkoutpin.setError("Compulsory Field");
        } else {

            DBHelper dbHelper = new DBHelper(this);
            SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("FRISTNAME",checkoutfname.getText().toString());
            values.put("LASTNAME",checkoutlname.getText().toString());
            values.put("ADDRESS",checkoutadd.getText().toString());
            values.put("STATE",checkoutste.getText().toString());
            values.put("CITY",checkoutcty.getText().toString());
            values.put("PIN",checkoutpin.getText().toString());
            editor.putString("ADDRESS", checkoutadd.getText().toString());

            sqLiteDatabase.insert("USERINFO",null,values);
            Toast.makeText(this,"DATA ADDED Successful", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
            finish();
            editor.commit();

            startActivity(new Intent(CheckOutActivity.this, PaymentActivity.class));
            finish();
        }
    }
}
