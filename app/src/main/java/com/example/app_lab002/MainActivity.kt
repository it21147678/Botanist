package com.example.app_lab002

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.app_lab002.databinding.ActivityMainBinding
import com.google.firebase.database.*

class MainActivity : AppCompatActivity(),PlantClickListener {
//class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dataList: ArrayList<DataClass>
    private lateinit var adapter:MyAdapter

   var databaseReference: DatabaseReference? =null
    var eventListener: ValueEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gridLayoutManager=GridLayoutManager(this@MainActivity,1)
       binding.recyclerView2.layoutManager =gridLayoutManager

       val builder = AlertDialog.Builder(this@MainActivity)
        builder.setCancelable(false)
        builder.setView(R.layout.progress_layout)
        val dialog = builder.create()
        dialog.show()

        dataList = ArrayList()
        adapter= MyAdapter(this@MainActivity,dataList)
        binding.recyclerView2.adapter =adapter
        databaseReference = FirebaseDatabase.getInstance().getReference("plant_store")
        dialog.show()

        eventListener=databaseReference!!.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for(itemSnapshot in snapshot.children){
                    val dataClass = itemSnapshot.getValue(DataClass::class.java)
                    if(dataClass != null){
                        dataList.add(dataClass)
                    }
                }
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                dialog.dismiss()
            }

        })



        //fab button
        binding.fab.setOnClickListener {
            val intent = Intent(this, UploadActivity::class.java)
            startActivity(intent)
        }
        //fab button !

        binding.search.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchList(newText)
                return true
            }

        })
//    }
//}


        populatePlants()
        val mainActivity = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = CardAdapter(plantList,mainActivity)
        }
    }

    fun searchList(text:String){
        val searchList = ArrayList<DataClass>()
        for(dataClass in dataList){
            if(dataClass.dataTitle?.lowercase()?.contains(text.lowercase()) == true){
                searchList.add(dataClass)
            }
        }
        adapter.searchDataList(searchList)
    }

    override fun onClick(plant: Plant) {
        val intent= Intent(applicationContext,DetailActivity::class.java)
        intent.putExtra(PLANT_ID_EXTRA,plant.id)
        startActivity(intent)
    }

    private fun populatePlants()
    {
//        val plant1 = Plant(
//            R.drawable.plant3,
//            plantname = "Thai Mulberry",
//            title = "Thai Mulberry",
//            description = "Mulberries are fast-growing when young, and can grow to 24 metres (79 feet) " +
//                    "tall.  The leaves are alternately arranged, simple, and often lobed and " +
//                    "serrated on the margin. Lobes are more common on juvenile shoots than on mature" +
//                    " trees.  The trees can be monoecious or dioecious.[5]"
//
//        )
//        plantList.add(plant1)
//
//        val plant2 = Plant(
//            R.drawable.plant3,
//            plantname = "Thai Mulberry",
//            title = "Thai Mulberry",
//            description = "Mulberries are fast-growing when young, and can grow to 24 metres (79 feet) " +
//                    "tall.  The leaves are alternately arranged, simple, and often lobed and " +
//                    "serrated on the margin. Lobes are more common on juvenile shoots than on mature" +
//                    " trees.  The trees can be monoecious or dioecious.[5]"
//
//        )
//        plantList.add(plant2)
//
        val plant3 = Plant(
            R.drawable.plant6,
            plantname = "Sri lankan guava",
            title = "wild berry guava",
            description = "Mulberries are fast-growing when young, and can grow to 24 metres (79 feet) " +
                    "tall.  The leaves are alternately arranged, simple, and often lobed and " +
                    "serrated on the margin. Lobes are more common on juvenile shoots than on mature" +
                    " trees.  The trees can be monoecious or dioecious.[5]"



        )
        plantList.add(plant3)
//
        val plant4 = Plant(
            R.drawable.plant6,
            plantname = "Thai Mulberry",
            title = "Thai Mulberry",
            description = "Mulberries are fast-growing when young, and can grow to 24 metres (79 feet) " +
                    "tall.  The leaves are alternately arranged, simple, and often lobed and " +
                    "serrated on the margin. Lobes are more common on juvenile shoots than on mature" +
                    " trees.  The trees can be monoecious or dioecious.[5]"

        )
        plantList.add(plant4)
//
//        val plant5 = Plant(
//            R.drawable.plant3,
//            plantname = "Thai Mulberry",
//            title = "Thai Mulberry | තායි මල්බෙරි",
//            description = "Mulberries are fast-growing when young, and can grow to 24 metres (79 feet) " +
//                    "tall.  The leaves are alternately arranged, simple, and often lobed and " +
//                    "serrated on the margin. Lobes are more common on juvenile shoots than on mature" +
//                    " trees.  The trees can be monoecious or dioecious.[5]"
//
//        )
//        plantList.add(plant5)
//
        val plant6 = Plant(
            R.drawable.plant6,
            plantname = "Custard Orange",
            title = "Native Custard Orange ",
            description = "Custard apple is a common name for a fruit and for the tree that " +
                    "bears it, Annona reticulata.\n" +
                    "\n" +
                    "The tree’s fruits vary in shape; they may be heart-shaped, spherical, " +
                    "oblong or irregular. Their size ranges from 7 to 12 cm (2.8 to 4.7 in), " +
                    "depending on the cultivar. When ripe, the fruit is brown or yellowish, " +
                    "The custard apple is native to India, but has also been found to have " +
                    "grown on the island of Timor as early as 1000 CE."

        )
        plantList.add(plant6)
//
//        val plant7 = Plant(
//            R.drawable.plant1,
//            plantname = "plant 7",
//            title = "plant 7 for sale",
//            description = "Custard apple is a common name for a fruit and for the tree that " +
//                    "bears it, Annona reticulata.\n" +
//                    "\n" +
//                    "The tree’s fruits vary in shape; they may be heart-shaped, spherical, " +
//                    "oblong or irregular. Their size ranges from 7 to 12 cm (2.8 to 4.7 in), " +
//                    "depending on the cultivar. When ripe, the fruit is brown or yellowish, " +
//                    "The custard apple is native to India, but has also been found to have " +
//                    "grown on the island of Timor as early as 1000 CE."
//
//        )
//        plantList.add(plant7)
//
//        val plant8 = Plant(
//            R.drawable.plant8,
//            plantname = "plant 8",
//            title = "plant 8 for sale",
//            description = "Custard apple is a common name for a fruit and for the tree that " +
//                    "bears it, Annona reticulata.\n" +
//                    "\n" +
//                    "The tree’s fruits vary in shape; they may be heart-shaped, spherical, " +
//                    "oblong or irregular. Their size ranges from 7 to 12 cm (2.8 to 4.7 in), " +
//                    "depending on the cultivar. When ripe, the fruit is brown or yellowish, " +
//                    "The custard apple is native to India, but has also been found to have " +
//                    "grown on the island of Timor as early as 1000 CE."
//
//        )
 //       plantList.add(plant8)

        val plant9 = Plant(
            R.drawable.plant9,
            plantname = "Korcensetia",
            title = "Ever green",
            description = "Custard korcensetiae is a common name for a ornamental plant and for the tree that " +
                    "bears it, Annona reticulata.\n" +
                    "\n" +
                    "The tree’s fruits vary in shape; they may be heart-shaped, spherical, " +
                    "oblong or irregular. Their size ranges from 7 to 12 cm (2.8 to 4.7 in), " +
                    "depending on the cultivar. When ripe, the fruit is brown or yellowish, " +
                    "The custard apple is native to India, but has also been found to have " +
                    "grown on the island of Timor as early as 1000 CE."

        )
        plantList.add(plant9)

    }


}