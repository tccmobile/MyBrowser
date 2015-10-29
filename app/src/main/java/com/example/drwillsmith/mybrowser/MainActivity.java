package com.example.drwillsmith.mybrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    WebView myWebView;
    Button goButton;
    ImageButton backButton,nextButton;
    EditText myURL;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webView);
        goButton = (Button) findViewById(R.id.button);
        myURL = (EditText) findViewById(R.id.editText);
        backButton = (ImageButton) findViewById(R.id.backButton);
        nextButton = (ImageButton) findViewById(R.id.nextButton);

        myWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://www.google.com");

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = myURL.getText().toString();
                myWebView.loadUrl(url);
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myWebView.canGoBack())
                    myWebView.goBack();
            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myWebView.canGoForward())
                    myWebView.goForward();

            }
        });

    }
}
