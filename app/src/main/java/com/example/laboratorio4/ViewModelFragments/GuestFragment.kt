package com.example.laboratorio4.ViewModelFragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.laboratorio4.R

class GuestFragment : Fragment() {

    companion object {
        fun newInstance() = GuestFragment()
    }

    private lateinit var viewModel: GuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.guest_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GuestViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
