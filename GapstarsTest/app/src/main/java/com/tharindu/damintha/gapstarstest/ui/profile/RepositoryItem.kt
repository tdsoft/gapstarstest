package com.tharindu.damintha.gapstarstest.ui.profile

import androidx.annotation.IntDef
import com.tharindu.damintha.gapstarstest.fragment.RepositoryFragment


@IntDef(ListItemTypes.HorizontalRecycler, ListItemTypes.VerticalRecycler, ListItemTypes.Header)
annotation class ListItemTypes {
    companion object {
        const val HorizontalRecycler = 0
        const val VerticalRecycler = 1
        const val Header = 2
    }
}


data class RepositoryItem(
    val title: String?, val list: List<RepositoryFragment>?, val showViewAll: Boolean,
    @ListItemTypes val itemType: Int
)