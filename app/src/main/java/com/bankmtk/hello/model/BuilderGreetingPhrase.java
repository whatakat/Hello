package com.bankmtk.hello.model;

import android.content.res.Resources;

import com.bankmtk.hello.R;

import java.util.Calendar;

public class BuilderGreetingPhrase {
    private int currentHour;
    private Resources resources;
    public BuilderGreetingPhrase(Resources resources){
        this.resources = resources;
        currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }
    public String get(){
        String helloer = resources.getString(R.string.helloer);
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
