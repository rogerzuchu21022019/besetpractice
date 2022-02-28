package nam.rogerzuchu.bestpractice.fragmens.register

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import nam.rogerzuchu.bestpractice.R
import nam.rogerzuchu.bestpractice.database.entities.User
import nam.rogerzuchu.bestpractice.databinding.FragmentRegisterBinding
import nam.rogerzuchu.bestpractice.viewmodel.AppUserViewModel

class RegisterFM : Fragment() {
    lateinit var fmRegisterBinding: FragmentRegisterBinding
    lateinit var appViewModel:AppUserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fmRegisterBinding = FragmentRegisterBinding.inflate(layoutInflater)
        return fmRegisterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initButton()
        initViewModel()
    }

    private fun initViewModel() {
        appViewModel = ViewModelProvider(this).get(AppUserViewModel::class.java)
    }

    private fun initButton() {
        fmRegisterBinding.btnRegister.setOnClickListener(){
            val account = fmRegisterBinding.edtRegisterUserName.text.toString()
            val password = fmRegisterBinding.edtRegisterPassword.text.toString()

            if (!checkInput(account,password)){
                val user:User=User(account = account,password = password,stt = 0)
                appViewModel.insertNewUserInRecyclerView(user)
                findNavController().navigate(R.id.action_registerFM_to_signInFM)
                Toast.makeText(requireContext(),"Register Succesfully",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(requireContext(),"Register Fail",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkInput(account: String, password: String) :Boolean{
            return (TextUtils.isEmpty(account)||TextUtils.isEmpty(password))
    }
}