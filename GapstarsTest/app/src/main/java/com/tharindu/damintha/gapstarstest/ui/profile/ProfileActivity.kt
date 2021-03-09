package com.tharindu.damintha.gapstarstest.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tharindu.damintha.gapstarstest.R
import com.tharindu.damintha.gapstarstest.common.gone
import com.tharindu.damintha.gapstarstest.common.loadImageUrl
import com.tharindu.damintha.gapstarstest.common.show
import com.tharindu.damintha.gapstarstest.data.sources.Result
import com.tharindu.damintha.gapstarstest.ui.profil.AdapterMain
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_profile.*

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {
    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, ProfileActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initUI()
    }

    private fun initUI() {

        setSupportActionBar(toolbar)
        rvRepositories.layoutManager = LinearLayoutManager(this)
        srRefreshList.setOnRefreshListener {
            mainDetailsGroup.gone()
            srRefreshList.isRefreshing = false
            loadData()
        }
    }

    private val loginViewModel: ProfileViewModel by viewModels()
    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData(isClearCache: Boolean = false) {
        if (isClearCache) {
            loginViewModel.clearCache()
        }
        loginViewModel.getProfile().observe(this, {
            it?.let { result ->
                when (result.status) {
                    Result.Status.LOADING -> {
                        progressBar.show()
                        mainDetailsGroup.gone()
                    }
                    Result.Status.SUCCESS -> {
                        progressBar.gone()
                        mainDetailsGroup.show()
                        result.data?.user?.let { user ->
                            txtName.text = user.name
                            txtLoginName.text = user.login
                            txtEmail.text = user.email ?: ""
                            txtFollowersCount.text = user.followers.totalCount.toString()
                            txtFollowingCount.text = user.following.totalCount.toString()
                            ivUserProfile.loadImageUrl(user.avatarUrl.toString(), true)
                        }

                        val list = ArrayList<RepositoryItem>()
                        list.add(RepositoryItem("Pinned", null, true, ListItemTypes.Header))
                        val pinnedList =
                            result.data?.user?.pinnedItems?.nodes!!.filterNotNull().map { node ->
                                node.fragments.repositoryFragment!!
                            }
                        list.add(
                            RepositoryItem(
                                null,
                                pinnedList,
                                true,
                                ListItemTypes.VerticalRecycler
                            )
                        )

                        list.add(
                            RepositoryItem(
                                "Top repositories",
                                null,
                                true,
                                ListItemTypes.Header
                            )
                        )
                        val topRepositories =
                            result.data?.user?.topRepositories.nodes!!.filterNotNull().map { node ->
                                node.fragments.repositoryFragment
                            }
                        list.add(
                            RepositoryItem(
                                null,
                                topRepositories,
                                true,
                                ListItemTypes.HorizontalRecycler
                            )
                        )

                        list.add(
                            RepositoryItem(
                                "Starred repositories",
                                null,
                                true,
                                ListItemTypes.Header
                            )
                        )
                        val starredRepositories =
                            result.data?.user?.starredRepositories.nodes!!.filterNotNull()
                                .map { node ->
                                    node.fragments.repositoryFragment
                                }
                        list.add(
                            RepositoryItem(
                                null,
                                starredRepositories,
                                true,
                                ListItemTypes.HorizontalRecycler
                            )
                        )

                        rvRepositories.adapter = AdapterMain(list)

                    }
                    else -> {
                        progressBar.gone()
                        mainDetailsGroup.gone()
                        Toast.makeText(
                            this@ProfileActivity,
                            R.string.something_went_wrong,
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                }

            }
        })
    }
}