package com.example.laboratorio4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratorio4.databinding.GuestResultFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class GuestResultFragment : Fragment() {

    private lateinit var viewModel: AddListViewModel
    private lateinit var binding: GuestResultFragmentBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<GuestResultFragmentBinding>(inflater,
            R.layout.guest_result_fragment, container, false)

        viewModel = activity?.run {
            ViewModelProviders.of(this)[AddListViewModel::class.java]
        } ?: throw Exception("Invalid activity")

        binding.txtGuests.text = "Guests: " + util.invitados.toString()
        binding.txtAlreadyRegisted.text = "Register: " + util.registrados.toString()





        binding.reiniciar.setOnClickListener{v:View->
            v.findNavController().navigate(R.id.action_resultsFragment_to_listFragment)
        }


        (activity as AppCompatActivity).supportActionBar?.title = "Result"

        setHasOptionsMenu(true)

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val lista = sharedPref?.getString("List", "")

        binding.button3.setOnClickListener{
            Toast.makeText(activity, util.listado, Toast.LENGTH_LONG).show()
        }

        return binding.root
    }




    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val shared = activity?.getPreferences(Context.MODE_PRIVATE)
        when (item.itemId) {
            R.id.share_button -> {
                val lista = util.listado
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type = "text"
                shareIntent.putExtra(Intent.EXTRA_TEXT, lista);
                startActivity(Intent.createChooser(shareIntent, "Share"))

            }


        }
        return super.onOptionsItemSelected(item)
    }
}

