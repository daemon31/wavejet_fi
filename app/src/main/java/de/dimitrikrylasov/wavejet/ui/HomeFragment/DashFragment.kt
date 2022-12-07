package de.dimitrikrylasov.wavejet.ui.HomeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import de.dimitrikrylasov.wavejet.MainViewModel
import de.dimitrikrylasov.wavejet.adapter.ItemAdapter
import de.dimitrikrylasov.wavejet.data.model.ApiResponse
import de.dimitrikrylasov.wavejet.data.model.Events
import de.dimitrikrylasov.wavejet.databinding.DashboardFragmentBinding

class DashFragment : Fragment() {

    private lateinit var binding: DashboardFragmentBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DashboardFragmentBinding.inflate(inflater)
        viewModel.getAllEvents()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.events.observe(
            viewLifecycleOwner, Observer {
                binding.dashboardRecyclerviewVert.adapter = ItemAdapter(it)
            }
        )
    }
}