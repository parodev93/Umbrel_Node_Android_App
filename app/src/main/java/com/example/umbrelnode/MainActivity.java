package com.example.umbrelnode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webview);
        final Activity activity = this;
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

          /*  @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error){
                Toast.makeText(activity, error.getDescription(), Toast.LENGTH_LONG).show();
            }*/
        });

        // The URL that webview is loading
        myWebView.loadUrl("http://umbrel.local");

    }
    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}