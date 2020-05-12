package com.adedom.covid19.ui.sum

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import com.adedom.covid19.R
import com.adedom.covid19.util.base.BaseFragment
import com.adedom.covid19.util.extension.format
import com.adedom.covid19.util.extension.hide
import com.adedom.covid19.util.extension.show
import kotlinx.android.synthetic.main.sum_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SumFragment : BaseFragment(R.layout.sum_fragment) {

    val viewModel: SumViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        progress_bar.show()
        viewModel.fetchSum()

        viewModel.sum.observe(viewLifecycleOwner, Observer { response ->
            if (response == null) return@Observer
            val (_, _, _, _, lastData, updateDate, source, _, _) = response
            progress_bar.hide()

            tv_update_date.text = updateDate
            tv_last_data.text = lastData
            tv_source.text = source

            tv_source.setOnClickListener {
                Intent(Intent.ACTION_VIEW, Uri.parse(source)).apply {
                    startActivity(this)
                }
            }
        })

        viewModel.gender.observe(viewLifecycleOwner, Observer { response ->
            if (response == null) return@Observer
            progress_bar.hide()

            val gender = "Male : ${response.male?.format()}\n" +
                    "Female : ${response.female?.format()}\n"
            tv_gender.text = gender
        })

        viewModel.nation.observe(viewLifecycleOwner, Observer { response ->
            if (response == null) return@Observer
            progress_bar.hide()

            val thai = "Thai : ${response.thai?.format()}"
            tv_nation.text = thai
        })

        viewModel.province.observe(viewLifecycleOwner, Observer { response ->
            if (response == null) return@Observer
            progress_bar.hide()

            val province = "Bangkok : ${response.bangkok}\n" +
                    "Samut Prakan : ${response.samutPrakan}\n" +
                    "Phayao : ${response.phayao}"
            tv_province.text = province
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            progress_bar.hide()
            dialogError(it)
        })
    }

}
