package com.example.mvp_demo.modules.itemlist.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvp_demo.databinding.ActivityItemListBinding
import com.example.mvp_demo.modules.itemlist.interactors.ItemListInteractor
import com.example.mvp_demo.modules.itemlist.adapters.ItemAdapter
import com.example.mvp_demo.modules.itemlist.interfaces.ItemListContract
import com.example.mvp_demo.modules.itemlist.models.Item
import com.example.mvp_demo.modules.itemlist.presenters.ItemListPresenter

class ItemListActivity : AppCompatActivity(), ItemListContract.View {

    lateinit var binding: ActivityItemListBinding
    lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemListBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        val itemListPresenter = ItemListPresenter(this, ItemListInteractor())
        itemListPresenter.getItems()
    }

    private fun setRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvItems.adapter = itemAdapter
        binding.rvItems.layoutManager = linearLayoutManager
    }

    override fun showItems(itemsList: MutableList<Item>) {
        itemAdapter = ItemAdapter(itemsList)
        setRecyclerView()
    }

    override fun showError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}