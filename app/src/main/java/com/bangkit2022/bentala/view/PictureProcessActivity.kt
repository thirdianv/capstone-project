package com.bangkit2022.bentala.view

import android.Manifest
import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ColorSpace.Model
import android.media.ThumbnailUtils
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bangkit2022.bentala.databinding.ActivityPictureProcessBinding
import com.bangkit2022.bentala.ml.KlasifikasiJenisTanah3
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.*
import java.nio.ByteBuffer
import java.nio.ByteOrder


class PictureProcessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPictureProcessBinding
    private lateinit var imageView: ImageView
    private lateinit var buttonCamera: Button
    private lateinit var buttonLoadImage: Button
    private lateinit var tvResult: TextView
    private val GALLERY_REQUEST_CODE = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPictureProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageView = binding.previewImageView
        buttonCamera = binding.btnCameraXButton
        tvResult = binding.tvTextHasil
        buttonLoadImage = binding.galleryButton

        buttonCamera.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED
            ) {
                takePicturePreview.launch(null)
            }
            else {
                requestPermission.launch(android.Manifest.permission.CAMERA)
            }
        }
        buttonLoadImage.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED
            ){
                val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                intent.type = "image/*"
                val mimeTypes = arrayOf("image/jpeg","image/png","image/jpg")
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
                intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                onresult.launch(intent)
            }else {
                requestPermission.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
        tvResult.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, {tvResult})
        }






    }


}