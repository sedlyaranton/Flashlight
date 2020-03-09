package com.sedlyaranton.flashlightflash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button buttonFlash;
    private Flash flash;
    private ImageView imageView,imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        imageView.setImageResource(R.drawable.candle);
    }

    private void init(){
        imageView = findViewById(R.id.imageView);
        buttonFlash = findViewById(R.id.button);
        flash = new Flash(this);
    }

    @SuppressLint("ResourceType")
    public void onClickFlash (View view){
        if (flash.isFlash_status())
        {
            flash.flashOff();
            buttonFlash.setText("ON");
            buttonFlash.setBackgroundResource(R.drawable.green);
            imageView.setImageResource(R.drawable.candle);

    }
        else
            {
                flash.flashOn();
                buttonFlash.setText("OFF");
                buttonFlash.setBackgroundResource(R.drawable.ried);
                imageView.setImageResource(R.drawable.svesha);

            }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (flash.isFlash_status()){
            flash.flashOff();

        }
    }
}
