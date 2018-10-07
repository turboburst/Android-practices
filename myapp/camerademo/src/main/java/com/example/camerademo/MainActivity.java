package com.example.camerademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static int REQCODE1 = 1;
    private static int REQCODE2 = 2;
    private Button button1, button2;
    private ImageView imageView;
    private String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filePath = Environment.getExternalStorageDirectory().getPath() + "/temp.png";

        button1 = (Button) findViewById(R.id.button1id);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQCODE1);
            }
        });

        button2 = (Button) findViewById(R.id.button2id);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri photouri = Uri.fromFile(new File(filePath));
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photouri);
                startActivityForResult(intent, REQCODE2);
            }
        });
        imageView = (ImageView) findViewById(R.id.imageviewid);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            if(requestCode == REQCODE1)
            {
                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");
                imageView.setImageBitmap(bitmap);
            }
            else if(requestCode == REQCODE2)
            {
                FileInputStream fileInputStream = null;
                try
                {
                    fileInputStream = new FileInputStream(filePath);
                    Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                    imageView.setImageBitmap(bitmap);
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                        fileInputStream.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
