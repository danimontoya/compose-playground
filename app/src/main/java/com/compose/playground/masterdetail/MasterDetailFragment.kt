package com.compose.playground.masterdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.compose.playground.R
import com.compose.playground.masterdetail.detail.DetailFragmentOne
import com.compose.playground.masterdetail.detail.DetailFragmentThree
import com.compose.playground.masterdetail.detail.DetailFragmentTwo
import com.compose.playground.masterdetail.list.ListFragment

class MasterDetailFragment : Fragment(R.layout.fragment_master_detail) {

    internal val viewModel: MasterDetailViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        childFragmentManager.beginTransaction()
            .replace(R.id.list_frame, ListFragment.newInstance(), null)
            .commitNow()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.detailItem.observe(viewLifecycleOwner) { detailsItem ->
            val fragment = when (detailsItem) {
                DetailItem.DetailItemOne -> DetailFragmentOne.newInstance()
                DetailItem.DetailItemTwo -> DetailFragmentTwo.newInstance()
                DetailItem.DetailItemThree -> DetailFragmentThree.newInstance()
            }
            childFragmentManager.beginTransaction()
                .replace(R.id.details_frame, fragment, null)
                .commitNow()
        }
    }
}
