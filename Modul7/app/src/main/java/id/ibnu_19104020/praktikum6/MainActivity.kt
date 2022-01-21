package id.ibnu_19104020.praktikum6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.ibnu_19104020.praktikum6.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<MyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(getListMyDatas())
        showRecyclerList()
    }

    fun getListMyDatas(): ArrayList<MyData> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataLat = resources.getStringArray(R.array.data_lat)
        val dataLong = resources.getStringArray(R.array.data_lang)

        val listMyData = ArrayList<MyData>()
        for (position in dataName.indices) {
            val myData = MyData(
                dataName[position],
                dataDescription[position],
                dataPhoto[position],
                dataLat[position].toDouble(),
                dataLong[position].toDouble()
            )
            listMyData.add(myData)
        }
        return listMyData
    }

    private fun showRecyclerList() {
        binding.apply {
            rv_pariwisata.layoutManager = LinearLayoutManager(this@MainActivity)
            val listMyDataAdapter = MainAdapter(this@MainActivity, list)
            rv_pariwisata.adapter = listMyDataAdapter
        }
    }
}