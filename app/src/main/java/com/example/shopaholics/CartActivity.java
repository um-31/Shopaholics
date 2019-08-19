package com.example.shopaholics;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    TextView cartname,cartprice;

    String name,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart);


        ListView listView = (ListView) findViewById(R.id.cartlistview);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);



    }
    class CustomAdapter extends BaseAdapter {

        ArrayList<CartModel> cart = new ArrayList<>();

        @Override
        public int getCount() {
            return cart.size();
        }

        @Override
        public Object getItem(int position) {
            return cart.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_cart,null);

            cartname = (TextView) convertView.findViewById(R.id.cartproductname);
            cartprice = (TextView) convertView.findViewById(R.id.cartproductprice);

            DBHelper dbCart = new DBHelper(CartActivity.this);
            SQLiteDatabase sqLiteDatabase = dbCart.getReadableDatabase();

            String query = "SELECT NAME,PRICE FROM tcart";
            Cursor cursor = sqLiteDatabase.rawQuery(query,null);
            name = null;
            price = null;

            ArrayList<CartModel> cartModels = new ArrayList<>();
            CartModel cartModel = new CartModel();

            boolean isSuccessful = false;
            if (!cursor.isAfterLast())
                isSuccessful = true;
            else{
                for (int i=0;i<cursor.getCount();i++) {
                    //name = cursor.getString(i);
                    cartModel.setName(cursor.getString(0));
                    cartModel.setPrice(cursor.getString(1));

                    cartModels.add(cartModel);
                }

            }
            return convertView;
        }

    }

}
