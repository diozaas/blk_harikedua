package com.diozaas.harikedua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView webViewYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webViewYoutube = (WebView)findViewById(R.id.webview_youtube);
        webViewYoutube.getSettings().setJavaScriptEnabled(true);
        webViewYoutube.setWebViewClient(new WebViewClient());
//        webViewYoutube.setWebViewClient(new MyBrowser());
        webViewYoutube.loadUrl("https://m.youtube.com");
//        webViewYoutube.loadUrl("http://mips.msalgroup.com:8181/mips_home");
//        webViewYoutube.setWebChromeClient(new WebChromeClient());
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            return super.shouldOverrideUrlLoading(view, request);
            webViewYoutube.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        // jika tekan back, kembali ke halaman sebelumnya, tidak langsung close
        if (webViewYoutube.canGoBack()){
            webViewYoutube.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    //    private class MyBrowser extends WebViewClient {
//        @Override
//        public boolean shouldOverRideUrlLoading(WebView webView, String url) {
//            webViewYoutube.loadUrl(url);
//            return true;
//        }
//    }


}
