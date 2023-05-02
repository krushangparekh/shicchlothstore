package com.example.ClothsStore.UI

import android.app.Activity.RESULT_OK
import android.content.ContentResolver
import android.widget.EditText
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.ClothsStore.R
import de.hdodenhof.circleimageview.CircleImageView
import java.io.ByteArrayOutputStream

class MyProfileFragment : Fragment() {
    val contentResolver: ContentResolver? = null
    var profileImg: CircleImageView? = null
    var name: EditText? = null
    var email: EditText? = null
    var number: EditText? = null
    var address: EditText? = null
    var update: Button? = null
    val bitmap: Bitmap? = null
    val imageView: ImageView? = null
        companion object {
        const val REQUEST_IMAGE_SELECT = 123
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_myprofile, container, false)

        profileImg = root.findViewById(R.id.profile_img)
        name = root.findViewById(R.id.profile_name)
        email = root.findViewById(R.id.profile_email)
        number = root.findViewById(R.id.profile_number)
        address = root.findViewById(R.id.profile_address)
        update = root.findViewById(R.id.profile_update)


        profileImg?.setOnClickListener(View.OnClickListener {
//            val intent = Intent()
//            intent.action = Intent.ACTION_GET_CONTENT
//            intent.type = "image/*"
//            startActivityForResult(intent, 33)
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_IMAGE_SELECT)

        })
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == REQUEST_IMAGE_SELECT && resultCode == RESULT_OK && data != null) {
                val imageUri: Uri = data.data!!
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
                // update user profile picture with the bitmap
            }
        }

        update?.setOnClickListener(View.OnClickListener { updateUserProfile() })
        return root
    }


    private fun updateUserProfile() {
        val outputStream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        val imageBytes: ByteArray = outputStream.toByteArray()
        imageView?.setImageBitmap(bitmap)
    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (data!!.data != null) {
//            data.dataprofileImg!!.setImageURI(profileUri)
//
//
//        }
//    }
}