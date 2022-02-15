package com.example.viewbindingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.viewbindingtest.databinding.ActivityCarListBinding;

public class CarListActivity extends AppCompatActivity {

    private ActivityCarListBinding binding;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView.Adapter adapter = new CarListAdapter(this,DataManager.GetInstance().getCarList(),
                (view,position)->{
                    Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                });
        binding.rvCarList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvCarList.setAdapter(adapter);


    }
}