package com.example.shopaholics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListActivity extends AppCompatActivity {

    ListActivityModel listActivityModel = new ListActivityModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView) findViewById(R.id.itemlistview);
        CustomAdapter customAdapter = new CustomAdapter(ProductList.getArratList(), this);
        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {

        ArrayList<ListActivityModel> arrayList = new ArrayList<ListActivityModel>();
        Context context;
        LayoutInflater inflater;

        public CustomAdapter(ArrayList<ListActivityModel> arrayList, Context context) {
            this.arrayList = arrayList;
            this.context = context;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null) {
                convertView = inflater.inflate(R.layout.activity_custom_list_view,parent,false);

                ImageView productimage = (ImageView) convertView.findViewById(R.id.listviewimage);
                TextView productname = (TextView) convertView.findViewById(R.id.listviewproductname);
                TextView productprice = (TextView) convertView.findViewById(R.id.listviewprice);


                final int tempimage = arrayList.get(position).getProductimage();
                final String tempproductname = arrayList.get(position).getProductname();
                final String tempproductprice  = arrayList.get(position).getPriductprice();
                final String tempproductdesc = arrayList.get(position).getProductdesc();

                productimage.setImageResource(tempimage);
                productname.setText(tempproductname);
                productprice.setText("$ "+tempproductprice);

                //
                listActivityModel.setProductimage(tempimage);
                listActivityModel.setProductname(tempproductname);
                //

                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openDetailActivity(tempimage,tempproductname,tempproductprice,tempproductdesc);
                    }
                });

            }
            return convertView;
        }

        private void openDetailActivity(int image, String name, String price, String desc) {
            Intent intent = new Intent(context,DetailActivity.class);
            intent.putExtra("Key_Image",image);
            intent.putExtra("Key_Name",name);
            intent.putExtra("Key_Price",price);
            intent.putExtra("Key_Desc",desc);

            context.startActivity(intent);
        }
    }

}
