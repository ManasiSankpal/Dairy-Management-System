package com.example.manasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class registration extends AppCompatActivity {
    EditText username,email,password,cpassword;
    Button b1;
    TextView t1;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragistration);
        email=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        cpassword=findViewById(R.id.editText4);
        b1=findViewById(R.id.button);
        t1=findViewById(R.id.textView2);

        myDB=new DBHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String pass = password.getText().toString();
                String repass = cpassword.getText().toString();

                if (Email.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(registration.this, "fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean usercheckResult = myDB.checkEmail(Email);
                        if(usercheckResult==false){

                           Boolean regResult= myDB.insertData(Email,pass);
                           if (regResult==true){
                               Toast.makeText(registration.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                           }
                           else{
                               Toast.makeText(registration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                           }
                        }
                        else{
                            Toast.makeText(registration.this, "user already exists.\n please login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(registration.this, "password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
       t1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getApplicationContext(),MainActivity.class);
               startActivity(intent);
           }
       });
}

}
