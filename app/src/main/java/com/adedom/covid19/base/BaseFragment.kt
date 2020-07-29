package com.adedom.covid19.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.adedom.covid19.util.extension.toast

abstract class BaseFragment(@LayoutRes private val layout: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layout, container, false)

    protected inline fun <reified T> LiveData<T>.observe(crossinline onNext: (T) -> Unit) {
        observe(this@BaseFragment, Observer { onNext(it) })
    }

    protected fun LiveData<Throwable>.observeError() {
        observe(this@BaseFragment, Observer {
            it?.printStackTrace()
            context?.toast("Error : ${it.message}")
        })
    }

}
