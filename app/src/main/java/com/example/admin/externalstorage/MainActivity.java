package com.example.admin.externalstorage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button) findViewById(R.id.button);

    }


    public void Save(View view) {

        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.icecreamsandwidtch);
        FileOutputStream fos;
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        try {

            File Myfile = new File(extStorageDirectory, "icecreamsandwidtch.jpg");
            Myfile.createNewFile();
            FileOutputStream fileOutputStream=new FileOutputStream(Myfile);
            bm.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            OutputStreamWriter Outwriter=new OutputStreamWriter(fileOutputStream);
            Outwriter.append(extStorageDirectory);
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"image" + " saved",Toast.LENGTH_LONG).show();



        } catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}

    }
    }
