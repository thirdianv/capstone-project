package com.bangkit2022.bentala.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit2022.bentala.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvButtonCekTanah.setOnClickListener{
            callPictureProcess()
        }
        binding.btnHelp.setOnClickListener {
            callHelpPage()
        }
    }

    private fun callPictureProcess(){
        startActivity(Intent(this, PictureProcessActivity::class.java))
        finish()
    }
    private fun callHelpPage(){
        startActivity(Intent(this, HelpActivity::class.java))
        finish()
    }

    private fun setupDigitClassifier() {
        downloadModel("mnist_v1")
    }

    private fun downloadModel(modelName: String): Task<Void> {
        val remoteModel = FirebaseCustomRemoteModel.Builder(modelName).build()
        val firebaseModelManager = FirebaseModelManager.getInstance()
        return firebaseModelManager
            .isModelDownloaded(remoteModel)
            .continueWithTask { task ->
                // Create update condition if model is already downloaded, otherwise create download
                // condition.
                val conditions = if (task.result != null && task.result == true) {
                    FirebaseModelDownloadConditions.Builder()
                        .requireWifi()
                        .build() // Update condition that requires wifi.
                } else {
                    FirebaseModelDownloadConditions.Builder().build(); // Download condition.
                }
                firebaseModelManager.download(remoteModel, conditions)
            }
            .addOnSuccessListener {
                firebaseModelManager.getLatestModelFile(remoteModel)
                    .addOnCompleteListener {
                        val model = it.result
                        if (model == null) {
                            showToast("Failed to get model file.")
                        } else {
                            showToast("Downloaded remote model: $model")
                            digitClassifier.initialize(model)
                        }
                    }
            }
            .addOnFailureListener {
                showToast("Model download failed for digit classifier, please check your connection.")
            }
    }
}