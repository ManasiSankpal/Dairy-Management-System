package com.example.manasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class forgotpass extends AppCompatActivity {

    EditText e1, e2, e3;
    Button set;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);

        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText4);
        set = findViewById(R.id.button);
        myDB = new DBHelper(this);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String Email = e1.getText().toString();
                    String new_pass = e2.getText().toString();
                    String con_pass = e3.getText().toString();
                    Intent r = new Intent(getApplicationContext(),MainActivity.class);

                    if (Email.equals("") || new_pass.equals("") || con_pass.equals(""))
                    {
                        Toast.makeText(forgotpass.this, "Fields Can't Empty", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        if (new_pass.equals(con_pass))
                        {
                            int updatepass = myDB.updatepass(Email, new_pass);

                            if (updatepass == 1)
                            {
                                e1.setText("");
                                e3.setText("");
                                Toast.makeText(forgotpass.this, "Successful Update", Toast.LENGTH_SHORT).show();
                                startActivity(r);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(forgotpass.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                            }


                        } else {
                            Toast.makeText(forgotpass.this, "Password Mismatched", Toast.LENGTH_SHORT).show();
                        }
                    }

                } catch (Exception e)
                {
                    Toast.makeText(forgotpass.this, "Out Of Bound" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}