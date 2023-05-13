package com.example.app_lab002

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.app_lab002.databinding.ActivityUploadBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.text.DateFormat
import java.util.*

class UploadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUploadBinding
    var imageURL:String? = null
    var uri: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val activityResultLauncher = registerForActivityResult<Intent, ActivityResult>(
            ActivityResultContracts.StartActivityForResult()){result ->
            if (result.resultCode == RESULT_OK){
                val data = result.data
                uri = data!!.data
                binding.uploadImage.setImageURI(uri)
            }else{
                Toast.makeText(this@UploadActivity, "No Image Selected", Toast.LENGTH_SHORT).show()
            }
        }
        binding.uploadImage.setOnClickListener{
            val photoPicker = Intent(Intent.ACTION_PICK)
            photoPicker.type ="image/*"
            activityResultLauncher.launch(photoPicker)
        }
        binding.saveButton.setOnClickListener{
            saveData()
//            //
//            val backbutton =findViewById<Button>(R.id.saveButton)
//            backbutton.setOnClickListener{
//                val Intent = Intent(this,DetailActivity::class.java)
//                startActivity(Intent)
//            }
//            //
        }

    }
    private fun saveData(){
        val storageReference = FirebaseStorage.getInstance().reference.child("Product Images").child(uri!!.lastPathSegment!!)
        val builder = AlertDialog.Builder(this@UploadActivity)
        builder.setCancelable(false)
        builder.setView(R.layout.progress_layout)
        val dialog = builder.create()
        dialog.show()

        storageReference.putFile(uri!!).addOnSuccessListener{ taskSnapshot ->
            val uriTask = taskSnapshot.storage.downloadUrl
            while(!uriTask.isComplete);
            val urlImage = uriTask.result
            imageURL = urlImage.toString()
            uploadData()
            dialog.dismiss()
        }.addOnFailureListener{
            dialog.dismiss()
        }

    }
    private fun uploadData(){
        val title=binding.uploadTitle.text.toString()
        val desc=binding.uploadDesc.text.toString()
        val price=binding.uploadPrice.text.toString()
        val priority=binding.uploadPriority.text.toString()


        val dataClass = DataClass(title,desc,price,priority,imageURL)
        val currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().time)

        FirebaseDatabase.getInstance().getReference("plant_store").child(currentDate).setValue(dataClass).addOnCompleteListener{task ->
            if(task.isSuccessful){
                Toast.makeText(this@UploadActivity,"Saved",Toast.LENGTH_SHORT).show()
                finish()
            }
        }.addOnFailureListener{e ->
            Toast.makeText(this@UploadActivity,e.message.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}