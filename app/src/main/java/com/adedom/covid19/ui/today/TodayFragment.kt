package com.adedom.covid19.ui.today

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.adedom.covid19.R
import com.adedom.covid19.base.BaseFragment
import com.adedom.covid19.util.extension.format
import com.adedom.covid19.util.extension.hide
import com.adedom.covid19.util.extension.show
import com.adedom.covid19.viewmodel.TodayViewModel
import kotlinx.android.synthetic.main.today_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TodayFragment : BaseFragment(R.layout.today_fragment) {

    val viewModel by viewModel<TodayViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.today.observe { response ->
            if (response == null) return@observe
            val (_, updateDate, confirmed, recovered, hospitalized, deaths, newConfirmed, newRecovered, newHospitalized, newDeaths, source, _, _) = response
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
        }

        viewModel.state.observe { state ->
            if (state.loading) progress_bar.show() else progress_bar.hide()
        }

        viewModel.attachFirstTime.observe {
            if (savedInstanceState == null) viewModel.fetchToday()
        }

        viewModel.error.observeError()
    }

}
