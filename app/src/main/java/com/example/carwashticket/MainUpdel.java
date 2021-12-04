package com.example.carwashticket;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Splat, Sowner;
    private EditText Eplat, Eowner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Splat = i.getStringExtra("Iplat");
        Sowner = i.getStringExtra("Iowner");
        Eplat = (EditText) findViewById(R.id.updel_plat);
        Eowner = (EditText) findViewById(R.id.updel_owner);
        Eplat.setText(Splat);
        Eowner.setText(Sowner);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Splat = String.valueOf(Eplat.getText());
                Sowner = String.valueOf(Eowner.getText());
                if (Splat.equals("")){
                    Eplat.requestFocus();
                    Toast.makeText(MainUpdel.this, "Input your license plate",
                            Toast.LENGTH_SHORT).show();
                } else if (Sowner.equals("")){
                    Eowner.requestFocus();
                    Toast.makeText(MainUpdel.this, "Input your name",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMobil(new Mobil(Sid, Splat, Sowner));
                    Toast.makeText(MainUpdel.this, "Data has been updated",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMobil(new Mobil(Sid, Splat, Sowner));
                Toast.makeText(MainUpdel.this, "Data has been deleted",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}