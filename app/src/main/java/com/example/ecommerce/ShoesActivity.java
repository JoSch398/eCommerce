package com.example.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoesActivity extends AppCompatActivity {

    private Button button;

    android.widget.ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);

        button = (Button) findViewById(R.id.open_timer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimer();
            }
        });

        listView = (android.widget.ListView) findViewById(R.id.listview);

        final ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Adidas");
        arrayList.add("Nike");
        arrayList.add("Adilette");
        arrayList.add("Guccilette");
        arrayList.add("Lacoste");
        arrayList.add("New Balance");
        arrayList.add("Budapest");
        arrayList.add("Oxford");
        arrayList.add("Tennis");
        arrayList.add("Air Max");
        arrayList.add("X");
        arrayList.add("Y");
        arrayList.add("Z");
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ShoesActivity.this, "clicked item" +i+""+arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openTimer() {
        Intent intent = new Intent(this, AlarmActivity.class);
        startActivity(intent);
    }
}
