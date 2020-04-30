package com.adedom.covid19.ui.cases

import android.view.View
import com.adedom.covid19.R
import com.adedom.covid19.data.models.CasesData
import com.adedom.covid19.util.base.BaseRecyclerView
import com.adedom.covid19.util.extension.format
import kotlinx.android.synthetic.main.item_cases.view.*

class CasesAdapter : BaseRecyclerView<CasesData>() {

    override fun getLayout() = R.layout.item_cases

    override fun onBindViewHolder(view: View, entity: CasesData) {
        val (confirmDate, no, age, gender, genderEn, nation, nationEn, province, provinceId, district, provinceEn, _) = entity
        view.tv_confirm_date.text = confirmDate
        view.tv_no.text = no
        view.tv_age.text = age?.toInt()?.format()
        view.tv_gender.text = gender
        view.tv_gender_en.text = genderEn
        view.tv_nation.text = nation
        view.tv_nation_en.text = nationEn
        view.tv_province.text = province
        view.tv_province_id.text = provinceId?.format()
        view.tv_district.text = district
        view.tv_province_en.text = provinceEn
    }

}
