package com.picpay.desafio.android.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.picpay.desafio.android.domain.CoroutinesTestRule
import com.picpay.desafio.android.domain.entity.user.User
import com.picpay.desafio.android.domain.use_case.IGetUsersList
import com.picpay.desafio.android.src.usersListMock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class MainViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val testCoroutineRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Mock
    private lateinit var interector: IGetUsersList

    @Mock
    private lateinit var viewStateObserver: Observer<List<User?>>

    @Before
    fun start() {
        viewModel = MainViewModel(
            interector
        ).apply {
            users.observeForever(viewStateObserver)
        }
    }

    @Test
    fun case4() {
        runBlocking {

            //Antes
            `when`(interector.getUsersList()).thenReturn(usersListMock)

            //Quando
            viewModel.getUsers()

            //Entao
            verify(viewStateObserver).onChanged(usersListMock)
        }
    }
}