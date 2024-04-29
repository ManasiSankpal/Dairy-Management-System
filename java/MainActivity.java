package com.example.manasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.manasi.DBHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText e1, e2;
    TextView t, t2;
    Spinner s;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        t = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);
        b = findViewById(R.id.button);
        s=findViewById(R.id.spinner);
        ArrayList<String>  arrayList=new ArrayList<>();
        arrayList.add("Admin");
        arrayList.add("User");

        myDB = new DBHelper(this);
        s=findViewById(R.id.spinner);
        ArrayList<String> arrayList1=new ArrayList<>();
        arrayList1.add("Admin");
        arrayList1.add("User");
        ArrayAdapter<CharSequence> arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,arrayList1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(arrayAdapter);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item=s.getSelectedItem().toString();
                String Email = e1.getText().toString();
                String password = e2.getText().toString();
                if (Email.equals("admin123@gmail.com") &&password.equals("12345")&&item.equals("Admin")){
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), home.class);
                    startActivity(intent);
                }
                else if (Email.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Crediantial", Toast.LENGTH_SHORT).show();
                }else if(item.equals("User")){
                    Boolean result = myDB.checkEmailPassword(Email, password);
                    if (result == true) {
                        Intent intent = new Intent(getApplicationContext(),user.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid  Crediantial", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), registration.class);
                startActivity(intent);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), forgotpass.class);
                startActivity(intent);
            }
        });
    }


}