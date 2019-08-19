package com.example.shopaholics;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TempCart extends AppCompatActivity {

    DBHelper dbCart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ListView listView = (ListView) findViewById(R.id.cartlistview);
        dbCart = new DBHelper(this);

        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = dbCart.getListContents();

        if (cursor.getCount() == 0) {
            Toast.makeText(TempCart.this,"NO ITEMS IN DATABASE", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {
                list.add(cursor.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
