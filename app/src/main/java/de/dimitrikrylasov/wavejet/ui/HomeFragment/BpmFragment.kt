package de.dimitrikrylasov.wavejet.ui.HomeFragment

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.dimitrikrylasov.wavejet.MainViewModel
import de.dimitrikrylasov.wavejet.R
import de.dimitrikrylasov.wavejet.databinding.FragmentBpmBinding

/**
 * Fragment 1
 */
class BpmFragment : Fragment() {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: FragmentBpmBinding

    /** Das ViewModel zu diesem Fragment */
    private val viewModel: MainViewModel by activityViewModels()

    /* -------------------- Lifecycle -------------------- */

    /**
     * Lifecycle Methode wenn das View erstellt wird
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBpmBinding.inflate(inflater)

        return binding.root
    }

    /**
     * Lifecycle Methode nachdem das View erstellt wurde
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBpmYes.setOnClickListener{
            if (it == null) {
                findNavController().navigate(R.id.dashFragment)
            }   else {
                Log.e(ContentValues.TAG, "Da ist was schief gelaufen!")
            }

        }

        binding.hfBtnPlus.setOnClickListener {
            viewModel.changeNumber(true)
        }

        binding.hfBtnMinus.setOnClickListener {
            viewModel.changeNumber(false)
        }

        binding.miregalBtn.setOnClickListener {
            findNavController().navigate(BpmFragmentDirections.actionBpmFragmentToDashFragment())

        }

        viewModel.currentUser.observe(
            viewLifecycleOwner, Observer {
                if (it == null) {
                    findNavController().navigate(R.id.loginFragment)
                } else {
                    viewModel.getNumbers()
                }
            }
        )

        viewModel.numbers.observe(
            viewLifecycleOwner, Observer {
                binding.hfTvNumber.text = it.number.toString()
            }
        )

    }
}
