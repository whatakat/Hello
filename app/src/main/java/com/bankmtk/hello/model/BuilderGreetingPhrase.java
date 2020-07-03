package com.bankmtk.hello.model;


import android.widget.Toast;

import java.util.Calendar;

public class BuilderGreetingPhrase {
    private int currentHour;
    private GreetingStrings greetingPhrases;
    public BuilderGreetingPhrase(GreetingStrings greetingPhrases){
        this(greetingPhrases, Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
    }
    public BuilderGreetingPhrase(GreetingStrings greetingPhrases, int hour){
        currentHour = hour;
        this.greetingPhrases = greetingPhrases;
    }
    public String get(){
        String helloer = greetingPhrases.getHelloer();
        if (5<= currentHour && currentHour<12){
            return String.format("%s %s!",greetingPhrases.getMorning(),helloer);
        }else if (12<= currentHour && currentHour < 6 ){
            return String.format("%s %s!",greetingPhrases.getAfternoon(),helloer);
        }else if (6<=currentHour && currentHour <9){
            return String.format("%s %s!",greetingPhrases.getEvening(),helloer);
        }else{
            return String.format("%s %s!",greetingPhrases.getNight(),helloer);
        }

    }
}
