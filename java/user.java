package com.example.manasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button dairy_info=findViewById(R.id.button5);
        Button product=findViewById(R.id.button6);
        Button milk_rate=findViewById(R.id.button7);
        Button services=findViewById(R.id.button8);

        dairy_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(user.this,dairyinfo.class);
                startActivity(intent);

            }
        });
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(user.this,pro.class);
                startActivity(intent);

            }
        });
        milk_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(user.this,milk_rate.class);
                startActivity(intent);

            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(user.this,services.class);
                startActivity(intent);

            }
        });

    }
}