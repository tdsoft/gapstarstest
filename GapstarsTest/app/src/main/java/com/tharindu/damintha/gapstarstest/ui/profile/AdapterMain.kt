package com.tharindu.damintha.gapstarstest.ui.profil

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tharindu.damintha.gapstarstest.R
import com.tharindu.damintha.gapstarstest.common.inflate
import com.tharindu.damintha.gapstarstest.ui.profile.AdapterRepositories
import com.tharindu.damintha.gapstarstest.ui.profile.ListItemTypes
import com.tharindu.damintha.gapstarstest.ui.profile.RepositoryItem
import kotlinx.android.synthetic.main.listitem_header.view.*
import kotlinx.android.synthetic.main.listitem_horizontal_type_recycler.view.*
import kotlinx.android.synthetic.main.listitem_verticle_type_recycler.view.*

class AdapterMain(val list: List<RepositoryItem>) :
    RecyclerView.Adapter<AdapterMain.BaseViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()

    open inner class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        open fun bind(item: RepositoryItem) = with(itemView) {

        }
    }

    inner class HorizontalRecyclerItemViewHolder(parent: ViewGroup) :
        BaseViewHolder(parent.inflate(R.layout.listitem_horizontal_type_recycler)) {
        override fun bind(item: RepositoryItem) = with(itemView) {
            rvRepositoriesHorizontal.layoutManager =
                LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            rvRepositoriesHorizontal.apply {
                setRecycledViewPool(viewPool)
            }
            rvRepositoriesHorizontal.adapter = AdapterRepositories(true, item.list ?: ArrayList())
        }
    }

    inner class VerticalRecyclerItemViewHolder(parent: ViewGroup) :
        BaseViewHolder(parent.inflate(R.layout.listitem_verticle_type_recycler)) {
        override fun bind(item: RepositoryItem) = with(itemView) {
            rvRepositoriesVertical.layoutManager =
                LinearLayoutManager(context)
            rvRepositoriesVertical.apply {
                setRecycledViewPool(viewPool)
            }
            rvRepositoriesVertical.adapter = AdapterRepositories(false, item.list ?: ArrayList())
        }
    }

    inner class HeaderItemViewHolder(parent: ViewGroup) :
        BaseViewHolder(parent.inflate(R.layout.listitem_header)) {
        override fun bind(item: RepositoryItem) = with(itemView) {
            txtHeader.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            ListItemTypes.HorizontalRecycler -> {
                HorizontalRecyclerItemViewHolder(parent)
            }
            ListItemTypes.VerticalRecycler -> {
                VerticalRecyclerItemViewHolder(parent)
            }
            else -> {
                HeaderItemViewHolder(parent)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        return list[position].itemType
    }

}