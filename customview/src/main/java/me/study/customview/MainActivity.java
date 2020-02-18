package me.study.customview;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FrameLayout frameLayout = findViewById(R.id.ft_layout);
//        frameLayout.addView(new SimpleView(this));
    }
}
