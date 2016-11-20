package example.com.redditlike.apiobjects;

import android.content.Context;

import com.android.volley.Request;

import example.com.redditlike.constants.Constants;
import example.com.redditlike.volleylibclasses.AppRequestListener;
import example.com.redditlike.volleylibclasses.GetFeedServiceClass;


public class AllUser extends BaseObject implements Constants {

    private static AllUser sInstance;

    @Override
    public void clear(Context context) {

    }

    public static AllUser getInstance() {
        if (sInstance == null)
            sInstance = new AllUser();
        return sInstance;
    }

    public void getNewsAllUser(String url, AppRequestListener appRequestListener, Context context)
    {
        AppNetworkError appNetworkError = new AppNetworkError();
        GetFeedServiceClass request = new GetFeedServiceClass(Request.Method.GET, url, appNetworkError, Constants.ID_NEWS, appRequestListener);
        sendRequest(context, appNetworkError, request, appRequestListener);
    }

    public void getHotAllUser(String url, AppRequestListener appRequestListener, Context context)
    {
        AppNetworkError appNetworkError = new AppNetworkError();
        GetFeedServiceClass request = new GetFeedServiceClass(Request.Method.GET, url, appNetworkError, Constants.ID_HOT, appRequestListener);
        sendRequest(context, appNetworkError, request, appRequestListener);
    }

    public void getRisingAllUser(String url, AppRequestListener appRequestListener, Context context)
    {
        AppNetworkError appNetworkError = new AppNetworkError();
        GetFeedServiceClass request = new GetFeedServiceClass(Request.Method.GET, url, appNetworkError, Constants.ID_RISING, appRequestListener);
        sendRequest(context, appNetworkError, request, appRequestListener);
    }

    public void getControversialAllUser(String url, AppRequestListener appRequestListener, Context context)
    {
        AppNetworkError appNetworkError = new AppNetworkError();
        GetFeedServiceClass request = new GetFeedServiceClass(Request.Method.GET, url, appNetworkError, Constants.ID_CONTROVERSIAL, appRequestListener);
        sendRequest(context, appNetworkError, request, appRequestListener);
    }


    public void getTopAllUser(String url, AppRequestListener appRequestListener, Context context)
    {
        AppNetworkError appNetworkError = new AppNetworkError();
        GetFeedServiceClass request = new GetFeedServiceClass(Request.Method.GET, url, appNetworkError, Constants.ID_TOP, appRequestListener);
        sendRequest(context, appNetworkError, request, appRequestListener);
    }

    public void getGuildedAllUser(String url, AppRequestListener appRequestListener, Context context)
    {
        AppNetworkError appNetworkError = new AppNetworkError();
        GetFeedServiceClass request = new GetFeedServiceClass(Request.Method.GET, url, appNetworkError, Constants.ID_GILDED, appRequestListener);
        sendRequest(context, appNetworkError, request, appRequestListener);
    }

    public void getWikiAllUser(String url, AppRequestListener appRequestListener, Context context)
    {
        AppNetworkError appNetworkError = new AppNetworkError();
        GetFeedServiceClass request = new GetFeedServiceClass(Request.Method.GET, url, appNetworkError, Constants.ID_WIKI, appRequestListener);
        sendRequest(context, appNetworkError, request, appRequestListener);
    }


    public void getPromotedAllUser(String url, AppRequestListener appRequestListener, Context context)
    {
        AppNetworkError appNetworkError = new AppNetworkError();
        GetFeedServiceClass request = new GetFeedServiceClass(Request.Method.GET, url, appNetworkError, Constants.ID_PROMOTED, appRequestListener);
        sendRequest(context, appNetworkError, request, appRequestListener);
    }


}
