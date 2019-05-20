package com.example.ecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoesActivity extends AppCompatActivity {

    android.widget.ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);

        listView = (android.widget.ListView) findViewById(R.id.listview);

        final ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Adidas Schuh");
        arrayList.add("Nike Schuh");
        arrayList.add("Adilette");
        arrayList.add("Guccilette");
        arrayList.add("Lacoste Schuh");
        arrayList.add("New Balance Schuh");
        arrayList.add("Budapester");
        arrayList.add("Oxford");
        arrayList.add("Fussballschuh");
        arrayList.add("Tennisschuh");
        arrayList.add("Sandale");
        arrayList.add("Air Max");
        arrayList.add("Stiefel");
        arrayList.add("Schuh X");
        arrayList.add("Schuh Y");
        arrayList.add("Schuh Z");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ShoesActivity.this, "clicked item" +i+""+arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
