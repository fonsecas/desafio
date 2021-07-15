package com.picpay.desafio.android.presentation.util.placeholder

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.picpay.desafio.android.databinding.LoadingPlaceholderBinding

class PlaceholderView constructor(
    context: Context,
    attrs: AttributeSet
) : FrameLayout(context, attrs) {

    private lateinit var binding: LoadingPlaceholderBinding
    private val layoutInflater by lazy { LayoutInflater.from(context) }

    init {
        loadBinding()
    }

    fun setPlaceholder(placeholder: Placeholder?) {
        placeholder?.let { _placeholder ->
            setBaseVariables(_placeholder)
        }
    }

    private fun loadBinding() {
        binding = LoadingPlaceholderBinding.inflate(layoutInflater, this, true)
    }

    private fun setBaseVariables(placeholder: Placeholder) {
        binding.run {
            visible = placeholder.visible
            progressVisible = placeholder.progressVisible
        }
    }
}