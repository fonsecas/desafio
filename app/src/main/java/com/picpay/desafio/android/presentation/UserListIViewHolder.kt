package com.picpay.desafio.android.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.domain.entity.user.User

class UserListIViewHolder(
    private val binding: ListItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.name.text = user.name
        binding.username.text = user.username
        Glide
            .with(binding.root.context)
            .load(user.img.toUri())
            .circleCrop()
            .into(binding.picture)
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