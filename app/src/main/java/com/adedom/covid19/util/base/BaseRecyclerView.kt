package com.adedom.covid19.util.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerView<T : Any> : RecyclerView.Adapter<BaseRecyclerView<T>.BaseHolder>() {

    private var list = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder =
        BaseHolder(
            LayoutInflater.from(parent.context)
                .inflate(getLayout(), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BaseHolder, position: Int) =
        onBindViewHolder(holder.itemView, list[position])

    abstract fun getLayout(): Int

    abstract fun onBindViewHolder(view: View, entity: T)

    fun setList(list: List<T>) {
        this.list = list as MutableList<T>
        notifyDataSetChanged()
    }

    inner class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
