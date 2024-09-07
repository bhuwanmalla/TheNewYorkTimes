package bhuwan.example.thenewyorktimes

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import bhuwan.example.thenewyorktimes.databinding.ActivityWebDesignBinding

class WebDesignActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebDesignBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityWebDesignBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        val webView = binding.webView

        val url = intent.getStringExtra("web_url")
        if (!url.isNullOrEmpty()){
            webView.loadUrl(url)
        }
    }
}