package com.adedom.covid19.ui.cases

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.covid19.R
import com.adedom.covid19.base.BaseFragment
import com.adedom.covid19.util.extension.hide
import com.adedom.covid19.util.extension.show
import com.adedom.covid19.viewmodel.CasesViewModel
import kotlinx.android.synthetic.main.cases_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CasesFragment : BaseFragment(R.layout.cases_fragment) {

    val viewModel by viewModel<CasesViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adt = CasesAdapter()
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adt
        }

        viewModel.state.observe { state ->
            if (state.loading) progress_bar.show() else progress_bar.hide()

            val (data, lastData, updateDate, source, _, _) = state.cases
            tv_update_date.text = updateDate
            tv_last_data.text = lastData
            tv_source.text = source

            tv_source.setOnClickListener {
                Intent(Intent.ACTION_VIEW, Uri.parse(source)).apply {
                    startActivity(this)
                }
            }

            data?.let { adt.setList(it) }
        }

        viewModel.attachFirstTime.observe {
            if (savedInstanceState == null) viewModel.fetchCases()
        }

        viewModel.error.observeError()

    }

}
