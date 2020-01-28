package com.bankmtk.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import com.bankmtk.hello.model.BuilderGreetingPhrase;
import com.bankmtk.hello.model.GreetingStrings;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements GreetingStrings {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView greeting = (TextView)findViewById(R.id.greeting);
        BuilderGreetingPhrase builderGreetingPhrase = new BuilderGreetingPhrase(getResources());
        greeting.setText(builderGreetingPhrase.get());
    }

    @Override
    public String getHelloer() {
        return getResources().getString(R.string.helloer);
    }

    @Override
    public String getMorning() {
        return getResources().getString(R.string.morning);
    }

    @Override
    public String getAfternoon() {
        return getResources().getString(R.string.afternoon);
    }

    @Override
    public String getEvening() {
        return getResources().getString(R.string.evening);
    }

    @Override
    public String getNight() {
        return getResources().getString(R.string.night);
    }
}
