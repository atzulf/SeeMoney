package com.proyekmandiri.seemoney.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.proyekmandiri.seemoney.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
        val resultText = intent.getStringExtra(EXTRA_RESULT)

        if (imageUriString != null) {
            val imageUri = Uri.parse(imageUriString)
            Log.d("ResultActivity", "Image URI: $imageUri")
            binding.resultImage.setImageURI(imageUri)
        } else {
            Log.e("ResultActivity", "No image URI received")
            showToast("Foto tidak ditemukan")
        }

        if (resultText != null) {
            binding.resultText.text = resultText
        } else {
            Log.e("ResultActivity", "No classification result received")
            binding.resultText.text = "Hasil tidak ditemukan"
        }

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_RESULT = "extra_result"
    }

}

