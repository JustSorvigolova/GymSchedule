package com.example.gymschedule.Forms
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.gymschedule.ViewModels.*
import com.example.gymschedule.Fragment_back
import com.example.gymschedule.R
import com.google.firebase.storage.FirebaseStorage
import java.util.*
import com.example.gymschedule.databinding.FragmentAddBackBinding


class Fragment_Add_Back : Fragment() {
    private var binding: FragmentAddBackBinding? = null
    private lateinit var viewModelBack: BackViewModel
    private val PICK_IMAGE_REQUEST = 1


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBackBinding.inflate(LayoutInflater.from(context), container, false)
        viewModelBack = ViewModelProvider(this)[BackViewModel::class.java]
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.uploadImage.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
        }

        binding!!.saveButton.setOnClickListener {
            val title = binding!!.uploadTitle.text.toString()
            val desc = binding!!.uploadDesc.text.toString()
            val imageUri = binding!!.uploadImage.tag as Uri?
            if (imageUri != null) {
                uploadImageToFirebaseStorage(title, desc, imageUri)
                val fragment = Fragment_back()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.back_fragment, fragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                viewModelBack.sendDataToFirebase(title, desc, null)
                val fragment = Fragment_back()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.back_fragment, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
    private fun uploadImageToFirebaseStorage(title: String, desc: String, imageUri: Uri) {
        val storageRef = FirebaseStorage.getInstance().getReference("uploads/${UUID.randomUUID()}")
        storageRef.putFile(imageUri)
            .addOnSuccessListener {
                storageRef.downloadUrl.addOnSuccessListener { imageUrl ->
                    viewModelBack.sendDataToFirebase(title, desc, imageUrl.toString())
                }
            }
            .addOnFailureListener {
                Log.e(ContentValues.TAG, "Ошибка загрузки файла в Storage: Ошибка Кароче")
            }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val imageUri = data.data
            binding!!.uploadImage.setImageURI(imageUri)
            binding!!.uploadImage.tag = imageUri
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}