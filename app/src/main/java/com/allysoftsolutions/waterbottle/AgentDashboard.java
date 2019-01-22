package com.allysoftsolutions.waterbottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AgentDashboard extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_dashboard);
        tv = findViewById(R.id.txtqrs);
        setTitle("Agent Dashboard");


        Bundle extras = getIntent().getExtras();
        String userName = null;

        if (extras != null) {
            userName = extras.getString("qrcode");
            // and get whatever type user account id is
        }
        tv.setText(userName.toString());

    }
}
