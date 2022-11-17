package de.dimitrikrylasov.wavejet

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import de.dimitrikrylasov.wavejet.data.Numbers

/**
 * Das MainViewModel
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    /* -------------------- Klassen Variablen -------------------- */

    private val firebaseAuth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()


    private val _numbers = MutableLiveData<Numbers>()
    val numbers: LiveData<Numbers>
        get() = _numbers

    // currentuser ist null wenn niemand eingeloggt ist
    private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser: LiveData<FirebaseUser?>
        get() = _currentUser

    fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                _currentUser.value = firebaseAuth.currentUser
            } else {
                Log.e(TAG, "Login failed: ${it.exception}")
            }
        }
    }

    fun logout() {
        firebaseAuth.signOut()
        _currentUser.value = firebaseAuth.currentUser
    }

    private fun setNumbers(numbers: Numbers) {
        db.collection("numbers").document(currentUser.value!!.uid).set(numbers).addOnSuccessListener {
            Log.e(TAG, "This did work")
        }
            .addOnFailureListener {
                Log.e(TAG, "This did not work $it")
            }
    }

    fun getNumbers() {
        db.collection("numbers").document(currentUser.value!!.uid).get().addOnSuccessListener {
            _numbers.value = it.toObject(Numbers::class.java)
        }
    }

    fun changeNumber(increase: Boolean) {
        var newNumber: Long = 0

        newNumber = if (increase) {
            _numbers.value!!.number + 1
        } else {
            _numbers.value!!.number - 1
        }

        db.collection("numbers").document(currentUser.value!!.uid).update("number", newNumber)
            .addOnSuccessListener {
                getNumbers()
            }

        db.collection("numbers").document(currentUser.value!!.uid).update("username", "Dima")
    }

    companion object {
        fun signUp(mainViewModel: MainViewModel, email: String, password: String, numbers: Numbers) {
            mainViewModel.firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    mainViewModel.firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                        mainViewModel._currentUser.value = mainViewModel.firebaseAuth.currentUser
                        mainViewModel.setNumbers(numbers)
                    }
                } else {
                    Log.e(TAG, "SignUp failed: ${it.exception}")
                }
            }
        }
    }

}
