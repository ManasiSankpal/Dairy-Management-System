package com.example.manasi;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class client1 extends AppCompatActivity {
    EditText e,e1,e2,e3;
    clientdata a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client1);
        e=findViewById(R.id.editText);
        e1=findViewById(R.id.editText2);
        e2=findViewById(R.id.editText3);
        e3=findViewById(R.id.editText4);
        a=new clientdata(this);


        Button bt=findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Client_No = e.getText().toString();
                String Name = e1.getText().toString();
                String Address = e2.getText().toString();
                String Milk_Type = e3.getText().toString();

                if (Client_No.equals("") || Name.equals("") || Address.equals("") || Milk_Type.equals("")) {
                    Toast.makeText(client1.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean res1= a.insertData(Client_No, Name, Address, Milk_Type);
                    if (res1 == true) {

                        Toast.makeText(client1.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(client1.this, "Not inserted", Toast.LENGTH_SHORT).show();
                    }
                }
             /*   e.setText("");
                e1.setText("");
                e2.setText("")66666666665555555555555555555555555555555555555555555555;
                e3.setText("");
*/
            }

        });


        Button view=findViewById(R.id.view);

        clientdata g=new clientdata(this);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor t=g.getdata();
                if(t.getCount()==0){
                    Toast.makeText(client1.this,"no data found",Toast.LENGTH_SHORT).show();
                }
                StringBuffer buffer=new StringBuffer();
                while (t.moveToNext())
                {
                    buffer.append("Customer No"+t.getString(0)+"\n");
                    buffer.append("Name"+t.getString(1)+"\n");
                    buffer.append("Address"+t.getString(2)+"\n");
                    buffer.append("Milk Type"+t.getString(3)+"\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(client1.this);
                builder.setCancelable(true);
                builder.setTitle("Client Data");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });

    }
}