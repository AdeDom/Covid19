package com.adedom.covid19.ui.timeline

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.covid19.R
import com.adedom.covid19.base.BaseFragment
import com.adedom.covid19.util.extension.hide
import com.adedom.covid19.util.extension.show
import com.adedom.covid19.viewmodel.TimelineViewModel
import kotlinx.android.synthetic.main.timeline_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TimelineFragment : BaseFragment(R.layout.timeline_fragment) {

    val viewModel by viewModel<TimelineViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adt = TimelineAdapter()

        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adt
        }

        viewModel.timeline.observe { response ->
            if (response == null) return@observe
            val (_, updateDate, source, _, _, data) = response
            tv_update_date.text = updateDate
            tv_source.text = source

            tv_source.setOnClickListener {
                Intent(Intent.ACTION_VIEW, Uri.parse(source)).apply {
                    startActivity(this)
                }
            }

            data?.reversed()?.let { adt.setList(it) }
        }

        viewModel.state.observe { state ->
            if (state.loading) progress_bar.show() else progress_bar.hide()
        }

        viewModel.attachFirstTime.observe {
            if (savedInstanceState == null) viewModel.fetchTimeline()
        }

        viewModel.error.observeError()
    }

}
