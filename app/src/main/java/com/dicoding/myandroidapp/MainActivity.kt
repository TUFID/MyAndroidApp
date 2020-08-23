package com.dicoding.myandroidapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvLaptop: RecyclerView
    private var list: ArrayList<Laptop> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "MyLaptop"

        rvLaptop = findViewById(R.id.rv_laptop)
        rvLaptop.setHasFixedSize(true)

        list.addAll(LaptopData.listData)
        showRecyclerList()
    }


    private fun showRecyclerList() {
        rvLaptop.layoutManager = LinearLayoutManager(this)
        val listLaptopAdapter = ListLaptopAdapter(list)
        rvLaptop.adapter = listLaptopAdapter

        listLaptopAdapter.setOnItemClickCallback(object : ListLaptopAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Laptop) {
                showSelectedLaptop(data)
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }

            R.id.action_grid -> {
                val gridLaptopAdapter = Intent(this@MainActivity, GridLaptopAdapter::class.java)
                startActivity(gridLaptopAdapter)
            }


            R.id.about -> {
                val about = Intent(this@MainActivity, About::class.java)
                startActivity(about)
            }

        }
    }

    private fun showSelectedLaptop(laptop: Laptop) {
        Toast.makeText(this, "Kamu memilih " + laptop.name, Toast.LENGTH_SHORT).show()
        val moveWithDataIntent = Intent(this@MainActivity, Detail::class.java)
        moveWithDataIntent.putExtra(Detail.EXTRA_NAME, "")
        moveWithDataIntent.putExtra(Detail.EXTRA_PHOTO, 0)
        moveWithDataIntent.putExtra(Detail.EXTRA_DETAIL, "")
        startActivity(moveWithDataIntent)
    }



}
