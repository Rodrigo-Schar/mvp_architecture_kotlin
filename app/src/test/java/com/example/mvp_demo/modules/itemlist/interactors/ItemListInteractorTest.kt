package com.example.mvp_demo.modules.itemlist.interactors

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

//@RunWith(AndroidJUnit4::class)
internal class ItemListInteractorTest: TestCase() {
    private lateinit var interator: ItemListInteractor

    @Before
    public override fun setUp() {
        super.setUp()
        interator = ItemListInteractor()
    }

    @Test
    fun testLoadItems() {
        interator.itemList = interator.loadItems()

        assertEquals(interator.itemList.count(), 10)
    }

    @Test
    fun testLoadItemsApiSuccess() {
        interator.BASE_URL = "https://jsonplaceholder.typicode.com/"
        interator.loadItemsFromApi({
            itemList -> assertEquals(itemList.size, 25)
        }, {
            errorMessage -> assertNull(errorMessage)
        })
    }

    @Test
    fun testLoadItemsApiFailure() {
        interator.BASE_URL = "https://jsonplaceholder.typicode./"
        interator.loadItemsFromApi({
                itemList -> assertEquals(itemList.size, 0)
        }, {
                errorMessage -> assertNotNull(errorMessage)
        })
    }
}