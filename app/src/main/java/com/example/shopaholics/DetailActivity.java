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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    ImageView detailimage;
    TextView detailproductname,detailproductprice,detailproductdesc;
    EditText detailquantity;

    int image;
    String name,desc,quantity;
    String price;
    static int total;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        detailimage = (ImageView) findViewById(R.id.detailimage);
        detailproductname = (TextView) findViewById(R.id.detailproductname);
        detailproductprice = (TextView) findViewById(R.id.detailproductprice);
        detailproductdesc = (TextView) findViewById(R.id.detailsdescription);
        detailquantity = (EditText)findViewById(R.id.detailquantity);


            Intent intent = this.getIntent();
            image = intent.getExtras().getInt("Key_Image");
            name = intent.getExtras().getString("Key_Name");
            price = intent.getExtras().getString("Key_Price");
            desc = intent.getExtras().getString("Key_Desc");

            detailimage.setImageResource(image);
            detailproductname.setText(name);
            detailproductprice.setText("$ "+price);
            detailproductdesc.setText(desc);

        //total = Integer.parseInt(quantity)*Integer.parseInt(price);
        }

    public void onCart(View view) {

        DBHelper dbCart = new DBHelper(this);
        SQLiteDatabase sqLiteDatabase = dbCart.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        quantity = detailquantity.getText().toString();
        contentValues.put("NAME",name);
        contentValues.put("PRICE",price);
        contentValues.put("QUANTITY", Integer.parseInt(detailquantity.getText().toString()));
        total = total +(Integer.parseInt(price)* Integer.parseInt(detailquantity.getText().toString()));
        //contentValues.put("TOTAL",total);

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.arshdeep.store", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("totalamount", String.valueOf(total));
        editor.commit();

        sqLiteDatabase.insert("tCART",null,contentValues);
        Toast.makeText(this,"TOTAL :"+total, Toast.LENGTH_LONG).show();
        Toast.makeText(this,name+"ADDED TO CART", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.close();
        finish();
    }


/*
    static ArrayList<CartModel> cart = new ArrayList<>();
    CartModel cartModel = null;
    public void onAddToCart(View view) {
        cartModel = new CartModel();
        cartModel.setImage(image);
        cartModel.setName(name);
        cart.add(cartModel);

       openDetailActivity(image,name);
    }
    private void openDetailActivity(int image,String name) {
        Intent intent = new Intent(this,CartActivity.class);
        intent.putExtra("Key_Cart_Image",image);
        intent.putExtra("Key_Cart_Name",name);

        this.startActivity(intent);

        Toast.makeText(this,name+"Product Added",Toast.LENGTH_SHORT).show();


        //context.startActivity(intent);
    }
    */





}
