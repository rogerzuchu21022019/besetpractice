package nam.rogerzuchu.bestpractice.fragmens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import nam.rogerzuchu.bestpractice.R
import nam.rogerzuchu.bestpractice.adapters.AppUserAdapter
import nam.rogerzuchu.bestpractice.database.entities.User
import nam.rogerzuchu.bestpractice.databinding.FragmentHomeBinding
import nam.rogerzuchu.bestpractice.viewmodel.AppUserViewModel

class HomeFM :Fragment(){
    lateinit var fmHomeBinding: FragmentHomeBinding
    lateinit var appAdapter:AppUserAdapter
    lateinit var appViewModel:AppUserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fmHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return fmHomeBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()
        initViewModel()
        initButton()
    }

    private fun initButton() {
        fmHomeBinding.fabAdd.setOnClickListener{
            findNavController().navigate(R.id.action_homeFM_to_registerFM)
        }
        fmHomeBinding.fabDeleteAll.setOnClickListener{
            appViewModel.deleteAll()
        }
    }

    private fun initViewModel() {
        appViewModel = ViewModelProvider(this).get(AppUserViewModel::class.java)
        appViewModel.getAllInformationUser.observe(viewLifecycleOwner){userList->
            appAdapter.setDataForAdapter(userList = userList)
        }
    }

    private fun initRecyclerView() {
        appAdapter = AppUserAdapter()
        fmHomeBinding.recyclerView.adapter = appAdapter
    }
}