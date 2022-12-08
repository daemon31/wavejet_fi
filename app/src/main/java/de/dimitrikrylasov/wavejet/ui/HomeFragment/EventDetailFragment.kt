package de.dimitrikrylasov.wavejet.ui.HomeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.dimitrikrylasov.wavejet.MainViewModel
import de.dimitrikrylasov.wavejet.databinding.FragmentEventdetailsBinding

class EventDetailFragment : Fragment() {

    private lateinit var binding: FragmentEventdetailsBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventdetailsBinding.inflate(inflater)
        viewModel.getAllEvents()
        return binding.root
    }
}