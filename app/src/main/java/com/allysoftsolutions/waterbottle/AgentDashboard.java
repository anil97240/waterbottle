package com.allysoftsolutions.waterbottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AgentDashboard extends AppCompatActivity {

    TextView tv;

    EditText number;
    Button b1,b2;

int a=1,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_dashboard);
        tv = findViewById(R.id.txtqrs);
        setTitle("Agent Dashboard");

        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        number=findViewById(R.id.editText2);

       /* Bundle extras = getIntent().getExtras();
        String userName = null;

        if (extras != null) {
            userName = extras.getString("qrcode");
            // and get whatever type user account id is
        }
//        tv.setText(userName.toString());*/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // b= Integer.parseInt(number.getText().toString());
                //int b = 0;
            b=b+a;

               number.setText(""+b);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   b= Integer.parseInt(number.getText().toString());

                b=b-a;
                number.setText(""+b);
            }
        });




    }

    public void done(View view) {

        Toast.makeText(this, "You delivered ..."+ number +"Bottle", Toast.LENGTH_SHORT).show();
    }

}
