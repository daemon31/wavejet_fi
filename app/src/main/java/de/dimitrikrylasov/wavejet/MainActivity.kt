package de.dimitrikrylasov.wavejet

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.dimitrikrylasov.wavejet.databinding.ActivityMainBinding

/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val navView: BottomNavigationView = binding.bottomNavbar

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

       // navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                    R.id.loginFragment -> binding.bottomNavbar.visibility = View.GONE
                    R.id.registerFragment -> binding.bottomNavbar.visibility = View.GONE
                    R.id.bpmFragment -> binding.bottomNavbar.visibility = View.GONE
                else -> binding.bottomNavbar.visibility = View.VISIBLE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
