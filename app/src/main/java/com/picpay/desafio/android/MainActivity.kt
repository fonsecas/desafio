package com.picpay.desafio.android

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.entity.User

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserListAdapter

    private lateinit var binding: ActivityMainBinding
    val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdapter()
        subscribeUi()
    }

    private fun subscribeUi() {
        model.users.observe(this, ::onUserReceived)
    }
    private fun setupAdapter() {
        adapter = UserListAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun onUserReceived(userList: List<User>?) {
        adapter.submitList(userList)
    }
//    override fun onResume() {
//        super.onResume()
//
//      //  recyclerView = findViewById(R.id.recyclerView)
//        progressBar = findViewById(R.id.user_list_progress_bar)
//
//        //adapter = UserListAdapter()
//       // recyclerView.adapter = adapter
//      //  recyclerView.layoutManager = LinearLayoutManager(this)
//
//        progressBar.visibility = View.VISIBLE
//
//    }

}