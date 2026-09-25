package com.mahroch.tapeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

/**
 * Home screen: lets the user pick which deployed Apps Script link to open.
 * Change the URLs in AppLinks.java, and the display names in strings.xml
 * (app1_name / app2_name).
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView card1 = findViewById(R.id.card_app1);
        CardView card2 = findViewById(R.id.card_app2);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink(AppLinks.URL_1, getString(R.string.app1_name));
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink(AppLinks.URL_2, getString(R.string.app2_name));
            }
        });
    }

    private void openLink(String url, String title) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(WebViewActivity.EXTRA_URL, url);
        intent.putExtra(WebViewActivity.EXTRA_TITLE, title);
        startActivity(intent);
    }
}
