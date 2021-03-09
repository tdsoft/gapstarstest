package com.tharindu.damintha.gapstarstest.ui.profile

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tharindu.damintha.gapstarstest.R
import com.tharindu.damintha.gapstarstest.common.inflate
import com.tharindu.damintha.gapstarstest.common.loadImageUrl
import com.tharindu.damintha.gapstarstest.fragment.RepositoryFragment
import kotlinx.android.synthetic.main.listitem_repo_verticle.view.*

class AdapterRepositories(val isHorizontal: Boolean, val list: List<RepositoryFragment>) :
    RecyclerView.Adapter<AdapterRepositories.RepoItemViewHolder>() {

    inner class RepoItemViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(if (isHorizontal) R.layout.listitem_repo_horizontal else R.layout.listitem_repo_verticle)) {
        fun bind(item: RepositoryFragment) = with(itemView) {
            item.primaryLanguage?.fragments?.primaryLanguageFragment?.let {
                txtPrimaryLanguage.text = it.name
                vLanguageCircle.setColorFilter(Color.parseColor(it.color))
            }
            txtProjectName.text = item.name
            txtProjectDescription.text = item.description
            txtOwner.text = item.owner.login
            ivProfileImage.loadImageUrl(item.owner.avatarUrl.toString())
            txtStartGazerCount.text = item.stargazerCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RepoItemViewHolder(parent)

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}