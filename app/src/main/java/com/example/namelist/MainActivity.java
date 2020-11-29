package com.example.namelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    EditText etAddName;
    ListView lvListOfNames;

    List<String> friends = new ArrayList<String>();
    String[] startingList = {"Angela", "Carla", "Frank", "Dennis"};

    ArrayAdapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        etAddName = findViewById(R.id.etAddName);
        lvListOfNames = findViewById(R.id.lvListOfNames);

        friends = new ArrayList<String>(Arrays.asList(startingList));

        ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, friends);
        lvListOfNames.setAdapter(ad);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = etAddName.getText().toString();
                friends.add(newName);

                Collections.sort(friends);

                ad.notifyDataSetChanged();
            }
        });

        lvListOfNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "pos= " + position + " name= " + friends.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}