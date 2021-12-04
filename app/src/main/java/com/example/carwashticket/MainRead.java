package com.example.carwashticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Mobil> ListMobil = new
            ArrayList<Mobil>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMobil);
        mListView = (ListView) findViewById(R.id.list_mobil);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMobil.clear();
        List<Mobil> Mobil = db.ReadMobil();
        for (Mobil mbl : Mobil) {
            Mobil daftar = new Mobil();
            daftar.set_id(mbl.get_id());
            daftar.set_plat(mbl.get_plat());
            daftar.set_owner(mbl.get_owner());
            ListMobil.add(daftar);
            if ((ListMobil.isEmpty()))
                Toast.makeText(MainRead.this, "No Data About Your Car",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Mobil detailMbl = (Mobil)o;
        String Sid = detailMbl.get_id();
        String Splat = detailMbl.get_plat();
        String Sowner = detailMbl.get_owner();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Iplat", Splat);
        goUpdel.putExtra("Iowner", Sowner);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMobil.clear();
        mListView.setAdapter(adapter_off);
        List<Mobil> Mobil = db.ReadMobil();
        for (Mobil mbl : Mobil) {
            Mobil daftar = new Mobil();
            daftar.set_id(mbl.get_id());
            daftar.set_plat(mbl.get_plat());
            daftar.set_owner(mbl.get_owner());
            ListMobil.add(daftar);
            if ((ListMobil.isEmpty()))
                Toast.makeText(MainRead.this, "No Data About Your Car",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}