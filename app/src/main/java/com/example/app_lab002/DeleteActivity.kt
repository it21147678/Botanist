//package com.example.app_lab002
//
//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.app_lab002.databinding.ActivityDeleteBinding
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase
//
//class DeleteActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityDeleteBinding
//    private lateinit var databaseReference: DatabaseReference
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityDeleteBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_delete)
//
//        binding.updateButton.setOnClickListener{
//            val updateTitle =binding.updateTitle.text.toString()
//            val updatePrice =binding.updatePrice.text.toString()
//            val updatePriority =binding.updatePriority.text.toString()
//            val updateDescription =binding.updateDesc.text.toString()
//
////            updateData(updateTitle,updatePrice,updatePriority,updateDescription)
//        }
//    }
//
//    private fun updateData(Title:String,name:String,price:String,priority:String,Description:String){
//        databaseReference=FirebaseDatabase.getInstance().getReference("plant_store")
//        val user = mapOf<String,String>("Title" to Title,"name" to name,"price" to price,"priority" to priority,"Description" to Description)
//        databaseReference.child(Title).updateChildren(user).addOnSuccessListener{
//            binding.updateTitle.text.clear()
//            binding.updatePrice.text.clear()
//            binding.updatePriority.text.clear()
//            binding.updateDesc.text.clear()
//            Toast.makeText(this@DeleteActivity,"Updated",Toast.LENGTH_SHORT).show()
//
//        }.addOnFailureListener {
//            Toast.makeText(this@DeleteActivity,"unable to update",Toast.LENGTH_SHORT).show()
//        }
//
//    }
//}