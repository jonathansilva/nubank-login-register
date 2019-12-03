package app.project.loginregister.ui.activity.terms;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import app.project.loginregister.R;

public class TermsView extends AppCompatActivity {
    public WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        webView = findViewById(R.id.webView);
        webView.loadUrl("https://www.google.com");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.stable, R.anim.left_to_right);
    }
}
