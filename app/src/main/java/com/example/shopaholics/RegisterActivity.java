package com.example.shopaholics;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText editname,editemail,editpassword,editconfirmpassword;
    DBHelper dbHelper = new DBHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editname = (EditText) findViewById(R.id.registername);
        editemail = (EditText) findViewById(R.id.registeremail);
        editpassword = (EditText) findViewById(R.id.registerpassword);
        editconfirmpassword = (EditText) findViewById(R.id.registerconfirmpassword);

    }
    public void onRegister(View view) {
            if (editname.getText().toString().length() == 0) {
                editname.setError("Name is Compulsory");
            }
            else if (editemail.getText().toString().length() == 0) {
                editemail.setError("Email is Compulsory");
            }
            else if (editpassword.getText().toString().length() == 0) {
                editpassword.setError("Email is Compulsory");
            }
            else if (!editconfirmpassword.getText().toString().matches(editpassword.getText().toString())) {
                editconfirmpassword.setError("Password must be same");
            }
            else {
                SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("NAME",editname.getText().toString());
                values.put("EMAIL",editemail.getText().toString());
                values.put("PASSWORD",editpassword.getText().toString());
                values.put("CONFIRMPASSWORD",editconfirmpassword.getText().toString());

                sqLiteDatabase.insert("USER",null,values);
                Toast.makeText(this,"Register Successful", Toast.LENGTH_SHORT).show();
                sqLiteDatabase.close();
                finish();
            }
    }
    public void onCancel(View view) {
        finish();
    }
}
