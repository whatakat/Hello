package com.bankmtk.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView greeting = (TextView)findViewById(R.id.greeting);
        greeting.setText(greetPhrase());
    }
    private String greetPhrase(){
        TextView greeting = (TextView)findViewById(R.id.greeting);
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        Resources resources = getResources();
        String helloer  =resources.getString(R.string.helloer);
        if (5<= currentHour && currentHour<12){
            return String.format("%s %s!",resources.getString(R.string.morning),helloer);
        }else if (12<= currentHour && currentHour < 6 ){
            return String.format("%s %s!",resources.getString(R.string.afternoon),helloer);
        }else if (6<=currentHour && currentHour <9){
            return String.format("%s %s!",resources.getString(R.string.evening),helloer);
        }else{
            return String.format("%s %s!",resources.getString(R.string.night),helloer);
        }


    }
}
