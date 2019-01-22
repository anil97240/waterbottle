package com.allysoftsolutions.waterbottle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btSignIn;
    EditText edtnumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("User Login");


        btSignIn = findViewById(R.id.btSignIn);
        edtnumber = findViewById(R.id.emailinput);

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for verify mobile no from user
                Intent intent = new Intent(getApplicationContext(), VerifyPhoneActivity.class);
                intent.putExtra("mobile", edtnumber.getText().toString());
                startActivity(intent);

            }
        });


    }

    public void Agent(View view) {
        Toast.makeText(this, "agent", Toast.LENGTH_SHORT).show();

        Intent I=new Intent(MainActivity.this, AgentLogin.class);
        startActivity(I);
    }

    public void Logout(View view) {


    }
}
