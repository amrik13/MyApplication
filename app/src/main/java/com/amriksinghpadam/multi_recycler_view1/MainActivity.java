package com.amriksinghpadam.multi_recycler_view1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button uploadImgBtn,submitBtn,listBtn,gridViewBtn;
    ImageView img;
    byte[] byteArray;
    EditText name, age, des;
    String nameStr,ageStr,desStr;
    MyDatabase db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //uploadImgBtn = findViewById(R.id.uploadImgId);
        name = findViewById(R.id.nameId);
        age = findViewById(R.id.ageId);
        des = findViewById(R.id.descriptionId);
        submitBtn = findViewById(R.id.submitBtnId);
        listBtn = findViewById(R.id.listViewBtnId);
        gridViewBtn = findViewById(R.id.gridViewBtnId);

        View.OnClickListener submitBtnListener = new View.OnClickListener(){
            public void onClick(View v){
                nameStr = name.getText().toString().trim();
                ageStr = age.getText().toString().trim();
                desStr = des.getText().toString().trim();

                if(nameStr.isEmpty() || ageStr.isEmpty() || desStr.isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter Detail",Toast.LENGTH_SHORT).show();
                }else{

                    db = new MyDatabase(MainActivity.this);
                    boolean flag = db.insetData(nameStr,ageStr,desStr);
                    if(flag==true) {
                        Toast.makeText(MainActivity.this,"Inserted!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Not Inserted!",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        };
        submitBtn.setOnClickListener(submitBtnListener);


        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListViewClass.class);
                startActivity(intent);
            }
        });

        gridViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GridViewClass.class);
                startActivity(intent);
            }
        });




//        img = findViewById(R.id.imgId);
//        View.OnClickListener uploadImgBtnListener = new View.OnClickListener()
//        {
//            public void onClick(View v){
//                final String cond1 = "Take Photo";
//                final String cond2 = "Choose From Gallery";
//                final String cond3 = "Cancel";
//
//                final CharSequence[] options = { cond1,cond2,cond3 };
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Add Photo!");
//                builder.setItems(options, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface d, int item){
//                        if(options[item].equals(cond1)){
//
//                            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
//                                    startActivityForResult(cameraIntent, 3);
//                                }
//
//                        }else if(options[item].equals(cond2)){
//
//                        }else if(options[item].equals(cond3)){
//                            d.dismiss();
//
//                        }else{
//                            Toast.makeText(MainActivity.this, "Invalid Action!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//                builder.show();
//            }
//        };
//        uploadImgBtn.setOnClickListener(uploadImgBtnListener);

    }


//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 3 && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            img.setImageBitmap(imageBitmap);
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            byteArray = stream.toByteArray();
//        }
//    }
}
