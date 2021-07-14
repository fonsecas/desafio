package com.picpay.desafio.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.entity.User
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class UserListIViewHolder(
    private val binding: ListItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.name.text = user.name
        binding.username.text = user.username
        binding.progressBar.visibility = View.VISIBLE
        Picasso.get()
            .load(user.img)
            .error(R.drawable.ic_round_account_circle)
            .into(binding.picture, object : Callback {
                override fun onSuccess() {
                    binding.progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    binding.progressBar.visibility = View.GONE
                }
            })
    }

    companion object {
        fun inflate(parent: ViewGroup) = UserListIViewHolder(
            ListItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}