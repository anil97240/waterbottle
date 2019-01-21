package com.allysoftsolutions.waterbottle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.allysoftsolutions.waterbottle.Pojo.User;
import com.allysoftsolutions.waterbottle.database.DatabaseHelper;

import java.io.IOException;


public class register extends AppCompatActivity {


    private final int REQUEST_IMG = 1;
    private boolean isCamera;
    ImageView imageViewShow;
    //selected image into stream of byte
    String streamOfImage;
    DatabaseHelper dbHelper;
    EditText etnm,etno;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );
        etnm=findViewById( R.id.edtnm );
        etno=findViewById( R.id.edtmob );
        imageViewShow = findViewById(R.id.imgpro);

    }
    public void cancel(View view) {
        etno.setText( "" );
        etnm.setText( "" );
    }
    public void register(View view) {
        final DatabaseHelper dbHelper = new DatabaseHelper(this);
       /* user.setEmail(etnm.getText().toString());
        user.setMobileno( etno.getText().toString());
        user.setPassword( "123" );
        user.setProfile_image("a.jpg");
        etno.setText( "1" );
        etnm.setText( "12" );*/

       dbHelper.addUser(new User(etnm.getText().toString(), etno.getText().toString(),"image.png"));
        Toast.makeText( this, "data add", Toast.LENGTH_SHORT ).show();

           // User user = dbHelper.queryUser(edtEmail.getText().toString(), edtPassword.getText().toString());

                Bundle mBundle = new Bundle();
                mBundle.putString("user", etnm.getText().toString());
                Intent intent = new Intent(register.this, UserActivity.class);
                intent.putExtras(mBundle);
                startActivity(intent);
           //     Toast.makeText(register.this, "Welcome " + user.getEmail(), Toast.LENGTH_SHORT).show();

        }



    public void addimage(View view) {
   //
        if (view.getId() == R.id.button) {
            openChooser();
            Toast.makeText(this, "click on button", Toast.LENGTH_SHORT).show();
        }

            }

    private void openChooser() {
        AlertDialog.Builder builder
                = new AlertDialog.Builder(register.this);

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
                Intent takePicture = new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
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

        }



