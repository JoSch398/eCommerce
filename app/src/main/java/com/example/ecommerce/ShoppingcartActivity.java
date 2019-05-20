package com.example.ecommerce;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoppingcartActivity extends AppCompatActivity {

    DatabaseHelper db;

    Button add_data;
    EditText add_name;

    ListView userlist;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);

        db = new DatabaseHelper(this);

        listItem = new ArrayList<>();


        add_data = findViewById(R.id.add_data);
        add_name = findViewById(R.id.add_name);
        userlist = findViewById(R.id.users_list);

        viewData();

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String text = userlist.getItemAtPosition(i).toString();
                db.delete(text);
                finish();
                startActivity(getIntent());

                Toast.makeText(ShoppingcartActivity.this, ""+text, Toast.LENGTH_SHORT).show();

            }
        });


        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = add_name.getText().toString();
                if (!name.equals("") && db.insertData(name)){
                    Toast.makeText(ShoppingcartActivity.this, "Data added", Toast.LENGTH_SHORT).show();
                    add_name.setText("");
                    viewData();
                }
                else{
                    Toast.makeText(ShoppingcartActivity.this, "Data not added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void viewData(){
        Cursor cursor = db.viewData();

        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1)); // index 1 is name index 0 is id
            }

            adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            userlist.setAdapter(adapter);
        }

    }
}
