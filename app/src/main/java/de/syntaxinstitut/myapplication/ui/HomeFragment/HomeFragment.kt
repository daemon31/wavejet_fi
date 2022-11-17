package de.syntaxinstitut.myapplication.ui.HomeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.myapplication.MainViewModel
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.databinding.FragmentHomeBinding

/**
 * Fragment 1
 */
class HomeFragment : Fragment() {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: FragmentHomeBinding

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
        binding = FragmentHomeBinding.inflate(inflater)

        return binding.root
    }

    /**
     * Lifecycle Methode nachdem das View erstellt wurde
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);

        {

        }

        binding.hfBtnPlus.setOnClickListener {
            viewModel.changeNumber(true)
        }

        binding.hfBtnMinus.setOnClickListener {
            viewModel.changeNumber(false)
        }

        binding.miregalBtn.setOnClickListener {

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
