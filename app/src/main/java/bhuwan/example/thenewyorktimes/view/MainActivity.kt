package bhuwan.example.thenewyorktimes.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import bhuwan.example.thenewyorktimes.R
import bhuwan.example.thenewyorktimes.databinding.ActivityMainBinding
import bhuwan.example.thenewyorktimes.fragments.ArticlesFragment
import bhuwan.example.thenewyorktimes.fragments.TopStoriesFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        currentFragment(ArticlesFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.topStoriesFragment -> currentFragment(TopStoriesFragment())
                R.id.articlesFragment -> currentFragment(ArticlesFragment())
                else -> {
                }
            }
            true
        }

    }

    private fun currentFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}