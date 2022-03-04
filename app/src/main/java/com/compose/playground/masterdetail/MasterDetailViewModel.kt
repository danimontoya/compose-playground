package com.compose.playground.masterdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MasterDetailViewModel : ViewModel() {
    val detailItem = MutableLiveData<DetailItem>(DetailItem.DetailItemOne)

    fun setDetails(details: DetailItem) {
        detailItem.value = details
    }
}

sealed class DetailItem {
    object DetailItemOne : DetailItem()
    object DetailItemTwo : DetailItem()
    object DetailItemThree : DetailItem()
}
