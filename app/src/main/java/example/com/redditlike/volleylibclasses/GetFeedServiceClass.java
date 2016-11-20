package example.com.redditlike.volleylibclasses;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import example.com.redditlike.parsingclasses.ReturnDataReddit;
import example.com.redditlike.utilities.JSONUtils;


public class GetFeedServiceClass extends BaseTask<JSONObject>
{

    public String TAG = "UsrRegstrtinSrvceClas";
    public GetFeedServiceClass(int method, String url, Response.ErrorListener listener, String requestTag, AppRequestListener requestListener)
    {
        super(method, url, listener, requestTag, requestListener);
        headers = new HashMap<String, String>();
    }

    @Override
    public void processData() {
        sendMessage();
    }


    ReturnDataReddit returnedDataNewsUpdate;


    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        statusCode = response.statusCode;
        String responseString = new String(response.data);
        Log.i(TAG, "response:" + responseString);
        returnedDataNewsUpdate = new Gson().fromJson(responseString, ReturnDataReddit.class);
        return Response.success(
                JSONUtils.getJSONObject(responseString),
                getCacheEntry());
    }


    public ReturnDataReddit getDataObject() {
        return returnedDataNewsUpdate;
    }




    @Override
    protected void deliverResponse(JSONObject response) {

        this.setResponse(response);
        RequestPoolManager.getInstance().executeRequest(this);

    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }
}
