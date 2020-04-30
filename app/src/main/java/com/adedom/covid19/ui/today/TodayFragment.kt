package com.adedom.covid19.ui.today

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import com.adedom.covid19.R
import com.adedom.covid19.util.base.BaseFragment
import com.adedom.covid19.util.extension.format
import com.adedom.covid19.util.extension.hide
import com.adedom.covid19.util.extension.show
import kotlinx.android.synthetic.main.today_fragment.*

class TodayFragment : BaseFragment<TodayViewModel, TodayFactory>(R.layout.today_fragment) {

    override fun viewModel() = TodayViewModel::class.java

    override fun factory() = TodayFactory(repository)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        progress_bar.show()
        viewModel.fetchToday()

        viewModel.today.observe(viewLifecycleOwner, Observer { response ->
            if (response == null) return@Observer
            val (_, updateDate, confirmed, recovered, hospitalized, deaths, newConfirmed, newRecovered, newHospitalized, newDeaths, source, _, _) = response
            progress_bar.hide()
            tv_update_date.text = updateDate
            tv_confirmed.text = confirmed?.format()
            tv_new_confirmed.text = newConfirmed?.format()
            tv_recovered.text = recovered?.format()
            tv_new_recovered.text = newRecovered?.format()
            tv_hospitalized.text = hospitalized?.format()
            tv_new_hospitalized.text = newHospitalized?.format()
            tv_deaths.text = deaths?.format()
            tv_new_deaths.text = newDeaths?.format()
            tv_source.text = source

            tv_source.setOnClickListener {
                Intent(Intent.ACTION_VIEW, Uri.parse(source)).also { intent ->
                    startActivity(intent)
                }
            }

        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            progress_bar.hide()
            dialogError(it)
        })
    }

}
