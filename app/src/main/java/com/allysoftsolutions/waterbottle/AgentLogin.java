package com.allysoftsolutions.waterbottle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;


public class AgentLogin extends AppCompatActivity {


    private final int REQUEST_IMG = 1;
    ImageView imageViewShow;
    //selected image into stream of byte
    EditText edtmail, edtpass;
    private boolean isCamera;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agentlogin);
        edtmail = findViewById(R.id.edtnm);
        edtpass = findViewById(R.id.editTextMobile);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(AgentLogin.this, MainActivity.class));
            finish();
        }


    }

    public void cancel(View view) {
        edtpass.setText("");
        edtmail.setText("");
    }

    public void register(View view) {
        String email = edtmail.getText().toString();
        final String password = edtpass.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }



        //authenticate user
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(AgentLogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.

                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                edtpass.setError("Validate PAssword");
                            } else {
                                Toast.makeText(AgentLogin.this, "Auth Faild", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent intent = new Intent(AgentLogin.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }


    }



/*
    private void openChooser() {
        AlertDialog.Builder builder
                = new AlertDialog.Builder(AgentLogin.this);

        View view = this.getLayoutInflater().inflate(R.layout.dialog_image_select, null);

        final ImageView btnCamera = view.findViewById(R.id.btnCamera);
        final ImageView btnGallery = view.findViewById(R.id.btnGallery);

        final AlertDialog dialog = builder.create();
        dialog.setView(view);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, REQUEST_IMG);
                isCamera = true;
                dialog.dismiss();
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickPhoto.setType("image/*");
                pickPhoto.putExtra("aspectX", 1);
                pickPhoto.putExtra("aspectY", 1);
                pickPhoto.putExtra("scale", true);
                pickPhoto.putExtra("outputFormat",
                        Bitmap.CompressFormat.JPEG.toString());
                startActivityForResult(pickPhoto, REQUEST_IMG);
                isCamera = false;
                dialog.dismiss();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri selectedImage = null;
        switch (requestCode) {
            case REQUEST_IMG:
                if (resultCode == RESULT_OK) {
                    Bitmap photo = null;
                    if (isCamera) {
                        photo = (Bitmap) data.getExtras().get("data");
                    } else {
                        selectedImage = data.getData();
                    }

                    if (!isCamera) {
                        /*photo = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(selectedImage.getEncodedPath()),
                                500, 500);*/
/*
                        try {
                            photo = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    imageViewShow.setImageBitmap(photo);
                    //converting uploded image to string bytes
                    if (photo != null) {

                    }
                    // streamOfImage = Usefull.getStringImage(photo);
                }
                break;
        }
    }
    */





