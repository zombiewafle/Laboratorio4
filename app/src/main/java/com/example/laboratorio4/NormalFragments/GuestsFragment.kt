package com.example.laboratorio4.NormalFragments

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
import com.example.laboratorio4.databinding.FragmentGuestsBinding
import com.example.laboratorio4.AddListViewModel
import com.example.laboratorio4.R

/**
 * A simple [Fragment] subclass.
 */
class InvitedFragment : Fragment() {

    private lateinit var viewModel: AddListViewModel
    private lateinit var binding: FragmentGuestsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentGuestsBinding>(inflater,
            R.layout.fragment_guests, container, false)

        viewModel = activity?.run {
            ViewModelProviders.of(this)[AddListViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        viewModel.nameList.observe(viewLifecycleOwner, Observer { newList ->
            binding.textView3.text = newList
        })

        (activity as AppCompatActivity).supportActionBar?.title = "Invitados"

        binding.btnAddGuests.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_invitedFragment_to_addFragment)
        }

        return binding.root
    }

}
