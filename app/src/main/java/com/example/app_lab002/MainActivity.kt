package com.example.app_lab002

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.app_lab002.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),PlantClickListener
{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populatePlants()
        val mainActivity = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = CardAdapter(plantList,mainActivity)
        }
    }

    override fun onClick(plant: Plant) {
        val intent= Intent(applicationContext,DetailActivity::class.java)
        intent.putExtra(PLANT_ID_EXTRA,plant.id)
        startActivity(intent)
    }

    private fun populatePlants()
    {
        val plant1 = Plant(
            R.drawable.plant9,
            plantname = "Pachira Plant",
            title = "Pachira Plant | පැචිර",
            description = "Pachira aquatica can grow up to 18 m (59.1 ft) in height in the wild." +
                    " It has shiny green palmate leaves with lanceolate leaflets and smooth green bark." +
                    " This species forms a slightly thickened root," +
                    " which also serves as a water reservoir. "

        )
        plantList.add(plant1)

        val plant2 = Plant(
            R.drawable.plant2,
            plantname = "Red Custard Apple",
            title = "Red Custard Apple | රතු සීනි අනෝදා",
            description = "Custard apple is a common name for a fruit and for the tree that bears it," +
                    " Annona reticulata.\n" +
                    "\n" +
                    "The tree’s fruits vary in shape; they may be heart-shaped, spherical, oblong or " +
                    "irregular. Their size ranges from 7 to 12 cm (2.8 to 4.7 in), depending on the" +
                    "The custard apple is native to India, but has also been found to have grown on" +
                    " the island of Timor as early as 1000 CE"

        )
        plantList.add(plant2)

        val plant3 = Plant(
            R.drawable.plant3,
            plantname = "Thai Mulberry",
            title = "Thai Mulberry | තායි මල්බෙරි",
            description = "Mulberries are fast-growing when young, and can grow to 24 metres (79 feet) " +
                    "tall.  The leaves are alternately arranged, simple, and often lobed and " +
                    "serrated on the margin. Lobes are more common on juvenile shoots than on mature" +
                    " trees.  The trees can be monoecious or dioecious.[5]"



        )
        plantList.add(plant3)

        val plant4 = Plant(
            R.drawable.plant4,
            plantname = "Malaysian Seedless Jackfruit | බීජ රහිත කොස් – පැල ",
            title = "Malaysian Seedless Jackfruit",
            description = "Artocarpus heterophyllus grows as an evergreen tree that has a relatively short" +
                    " trunk and dense treetop. It easily reaches heights of 10 to 20 m (33 to 66 feet) and" +
                    " trunk diameters of 30 to 80 cm (12 to 31 inches). It sometimes forms buttress roots." +
                    " The bark of the jackfruit tree is reddish-brown and smooth. In the event of injury" +
                    " to the bark, a milky sap is released.\n"

        )
        plantList.add(plant4)

        val plant5 = Plant(
            R.drawable.plant5,
            plantname = "Ceylon Red Guava | දේශීය රතු පේර",
            title = "Ceylon Red Guava | දේශීය රතු පේර",
            description = "Guava fruits, usually 4 to 12 centimetres (1+1⁄2 to 4+1⁄2 in) long, are round " +
                    "or oval depending on the species.[2] They have a pronounced and typical fragrance," +
                    " similar to lemon rind but less sharp. The outer skin may be rough, often with a " +
                    "bitter taste, or soft and sweet. Varying between species, in number " +
                    "and hardness, depending on species."

        )
        plantList.add(plant5)

        val plant6 = Plant(
            R.drawable.plant6,
            plantname = "Red Custard Apple",
            title = "Red Custard Apple | රතු සීනි අනෝදා",
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

        val plant7 = Plant(
            R.drawable.plant1,
            plantname = "plant 7",
            title = "plant 7 for sale",
            description = "enter something"

        )
        plantList.add(plant7)

        val plant8 = Plant(
            R.drawable.plant8,
            plantname = "plant 8",
            title = "plant 8 for sale",
            description = "plant a wery googofvfdbdf fd ddgkmgdfm fdmdb mdfdf mfgdmk mg d dmffmk fdmb dmbdm dmbbm dbdm dbd dddm t t t mdbtt gbtbtbtb"

        )
        plantList.add(plant8)

        val plant9 = Plant(
            R.drawable.plant9,
            plantname = "plant 9",
            title = "plant 9 for sale",
            description = "plant a wery googofvfdbdf fd ddgkmgdfm fdmdb mdfdf mfgdmk mg d dmffmk fdmb dmbdm dmbbm dbdm dbd dddm t t t mdbtt gbtbtbtb"

        )
        plantList.add(plant9)



        plantList.add(plant1)
        plantList.add(plant2)
        plantList.add(plant3)
        plantList.add(plant4)
        plantList.add(plant5)
        plantList.add(plant6)
        plantList.add(plant7)
        plantList.add(plant8)
        plantList.add(plant9)
    }


}