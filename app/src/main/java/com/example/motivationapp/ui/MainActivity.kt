package com.example.motivationapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motivationapp.infra.MotivationConstants
import com.example.motivationapp.R
import com.example.motivationapp.data.Mock
import com.example.motivationapp.infra.SecurityPreferences
import com.example.motivationapp.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val mock: Mock = Mock()
    private var categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Esconde barra de navegação
        supportActionBar?.hide()

        showUsername()
        handleFilter(R.id.image_all)

        //Eventos
        setListeners()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase)
            handleNewPhrase(categoryId)
        else if (view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_bookmark))
            handleFilter(view.id)
        else if (view.id == R.id.text_username)
            startActivity(Intent(this, UserActivity::class.java))
    }

    private fun setListeners() {
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageBookmark.setOnClickListener(this)
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.textUsername.setOnClickListener(this)
    }

    private fun handleNewPhrase(id: Int) {
        binding.textBody.text = mock.getPhrase(id, Locale.getDefault().language)
    }

    private fun handleFilter(id: Int) {

        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageBookmark.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                categoryId = MotivationConstants.FILTER.ALL
                binding.imageAll.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }

            R.id.image_happy -> {
                categoryId = MotivationConstants.FILTER.HAPPY
                binding.imageHappy.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }

            else -> {
                categoryId = MotivationConstants.FILTER.BOOKMARK
                binding.imageBookmark.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }
        }
    }

    private fun showUsername() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        val hello = getString(R.string.hello) + ", " + name
        binding.textUsername.text = hello
    }
}