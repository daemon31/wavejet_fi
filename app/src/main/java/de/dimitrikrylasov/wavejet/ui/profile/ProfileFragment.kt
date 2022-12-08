package de.dimitrikrylasov.wavejet.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.dimitrikrylasov.wavejet.MainViewModel
import de.dimitrikrylasov.wavejet.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(){
    private lateinit var binding: FragmentProfileBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater)
        viewModel.getAllEvents()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProfile()
        viewModel.userData.observe(viewLifecycleOwner
        ) {
            if (it == null)
                viewModel.newProfile()
            else {
                binding.pfNickTxt.text = it.nickname
                binding.pfAgeTxt.text = it.alter
                binding.pfGerneTxt.text = it.genre
                binding.pfMeTxt.text = it.mich
            }
        }
    }
    }