package com.picpay.desafio.android.presentation

import androidx.lifecycle.Observer
import com.picpay.desafio.android.domain.CoroutinesTestRule
import com.picpay.desafio.android.domain.entity.user.User
import com.picpay.desafio.android.domain.use_case.GetUsersList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

internal class MainViewModelTest {

    @get:Rule
    val testCoroutineRule = CoroutinesTestRule()


    @Mock
    private lateinit var getUsersList: GetUsersList

    @Mock
    private lateinit var viewStateObserver: Observer<MainViewModel.MainViewState>

    @Before
    fun start() {
        MockitoAnnotations.openMocks(
            MainViewModel(
                getUsersList
            ).apply {
                users.observeForever(viewStateObserver)
            }
        )
    }

    @Test
    fun case1() {
        runBlocking {
            val data: List<User?>?
            `when`(getUsersList.execute().apply {
                data = this
            }).thenReturn(data)
            verify(viewStateObserver).onChanged(MainViewModel.MainViewState.Loading)
            verify(viewStateObserver).onChanged(MainViewModel.MainViewState.Success(data))
        }
    }

}