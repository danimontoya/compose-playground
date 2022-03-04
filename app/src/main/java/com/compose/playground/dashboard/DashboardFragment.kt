package com.compose.playground.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.compose.playground.R
import com.compose.playground.databinding.FragmentDashboardBinding
import com.compose.playground.viewBindings

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val views by viewBindings(FragmentDashboardBinding::bind)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        views.goToItemsList.setOnClickListener {
            val isTablet = resources.getBoolean(R.bool.is_multipane)
            if (isTablet) {
                findNavController().navigate(R.id.action_dashboardFragment_to_masterDetailFragment)
            } else {
                findNavController().navigate(R.id.action_dashboardFragment_to_listFragment)
            }
        }
    }
}
