package com.example.shopaholics;

import java.util.ArrayList;

public class ProductList {
    public static ArrayList<ListActivityModel> getArratList() {
        ArrayList<ListActivityModel> arraylist = new ArrayList<>();
        ListActivityModel listActivityModel = null;


        listActivityModel = new ListActivityModel();
        listActivityModel.setProductimage(R.drawable.leather_watch);
        listActivityModel.setProductid(1);
        listActivityModel.setProductname("BLUE LEATHER WATCH");
        listActivityModel.setPriductprice("260");
        listActivityModel.setProductdesc("Sleek, self-winding and styled to tick on time with a built-in rotor, our Grant does the work for you. This timeless automatic gets refreshed for the season with a refined blue dial and rich leather strap. (No batteries required with a 40-hour power reserve.");
        arraylist.add(listActivityModel);


        listActivityModel = new ListActivityModel();
        listActivityModel.setProductid(2);
        listActivityModel.setProductimage(R.drawable.gold_watch);
        listActivityModel.setProductname("GOLD MIDSIZE WATCH");
        listActivityModel.setPriductprice("300");
        listActivityModel.setProductdesc("This 44mm Fenmore Midsize features a black satin dial with Roman numerals at the six- and 12-hour markers, multifunction movement and a gold-tone stainless steel bracelet. ");
        arraylist.add(listActivityModel);

        listActivityModel = new ListActivityModel();
        listActivityModel.setProductid(3);
        listActivityModel.setProductimage(R.drawable.black_watch);
        listActivityModel.setProductname("MECHANICAL BLACK WATCH");
        listActivityModel.setPriductprice("340");
        listActivityModel.setProductdesc("This 45mm Privateer Sport features a see-through dial, mechanical movement and a black stainless steel bracelet.");
        arraylist.add(listActivityModel);

        listActivityModel = new ListActivityModel();
        listActivityModel.setProductid(4);
        listActivityModel.setProductimage(R.drawable.smart_watch);
        listActivityModel.setProductname("GEN 3 SMARTWATCH");
        listActivityModel.setPriductprice("600");
        listActivityModel.setProductdesc("It's adventure time—our Explorist smartwatch keeps you connected wherever the road takes you. Customize the full-round display and three buttons with your handiest features, receive notifications (on the go) and automatically track your activity from the hiking trails to the gym.");
        arraylist.add(listActivityModel);

        listActivityModel = new ListActivityModel();
        listActivityModel.setProductid(5);
        listActivityModel.setProductimage(R.drawable.blue_watch);
        listActivityModel.setProductname("OCEAN BLUE WATCH");
        listActivityModel.setPriductprice("550");
        listActivityModel.setProductdesc("This 44x52mm Luther features an ocean blue dial with stick indices, three-hand movement and matching steel bracelet.");
        arraylist.add(listActivityModel);

        listActivityModel = new ListActivityModel();
        listActivityModel.setProductid(6);
        listActivityModel.setProductimage(R.drawable.watch_set);
        listActivityModel.setProductname("GOLD WATCH SET");
        listActivityModel.setPriductprice("1000");
        listActivityModel.setProductdesc("Designed in polished gold-tone stainless steel, this his and her duo gift set includes the best of both worlds—the everyday Flynn chronograph for him and the Modern Courier chronograph for her.");
        arraylist.add(listActivityModel);

        listActivityModel = new ListActivityModel();
        listActivityModel.setProductid(7);
        listActivityModel.setProductimage(R.drawable.two_tone_watch);
        listActivityModel.setProductname("TWO-TONE WATCH");
        listActivityModel.setPriductprice("800");
        listActivityModel.setProductdesc("This dive-inspired 42mm FB-01 features a blue sunray dial, three-hand date movement and a silver- and rose gold-tone stainless steel bracelet.");
        arraylist.add(listActivityModel);

        listActivityModel = new ListActivityModel();
        listActivityModel.setProductid(8);
        listActivityModel.setProductimage(R.drawable.brown_watch);
        listActivityModel.setProductname("DARK BROWN WATCH");
        listActivityModel.setPriductprice("750");
        listActivityModel.setProductdesc("Our classic Townsman twist watches have the look and feel of an automatic but the timekeeping accuracy of quartz. With an exposed dial and supple leather strap, this multifunction is battery operated");
        arraylist.add(listActivityModel);

        listActivityModel = new ListActivityModel();
        listActivityModel.setProductid(9);
        listActivityModel.setProductimage(R.drawable.black_leather_watch);
        listActivityModel.setProductname("GRANT LEATHER WATCH");
        listActivityModel.setPriductprice("850");
        listActivityModel.setProductdesc("Our Grant Sport exceeds expectations with its smooth black leather, punctuated Roman numerals and automatic movement, revealing the inner-workings of this ageless timepiece.");
        arraylist.add(listActivityModel);


        return arraylist;
    }
}
