package com.example.androidbootcamp2021

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.internal.inject.InstrumentationContext
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnit
import org.mockito.runners.MockitoJUnitRunner

/**
 * Mockito Unit Testing [Not completed]
 * TODO
 */
@RunWith(MockitoJUnitRunner::class)
class MainActivityTest {

    lateinit var mockedItemRepository: ItemRepository
    @Mock
    lateinit var context: Context

    @Before
    fun setup() {
        context = InstrumentationRegistry.getInstrumentation().context
        mockedItemRepository = mock(ItemRepository(context)::class.java)
    }

    @Test
    fun ifItemIsFavorite_ShouldReturnTrue() {
        `when`(mockedItemRepository.getFavoriteItem()).thenReturn(MutableLiveData(true))
        val actualResult = mockedItemRepository.getFavoriteItem().value
        assert(actualResult == true)
    }

    @Test
    fun ifItemIsNotFavorite_ShouldReturnFalse() {
        Mockito.`when`(mockedItemRepository.getFavoriteItem()).thenReturn(MutableLiveData(false))
        val actualResult = mockedItemRepository.getFavoriteItem()
        assert(actualResult.value == false)
    }
}