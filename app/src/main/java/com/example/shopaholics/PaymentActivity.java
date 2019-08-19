package com.example.shopaholics;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {
    EditText cardnumber,cvvnumber,expirydate;
    TextView amount;

    int finalamount;

    Button card;
    Button cash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Button card = (Button) findViewById(R.id.cardbutton);

        cardnumber = (EditText) findViewById(R.id.cardno);
        cvvnumber = (EditText) findViewById(R.id.cvv);
        expirydate = (EditText) findViewById(R.id.expdate);
        amount = (TextView) findViewById(R.id.paymentamount);

        cardnumber.setVisibility(View.INVISIBLE);
        cvvnumber.setVisibility(View.INVISIBLE);
        expirydate.setVisibility(View.INVISIBLE);

    }
    public void onCard(View view) {
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
       //String query = "SELECT TOTAL FROM tcart";
        //Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        finalamount = 0;
        SharedPreferences sp = getSharedPreferences("com.example.arshdeep.store", Context.MODE_PRIVATE);

        amount.setText("AMOUNT : "+sp.getString("totalamount","Data Missing"));


        cardnumber.setVisibility(View.VISIBLE);
        cvvnumber.setVisibility(View.VISIBLE);
        expirydate.setVisibility(View.VISIBLE);
    }

    public void onFinal(View view) {
        if (cardnumber.getText().toString().length() == 0) {
            cardnumber.setError("Compulsory Field");
        } else if (cvvnumber.getText().toString().length() == 0) {
            cvvnumber.setError("Compulsory Field");
        } else if (expirydate.getText().toString().length() == 0) {
            expirydate.setError("Compulsory Field");
        } else {
            DBHelper dbHelper = new DBHelper(this);
            SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("CARDNO", cardnumber.getText().toString());

            sqLiteDatabase.insert("CARDDATA", null, values);
            sqLiteDatabase.close();
            finish();

            startActivity(new Intent(this, FinalActivity.class));
        }
    }
}
