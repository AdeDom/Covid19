package com.adedom.covid19.ui.sum

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.adedom.covid19.R
import com.adedom.covid19.base.BaseFragment
import com.adedom.covid19.util.extension.format
import com.adedom.covid19.util.extension.hide
import com.adedom.covid19.util.extension.show
import com.adedom.covid19.viewmodel.SumViewModel
import kotlinx.android.synthetic.main.sum_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SumFragment : BaseFragment(R.layout.sum_fragment) {

    val viewModel by viewModel<SumViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.sum.observe { response ->
            if (response == null) return@observe
            val (_, _, _, _, lastData, updateDate, source, _, _) = response
            tv_update_date.text = updateDate
            tv_last_data.text = lastData
            tv_source.text = source

            tv_source.setOnClickListener {
                Intent(Intent.ACTION_VIEW, Uri.parse(source)).apply {
                    startActivity(this)
                }
            }
        }

        viewModel.gender.observe { response ->
            if (response == null) return@observe

            val gender = "Male : ${response.male?.format()}\n" +
                    "Female : ${response.female?.format()}\n"
            tv_gender.text = gender
        }

        viewModel.nation.observe { response ->
            if (response == null) return@observe

            val thai = "Thai : ${response.thai?.format()}"
            tv_nation.text = thai
        }

        viewModel.province.observe { response ->
            if (response == null) return@observe

            val province = "Bangkok : ${response.bangkok}\n" +
                    "Samut Prakan : ${response.samutPrakan}\n" +
                    "Phayao : ${response.phayao}"
            tv_province.text = province
        }

        viewModel.state.observe { state ->
            if (state.loading) progress_bar.show() else progress_bar.hide()
        }

        viewModel.attachFirstTime.observe {
            if (savedInstanceState == null) viewModel.fetchSum()
        }

        viewModel.error.observeError()
    }

}
