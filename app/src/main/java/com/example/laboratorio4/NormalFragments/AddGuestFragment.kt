package com.example.laboratorio4.NormalFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.laboratorio4.R
import com.example.laboratorio4.databinding.FragmentAddGuestBinding

/**
 * A simple [Fragment] subclass.
 */
class AddGuestFragment : Fragment() {
    private lateinit var binding: FragmentAddGuestBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_add_guest, container, false)
    }

}
