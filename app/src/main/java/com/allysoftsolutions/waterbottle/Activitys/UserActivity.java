package com.allysoftsolutions.waterbottle.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.allysoftsolutions.waterbottle.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserActivity extends AppCompatActivity {
    private TextView tvUser;

     FirebaseAuth auth1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        setTitle("User Activity");

        tvUser = findViewById(R.id.tvUser);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tvUser.setText(bundle.getString("user"));

        }
    }

    public void Logout(View view) {

        auth1 = FirebaseAuth.getInstance();
        auth1.signOut();

        Toast.makeText(this, "signout", Toast.LENGTH_SHORT).show();

// this listener will be called when there is change in firebase user session
        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(UserActivity.this, MainActivity.class));
                    finish();
                }
            }
        };
    }
}
