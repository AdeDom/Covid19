package com.adedom.covid19.ui.timeline

import android.view.View
import com.adedom.covid19.R
import com.adedom.covid19.data.models.TimelineData
import com.adedom.covid19.base.BaseRecyclerView
import com.adedom.covid19.util.extension.format
import kotlinx.android.synthetic.main.item_timeline.view.*

class TimelineAdapter : BaseRecyclerView<TimelineData>() {

    override fun getLayout() = R.layout.item_timeline

    override fun View.onBindViewHolder(data: TimelineData) {
        val (date, newConfirmed, newRecovered, newHospitalized, newDeaths, confirmed, recovered, hospitalized, deaths) = data
        tv_date.text = date
        tv_new_confirmed.text = newConfirmed?.format()
        tv_new_recovered.text = newRecovered?.format()
        tv_new_hospitalized.text = newHospitalized?.format()
        tv_new_deaths.text = newDeaths?.format()
        tv_confirmed.text = confirmed?.format()
        tv_recovered.text = recovered?.format()
        tv_hospitalized.text = hospitalized?.format()
        tv_deaths.text = deaths?.format()
    }

}
