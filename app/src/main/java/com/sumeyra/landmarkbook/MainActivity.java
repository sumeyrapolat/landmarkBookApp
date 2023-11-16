package com.sumeyra.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.sumeyra.landmarkbook.databinding.ActivityDetailsBinding;
import com.sumeyra.landmarkbook.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    // başka methodlardan da erişebilmek için burada tanımılıyoruz !!
    ArrayList<Landmark> landmarkArrayList;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList= new ArrayList<>();

        // Data giriyoruz veri giriyoruz burada
        Landmark pisa = new Landmark("Pisa","Italy",R.drawable.pisa);
        Landmark eiffel= new Landmark("Eiffel","France", R.drawable.eifell);
        Landmark colosseum = new Landmark("Colosseum","Italy", R.drawable.colosseum);
        Landmark londonBridge = new Landmark("London Bridge","UK",R.drawable.londonbridge);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colosseum);
        landmarkArrayList.add(londonBridge);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        landmarkAdapter landmarkAdapter = new landmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);


        // Listview kullanmak iin öncelikle adapter kullanmamız gerekiyor
        // buradaki veri kaynağımız ile xml i birbirine bağlayan yapı
        // Adapter

        /*
        //Listview verimsiz ama kolay
        //mapping bir şeyi bir şeye dönüştürüürken kullanıyoruz
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //tıkladığımız şeyin adını yazdırmak için tamamen test:
                Toast.makeText(MainActivity.this,landmarkArrayList.get(position).name,Toast.LENGTH_LONG).show();
            Intent intent =new Intent(MainActivity.this,DetailsActivity.class);
            intent.putExtra("landmark",landmarkArrayList.get(position));
            startActivity(intent);
            }
        });
        */


    }
}