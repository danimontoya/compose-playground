package com.compose.playground.masterdetail.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.compose.playground.R
import com.compose.playground.databinding.FragmentListBinding
import com.compose.playground.masterdetail.DetailItem
import com.compose.playground.masterdetail.MasterDetailFragment
import com.compose.playground.masterdetail.MasterDetailViewModel
import com.compose.playground.viewBindings

class ListFragment : Fragment(R.layout.fragment_list) {

    companion object {
        fun newInstance() = ListFragment()
    }

    private val views by viewBindings(FragmentListBinding::bind)

    private val masterDetailViewModel: MasterDetailViewModel? by lazy {
        (parentFragment as? MasterDetailFragment)?.viewModel
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        views.itemOne.setOnClickListener {
            masterDetailViewModel?.setDetails(DetailItem.DetailItemOne)
                ?: findNavController().navigate(R.id.action_listFragment_to_detailFragmentOne)
        }
        views.itemTwo.setOnClickListener {
            masterDetailViewModel?.setDetails(DetailItem.DetailItemTwo)
                ?: findNavController().navigate(R.id.action_listFragment_to_detailFragmentTwo)
        }
        views.itemThree.setOnClickListener {
            masterDetailViewModel?.setDetails(DetailItem.DetailItemThree)
                ?: findNavController().navigate(R.id.action_listFragment_to_detailFragmentThree)
        }
    }
}
