package com.picpay.desafio.android.domain.interector

import com.picpay.desafio.android.domain.boundary.UserRepository
import com.picpay.desafio.android.domain.entity.user.User
import com.picpay.desafio.android.src.usersListMock
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
internal class GetUsersListTest {

    @Mock
    private lateinit var interector: IGetUsersList

    @Mock
    private lateinit var mockedUserRepository: UserRepository

    @Mock
    private lateinit var mockUserList: List<User?>

    @Before
    fun start() {
        interector = GetUsersList(mockedUserRepository)
    }

    //  |  Casos |                     Descrição                                              |
    //  |:-------|:---------------------------------------------------------------------------|
    //  | Caso 1 |   Dado um usuário acessando a listagem de usuários                         |
    //  |        |   Quando ele solicitar pelos usuários                                      |
    //  |        |   Então devemos assegurar que a listagem obtida pela chamada será igual a  |
    //  |        |   retornada pelo repositório                                               |

    @Test
    fun case1() {
        runBlocking {

            `when`(mockedUserRepository.getUsersList()).thenReturn(mockUserList)

            val currentSUT = interector.getUsersList()

           assert(currentSUT == mockUserList)
        }
    }

    //  |  Casos |                     Descrição                                              |
    //  |:-------|:---------------------------------------------------------------------------|
    //  | Caso 2 |   Dado um usuário acessando a listagem de usuários                         |
    //  |        |   Quando ele solicitar pelos usuários                                      |
    //  |        |   Então devemos assegurar que o repositorio sera chamado                   |

    @Test
    fun case2() {
        runBlocking {
            interector.getUsersList()
            verify(mockedUserRepository).getUsersList()
        }
    }
}