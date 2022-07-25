package com.example.mvp_demo.modules.itemlist.presenters

import com.example.mvp_demo.modules.itemlist.interfaces.ItemListContract

class ItemListPresenter(private val itemListView: ItemListContract.View,
                        private val itemListInteractor: ItemListContract.Interactor) : ItemListContract.Presenter {

    override fun getItems() {
        //val itemList = itemListInteractor.loadItemsFromApi()
        //itemListView.showItems(itemLists)

        itemListInteractor.loadItemsFromApi({
            itemList ->
            itemListView.showItems(itemList)
        }, {
            errorMessage ->
            itemListView.showError(errorMessage)
        })
    }

}