package com.adedom.covid19.ui.timeline

import android.view.View
import com.adedom.covid19.R
import com.adedom.covid19.data.models.TimelineData
import com.adedom.covid19.util.base.BaseRecyclerView
import com.adedom.covid19.util.extension.format
import kotlinx.android.synthetic.main.item_timeline.view.*

class TimelineAdapter : BaseRecyclerView<TimelineData>() {

    override fun getLayout() = R.layout.item_timeline

    override fun onBindViewHolder(view: View, entity: TimelineData) {
        val (date, newConfirmed, newRecovered, newHospitalized, newDeaths, confirmed, recovered, hospitalized, deaths) = entity
        view.tv_date.text = date
        view.tv_new_confirmed.text = newConfirmed?.format()
        view.tv_new_recovered.text = newRecovered?.format()
        view.tv_new_hospitalized.text = newHospitalized?.format()
        view.tv_new_deaths.text = newDeaths?.format()
        view.tv_confirmed.text = confirmed?.format()
        view.tv_recovered.text = recovered?.format()
        view.tv_hospitalized.text = hospitalized?.format()
        view.tv_deaths.text = deaths?.format()
    }

}
