package com.example.carwashticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Eplat, Eowner;
    private String Splat, Sowner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Eplat = (EditText) findViewById(R.id.create_plat);
        Eowner = (EditText) findViewById(R.id.create_owner);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Splat = String.valueOf(Eplat.getText());
                Sowner = String.valueOf(Eowner.getText());
                if (Splat.equals("")){
                    Eplat.requestFocus();
                    Toast.makeText(MainCreate.this, "Input Your License Plate",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sowner.equals("")) {
                    Eowner.requestFocus();
                    Toast.makeText(MainCreate.this, "Input Your Name",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Eplat.setText("");
                    Eowner.setText("");
                    Toast.makeText(MainCreate.this, "Your car has been registered",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMobil(new Mobil(null, Splat, Sowner));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}