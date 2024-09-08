package bhuwan.example.thenewyorktimes

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import bhuwan.example.thenewyorktimes.databinding.ActivityWebDesignBinding

class WebDesignActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebDesignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        val webView = binding.webView
        val toolbar = binding.toolbar

        // Set up the toolbar
        setSupportActionBar(toolbar)

        // Helps to show back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val url = intent.getStringExtra("web_url")
        if (!url.isNullOrEmpty()){
            webView.loadUrl(url)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                if (binding.webView.canGoBack()) {
                    binding.webView.goBack()
                } else {
                    finish()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
