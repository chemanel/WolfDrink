package com.chema.jack.wolfdrink;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by JACK on 05/04/2015.
 */
public class CWolf extends Application {



    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this,"TgNQZ7PM1j81e1v6DCdOz7FjKF2wiplGKSWC0dN8","Nynjx4rFBIDebWDw3vqUE5GMc4AxolTTluxihC3J");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }

}
