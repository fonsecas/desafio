package com.picpay.desafio.android.presentation.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.picpay.desafio.android.domain.CoroutinesTestRule
import com.picpay.desafio.android.domain.entity.user.User
import com.picpay.desafio.android.domain.interector.IGetUsersList
import com.picpay.desafio.android.presentation.util.arch.SingleLiveEvent
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
    private lateinit var viewStateObserver: Observer<List<User?>?>

    @Before
    fun start() {
        viewModel = MainViewModel(
            interector
        ).apply {
            users.observeForever(viewStateObserver)
        }
    }


    //  |  Casos |                     Descrição                                              |
    //  |:-------|:---------------------------------------------------------------------------|
    //  | Caso 3 |   Dado um usuário acessando a listagem de usuários                         |
    //  |        |   Quando ele solicitar pelos usuários                                      |
    //  |        |   Então devemos assegurar que o sinal disparado é igual ao esperado        |

    @Test
    fun case3() {
        runBlocking {

            `when`(interector.getUsersList()).thenReturn(usersListMock)

            viewModel.getUsers()

            verify(viewStateObserver).onChanged(usersListMock)
        }
    }

}