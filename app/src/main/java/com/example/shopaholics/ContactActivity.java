package com.example.shopaholics;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }
    public void onCall(View view) {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ContactActivity.this,new String[] {Manifest.permission.CALL_PHONE},1);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1234567890"));
            startActivity(intent);
        }
    }
    public void onEmail(View view) {

    }
    public void onSms(View view) {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ContactActivity.this,new String[] {Manifest.permission.SEND_SMS},1);;
        }
        else {
//            SmsManager smsManager = SmsManager.getDefault();
//////            smsManager.sendTextMessage("1234567890",null,"Hello",null);
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:1234567890"));
            intent.putExtra("SMS BODY","This is Default message");
            startActivity(intent);

        }
    }
}
