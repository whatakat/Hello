package com.bankmtk.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import com.bankmtk.hello.model.BuilderGreetingPhrase;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView greeting = (TextView)findViewById(R.id.greeting);
        BuilderGreetingPhrase builderGreetingPhrase = new BuilderGreetingPhrase(getResources());
        greeting.setText(builderGreetingPhrase.get());



    }
}
