package com.picpay.desafio.android.presentation.util.placeholder.types

import com.picpay.desafio.android.presentation.util.placeholder.Placeholder

class Loading : Placeholder {
    override val progressVisible: Boolean get() = true
    override val visible: Boolean get() = true
}