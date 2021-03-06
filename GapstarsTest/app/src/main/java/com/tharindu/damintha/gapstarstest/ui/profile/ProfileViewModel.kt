package com.tharindu.damintha.gapstarstest.ui.profile

import androidx.lifecycle.SavedStateHandle
import com.tharindu.damintha.gapstarstest.base.BaseViewModel
import com.tharindu.damintha.gapstarstest.data.sources.GTRepository
import com.tharindu.damintha.gapstarstest.data.sources.resultLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val gtRepository: GTRepository,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    fun getProfile() = resultLiveData { gtRepository.getProfileData() }
    fun clearCache() {
        gtRepository.clearCache()
    }
}