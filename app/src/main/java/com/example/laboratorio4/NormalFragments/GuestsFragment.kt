package com.example.laboratorio4.NormalFragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.laboratorio4.R
import com.example.laboratorio4.databinding.FragmentGuestsBinding

/**
 * A simple [Fragment] subclass.
 */
class GuestsFragment : Fragment() {
    private lateinit var binding: FragmentGuestsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentGuestsBinding>(inflater,
            R.layout.fragment_guests,container,false)
        binding.btnAddGuests.setOnClickListener{v:View ->
            v.findNavController().navigate(R.id.guestToAddGuest)
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.save_menu, menu)
    }



}
