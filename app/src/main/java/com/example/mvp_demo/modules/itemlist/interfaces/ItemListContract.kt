package com.example.mvp_demo.modules.itemlist.interfaces

import com.example.mvp_demo.modules.itemlist.models.Item
import java.util.*
import javax.xml.transform.ErrorListener

interface ItemListContract {

    interface View {
        fun showItems(itemsList: MutableList<Item>)
        fun showError(message: String)
    }

    interface Presenter {
        fun getItems()
    }

    interface Interactor {
        fun loadItems() : MutableList<Item>
        fun loadItemsFromApi(succesListener: (MutableList<Item>) -> Unit, errorListener: (String) -> Unit) //: MutableList<Item>
    }
}