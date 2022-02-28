package nam.rogerzuchu.bestpractice.fragmens.signin

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import nam.rogerzuchu.bestpractice.R
import nam.rogerzuchu.bestpractice.databinding.FragmentSinginBinding
import nam.rogerzuchu.bestpractice.viewmodel.AppUserViewModel

class SignInFM : Fragment() {
    lateinit var fmSinginBinding: FragmentSinginBinding
    lateinit var appViewModel: AppUserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fmSinginBinding = FragmentSinginBinding.inflate(layoutInflater)
        return fmSinginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModel()
        initButton()

    }

    private fun initViewModel() {
        appViewModel = ViewModelProvider(this).get(AppUserViewModel::class.java)

    }

    private fun initButton() {
        var isExist:Boolean?=null
        fmSinginBinding.btnSignIn.setOnClickListener() {
            val account = fmSinginBinding.edtSignInUser.text.toString().trim()
            val password = fmSinginBinding.edtSignInPassword.text.toString().trim()
            appViewModel.getAllInformationUser.observe(viewLifecycleOwner) { userList ->
                if (!checkInput(account, password)) {

                }
                for (user in userList) {
                    if ((account == user.account && password == user.password)) {
                        isExist = true
                        findNavController().navigate(R.id.action_signInFM_to_homeFM)
                        Toast.makeText(requireContext(), "Sign In Succesfully", Toast.LENGTH_LONG)
                            .show()
                    }else{
                        isExist=false
                    }

                }
                if (isExist==false){
                    Toast.makeText(requireContext(), "Sign In Fail", Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    private fun checkInput(account: String, password: String): Boolean {
        return (TextUtils.isEmpty(account) || TextUtils.isEmpty(password))

    }
}