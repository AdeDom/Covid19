package com.adedom.covid19.ui.cases

import android.view.View
import com.adedom.covid19.R
import com.adedom.covid19.data.models.CasesData
import com.adedom.covid19.base.BaseRecyclerView
import com.adedom.covid19.util.extension.format
import kotlinx.android.synthetic.main.item_cases.view.*

class CasesAdapter : BaseRecyclerView<CasesData>() {

    override fun getLayout() = R.layout.item_cases

    override fun View.onBindViewHolder(data: CasesData) {
        val (confirmDate, no, age, gender, genderEn, nation, nationEn, province, provinceId, district, provinceEn, _) = data
        tv_confirm_date.text = confirmDate
        tv_no.text = no
        tv_age.text = age?.toInt()?.format()
        tv_gender.text = gender
        tv_gender_en.text = genderEn
        tv_nation.text = nation
        tv_nation_en.text = nationEn
        tv_province.text = province
        tv_province_id.text = provinceId?.format()
        tv_district.text = district
        tv_province_en.text = provinceEn
    }

}
