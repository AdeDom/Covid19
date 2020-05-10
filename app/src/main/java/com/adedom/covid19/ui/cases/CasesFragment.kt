package com.adedom.covid19.ui.cases

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.covid19.R
import com.adedom.covid19.util.base.BaseFragment
import com.adedom.covid19.util.extension.hide
import com.adedom.covid19.util.extension.show
import kotlinx.android.synthetic.main.cases_fragment.*

class CasesFragment : BaseFragment<CasesViewModel>(R.layout.cases_fragment) {

    override fun viewModel() = CasesViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adt = CasesAdapter()
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adt
        }

        progress_bar.show()
        viewModel.fetchCases()

        viewModel.cases.observe(viewLifecycleOwner, Observer { response ->
            val (data, lastData, updateDate, source, _, _) = response
            progress_bar.hide()

            tv_update_date.text = updateDate
            tv_last_data.text = lastData
            tv_source.text = source

            tv_source.setOnClickListener {
                Intent(Intent.ACTION_VIEW, Uri.parse(source)).apply {
                    startActivity(this)
                }
            }

            data?.let { adt.setList(it) }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            progress_bar.hide()
            dialogError(it)
        })

    }

}
