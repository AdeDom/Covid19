package com.adedom.covid19.ui.timeline

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.covid19.R
import com.adedom.covid19.util.base.BaseFragment
import com.adedom.covid19.util.extension.hide
import com.adedom.covid19.util.extension.show
import kotlinx.android.synthetic.main.timeline_fragment.*

class TimelineFragment : BaseFragment<TimelineViewModel>(R.layout.timeline_fragment) {

    override fun viewModel() = TimelineViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adt = TimelineAdapter()

        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adt
        }

        progress_bar.show()
        viewModel.fetchTimeline()

        viewModel.timeline.observe(viewLifecycleOwner, Observer { response ->
            if (response == null) return@Observer
            progress_bar.hide()
            val (_, updateDate, source, _, _, data) = response

            tv_update_date.text = updateDate
            tv_source.text = source

            tv_source.setOnClickListener {
                Intent(Intent.ACTION_VIEW, Uri.parse(source)).apply {
                    startActivity(this)
                }
            }

            data?.reversed()?.let { adt.setList(it) }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            progress_bar.hide()
            dialogError(it)
        })
    }

}
