package example.com.redditlike.utilities;

import android.app.Application;
import android.content.Context;


public class RediffLikeApplicationClass extends Application
{


    private static Context context;

    @Override
    public void onCreate()
    {
        super.onCreate();

        RediffLikeApplicationClass.context = getApplicationContext();
    }


    public static Context getContext()
    {
        return context;
    }





}
