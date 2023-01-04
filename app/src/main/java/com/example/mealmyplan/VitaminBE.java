package com.example.mealmyplan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class VitaminBE extends AppCompatActivity {

    ListView listView;
    ListView AlistView;
    ListView BlistView;
    // creating  a String type array (fruitNames)
    // which contains names of different fruits' images
    String fruitNames[] = {"Banana", "Grape", "Guava", "Mango", "Orange", "Watermelon"};

    String afruitNames[] = {"Banana", "Grape", "Guava", "Mango", "Orange", "Watermelon"};

    String bfruitNames[] = {"Banana", "Grape", "Guava", "Mango", "Orange", "Watermelon"};

    // creating an Integer type array (fruitImageIds) which
    // contains IDs of different fruits' images
    int fruitImageIds[] = {

    };

    int afruitImageIds[] = {

    };

    int bfruitImageIds[] = {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding the ListView  of activity_main.xml file
        // with this java code in MainActivity.java
        listView = findViewById(R.id.listView);
        AlistView = findViewById(R.id.alistView);
        BlistView = findViewById(R.id.blistView);

        // creating an ArrayList of HashMap.The kEY of the HashMap
        // is a String and VALUE is of any datatype(Object)
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        ArrayList<HashMap<String, Object>> list1 = new ArrayList<>();
        ArrayList<HashMap<String, Object>> list2 = new ArrayList<>();

        // By a for loop, entering different types of data in HashMap,
        // and adding this map including it's datas into the ArrayList
        // as list item and this list is the second parameter of the SimpleAdapter
        for (int i = 0; i < fruitNames.length; i++) {

            // creating an Object of HashMap class
            HashMap<String, Object> map = new HashMap<>();

            // Data entry in HashMap
            map.put("fruitName", fruitNames[i]);
            map.put("fruitImage", fruitImageIds[i]);

            // adding the HashMap to the ArrayList
            list.add(map);
        }

        for (int i = 0; i < afruitNames.length; i++) {

            // creating an Object of HashMap class
            HashMap<String, Object> map = new HashMap<>();

            // Data entry in HashMap
            map.put("afruitName", afruitNames[i]);
            map.put("afruitImage", afruitImageIds[i]);

            // adding the HashMap to the ArrayList
            list1.add(map);
        }



        for (int i = 0; i < bfruitNames.length; i++) {

            // creating an Object of HashMap class
            HashMap<String, Object> map = new HashMap<>();

            // Data entry in HashMap
            map.put("bfruitName", bfruitNames[i]);
            map.put("bfruitImage", bfruitImageIds[i]);

            // adding the HashMap to the ArrayList
            list2.add(map);
        }

        // creating A string type array(from) which contains
        // column names for each View in each row of the list
        // and this array(form) is the fourth parameter of the SimpleAdapter
        String[] from = {"fruitName", "fruitImage"};

        String[] afrom = {"afruitName", "afruitImage"};

        String[] bfrom = {"bfruitName", "bfruitImage"};

        // creating an integer type array(to) which contains
        // id of each View in each row of the list
        // and this array(form) is the fifth parameter of the SimpleAdapter
        int to[] = {R.id.textView, R.id.imageView};

        int to1[] = {R.id.textView, R.id.imageView};

        int to2[] = {R.id.textView, R.id.imageView};

        // creating an Object of SimpleAdapter class and
        // passing all the required parameters
        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(), list, R.layout.list_row_items, from, to);

        SimpleAdapter simpleAdapter1 = new SimpleAdapter(getApplicationContext(), list, R.layout.list_row_items, afrom, to1);

        SimpleAdapter simpleAdapter2 = new SimpleAdapter(getApplicationContext(), list, R.layout.list_row_items, bfrom, to2);

        // now setting the simpleAdapter to the ListView
        listView.setAdapter(simpleAdapter);

        listView.setAdapter(simpleAdapter1);

        listView.setAdapter(simpleAdapter2);
    }
}