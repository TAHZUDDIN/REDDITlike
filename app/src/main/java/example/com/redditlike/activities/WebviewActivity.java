package example.com.redditlike.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import example.com.redditlike.R;

public class WebviewActivity extends AppCompatActivity {


    WebView webView;
    String url;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        url = getIntent().getStringExtra("url");


        if (progressDialog == null) {
            progressDialog = new ProgressDialog(WebviewActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new MyBrowser());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

    }




    public class MyBrowser extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }



        //Show loader on url load
        public void onLoadResource (WebView view, String url) {

        }
        public void onPageFinished(WebView view, String url) {
            try{
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }catch(Exception exception){
                exception.printStackTrace();
            }
        }

    }
}
