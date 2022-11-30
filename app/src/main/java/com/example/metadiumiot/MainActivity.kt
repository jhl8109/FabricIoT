package com.example.metadiumiot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.metahackathon.ItemClickListener
import com.example.metahackathon.MyRecyclerViewAdapter
import com.example.metahackathon.RecyclerViewData
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Smart Devices"
        // create an instance of the Normal Floating Action Button
        // and register with the appropriate ID
        val fab: ExtendedFloatingActionButton = findViewById(R.id.extendedFAB)

        //get extra && make data list

        // create instance of RecyclerView and register with the appropriate ID
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // create list of RecyclerViewData
        var recyclerViewData = listOf<RecyclerViewData>()
        recyclerViewData = recyclerViewData + RecyclerViewData("1", "One")
        recyclerViewData = recyclerViewData + RecyclerViewData("2", "Two")
        recyclerViewData = recyclerViewData + RecyclerViewData("3", "Three")
        recyclerViewData = recyclerViewData + RecyclerViewData("4", "Four")
        recyclerViewData = recyclerViewData + RecyclerViewData("5", "Five")
        recyclerViewData = recyclerViewData + RecyclerViewData("6", "Six")
        recyclerViewData = recyclerViewData + RecyclerViewData("7", "Seven")
        recyclerViewData = recyclerViewData + RecyclerViewData("8", "Eight")
        recyclerViewData = recyclerViewData + RecyclerViewData("9", "Nine")
        recyclerViewData = recyclerViewData + RecyclerViewData("10", "Ten")
        recyclerViewData = recyclerViewData + RecyclerViewData("11", "Eleven")
        recyclerViewData = recyclerViewData + RecyclerViewData("12", "Twelve")
        recyclerViewData = recyclerViewData + RecyclerViewData("13", "Thirteen")
        recyclerViewData = recyclerViewData + RecyclerViewData("14", "Fourteen")
        recyclerViewData = recyclerViewData + RecyclerViewData("15", "Fifteen")

        // create a vertical layout manager
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // create instance of MyRecyclerViewAdapter
        val myRecyclerViewAdapter = MyRecyclerViewAdapter(recyclerViewData)

        // attach the adapter to the recycler view
        recyclerView.adapter = myRecyclerViewAdapter

        // also attach the layout manager
        recyclerView.layoutManager = layoutManager

        // make the adapter the data set
        // changed for the recycler view
        myRecyclerViewAdapter.notifyDataSetChanged()

        //
        myRecyclerViewAdapter.setItemClickListener(object : ItemClickListener{
            override fun onClick(value: RecyclerViewData) {
                makeToast("cliecked")
            }
        })
        fab.setOnClickListener {
            val dialog = HomeDialog(this)
            dialog.showDialog()
//            val intent = Intent(applicationContext, FormActivity::class.java)
//            // put extra
//            intent.putExtra("from", "smartHome")
//            startActivity(intent)
        }

        // now creating the scroll listener
        // for the recycler view
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // if the recycler view is scrolled
                // above shrink the FAB
                if (dy > 10 && fab.isExtended) {
                    fab.shrink()
                }

                // if the recycler view is scrolled
                // above extend the FAB
                if (dy < -10 && !fab.isExtended) {
                    fab.extend()
                }

                // of the recycler view is at the first
                // item always extend the FAB
                if (!recyclerView.canScrollVertically(-1)) {
                    fab.extend()
                }
            }
        })
    }

    private fun makeToast(message: String) {
        runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}