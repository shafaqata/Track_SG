package com.sp.tracksg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.net.http.SslError;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ViewDataActivity extends AppCompatActivity {

    Toolbar toolbar;
    String link;

    WebView webView;
    ProgressBar progressBarCicle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBarCicle=findViewById(R.id.progressBarCicle);

        String name = getIntent().getStringExtra("key");


        if (name.equals("CausewayPoint")) {
            getSupportActionBar().setTitle("Causeway Point");
            link = "https://www.causewaypoint.com.sg";
        }
      else if (name.equals("Junction8")) {
            getSupportActionBar().setTitle("Junction 8");
            link = "https://www.capitaland.com/sg/malls/junction8/en.html";
        }
        else if (name.equals("NorthpointCity")) {
            getSupportActionBar().setTitle("Northpoint City");
            link = "https://www.northpointcity.com.sg";
        }
        else if (name.equals("WaterwayPoint")) {
            getSupportActionBar().setTitle("Waterway Point");
            link = "https://www.waterwaypoint.com.sg/";
        }

        webView = findViewById(R.id.webView);
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(
                new SSLTolerentWebViewClient()
        );
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                if (newProgress > 80) {
                    progressBarCicle.setVisibility(View.GONE);
                }

                super.onProgressChanged(view, newProgress);
            }
        });



    }
    private class SSLTolerentWebViewClient extends WebViewClient {

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}