package com.adedom.covid19.util.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adedom.covid19.data.db.AppDatabase
import com.adedom.covid19.data.networks.Covid19Api
import com.adedom.covid19.data.networks.NetworkConnectionInterceptor
import com.adedom.covid19.data.repositories.Covid19Repository

abstract class BaseFragment<VM : ViewModel>(private val layout: Int) : Fragment() {

    protected lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layout, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = Covid19Api.invoke(NetworkConnectionInterceptor(requireContext()))
        val db = AppDatabase.invoke(requireContext())
        val repository = Covid19Repository(api, db)
        val factory = BaseViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(viewModel())
    }

    abstract fun viewModel(): Class<VM>

    protected fun dialogError(message: String) = AlertDialog.Builder(requireContext()).apply {
        setTitle("Error")
        setMessage(message)
            .setPositiveButton(android.R.string.ok) { dialog, which ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

}
