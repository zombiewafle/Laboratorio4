package com.example.laboratorio4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratorio4.databinding.RolFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class RolFragment : Fragment() {

    private lateinit var viewModel: AddListViewModel
    private lateinit var binding: RolFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        (activity as AppCompatActivity).supportActionBar?.title = "Roles"


        binding = DataBindingUtil.inflate<RolFragmentBinding>(inflater,
            R.layout.rol_fragment, container, false)

        viewModel = activity?.run {
            ViewModelProviders.of(this)[AddListViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        viewModel.rolelist.observe(viewLifecycleOwner, Observer { newList ->
            binding.txt12.text = newList
        })

        binding.btnAdd.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_rolFragment_to_addrolFragment)
        }

        return binding.root
    }

}
