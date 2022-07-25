package com.example.mvp_demo.modules.itemlist.interactors

import com.example.mvp_demo.modules.itemlist.interfaces.ApiInterface
import com.example.mvp_demo.modules.itemlist.interfaces.ItemListContract
import com.example.mvp_demo.modules.itemlist.models.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItemListInteractor: ItemListContract.Interactor {

    var itemList = mutableListOf<Item>()
    var BASE_URL = "https://jsonplaceholder.typicode.com/"

    override fun loadItems() : MutableList<Item> {
        val itemList = mutableListOf<Item>()

        itemList.add(Item(1,1,"sunt aut facere repellat provident occaecati excepturi optio reprehenderit","quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"))
        itemList.add(Item(1,2,"qui est esse","est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla"))
        itemList.add(Item(1,3,"ea molestias quasi exercitationem repellat qui ipsa sit aut","et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut"))
        itemList.add(Item(1,4,"eum et est occaecati","ullam et saepe reiciendis voluptatem adipisci\\nsit amet autem assumenda provident rerum culpa\\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\\nquis sunt voluptatem rerum illo velit"))
        itemList.add(Item(1,5,"nesciunt quas odio","repudiandae veniam quaerat sunt sed\\nalias aut fugiat sit autem sed est\\nvoluptatem omnis possimus esse voluptatibus quis\\nest aut tenetur dolor neque"))
        itemList.add(Item(1,6,"dolorem eum magni eos aperiam quia","ut aspernatur corporis harum nihil quis provident sequi\\nmollitia nobis aliquid molestiae\\nperspiciatis et ea nemo ab reprehenderit accusantium quas\\nvoluptate dolores velit et doloremque molestiae"))
        itemList.add(Item(1,7,"magnam facilis autem","dolore placeat quibusdam ea quo vitae\\nmagni quis enim qui quis quo nemo aut saepe\\nquidem repellat excepturi ut quia\\nsunt ut sequi eos ea sed quas"))
        itemList.add(Item(1,8,"dolorem dolore est ipsam","dignissimos aperiam dolorem qui eum\\nfacilis quibusdam animi sint suscipit qui sint possimus cum\\nquaerat magni maiores excepturi\\nipsam ut commodi dolor voluptatum modi aut vitae"))
        itemList.add(Item(1,9,"nesciunt iure omnis dolorem tempora et accusantium","consectetur animi nesciunt iure dolore\\nenim quia ad\\nveniam autem ut quam aut nobis\\net est aut quod aut provident voluptas autem voluptas"))
        itemList.add(Item(1,10,"optio molestias id quia eum","quo et expedita modi cum officia vel magni\\ndoloribus qui repudiandae\\nvero nisi sit\\nquos veniam quod sed accusamus veritatis error"))

        return itemList

    }

    override fun loadItemsFromApi(succesListener: (MutableList<Item>) -> Unit, errorListener: (String) -> Unit) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<MutableList<Item>?> {
            override fun onResponse(call: Call<MutableList<Item>?>, response: Response<MutableList<Item>?>) {
                val responseBody = response.body()
                itemList = responseBody ?: return
                succesListener(itemList)
            }

            override fun onFailure(call: Call<MutableList<Item>?>, t: Throwable) {
                errorListener("An error ocurred")
            }
        })
    }
}