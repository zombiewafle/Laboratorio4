package com.example.laboratorio4.ViewModelFragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.laboratorio4.R

class AddGuestFragment : Fragment() {

    companion object {
        fun newInstance() = AddGuestFragment()
    }

    private lateinit var viewModel: AddGuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_guest_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddGuestViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
