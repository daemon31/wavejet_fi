package de.dimitrikrylasov.wavejet.ui.HomeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.dimitrikrylasov.wavejet.MainViewModel
import de.dimitrikrylasov.wavejet.adapter.ItemAdapter
import de.dimitrikrylasov.wavejet.data.DataSource
import de.dimitrikrylasov.wavejet.data.model.Feeds
import de.dimitrikrylasov.wavejet.databinding.DashboardFragmentBinding
import de.dimitrikrylasov.wavejet.databinding.FragmentBpmBinding

class DashFragment : Fragment() {

    private lateinit var binding: DashboardFragmentBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DashboardFragmentBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val Feeds = DataSource().feedList

        val itemAdapter = ItemAdapter(Feeds)
        binding.dashboardRecyclerviewVert.adapter = itemAdapter
    }
}