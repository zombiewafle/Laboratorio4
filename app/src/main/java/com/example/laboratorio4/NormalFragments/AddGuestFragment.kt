package com.example.laboratorio4

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratorio4.databinding.FragmentGuestsBinding
import kotlinx.android.synthetic.main.fragment_add_guest.*

/**
 * A simple [Fragment] subclass.
 */
class AddGuestFragment : Fragment() {

    private lateinit var viewModel: AddListViewModel
    private lateinit var binding: FragmentGuestsBinding
    private var count = 0
    var personas: MutableList<User> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentGuestsBinding>(inflater,
            R.layout.add_guest_fragment, container, false)

        viewModel = activity?.run {
            ViewModelProviders.of(this)[AddListViewModel::class.java]
        } ?: throw Exception("Invalid Actibity")
        (activity as AppCompatActivity).supportActionBar?.title = "Agregar Invitado"
        setHasOptionsMenu(true)



        return binding.root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.save_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when (item.itemId) {
            R.id.save_button -> {
                util.lista.add(User(txtName.text.toString(), txtPhoneNumber.text.toString(), txtEmail.text.toString()))
                viewModel.addList(personas)
                //Toast.makeText(activity, viewModel.people1.value?.get(0)?.name, Toast.LENGTH_SHORT).show()
                viewModel.nameList.value += "\nGuest" + "\nName: " + txtName.text.toString()+"\nPhone number: " + txtPhoneNumber.text.toString()+"\nEmail: "+ txtEmail.text.toString()+"\n"
                view?.findNavController()?.navigate(R.id.action_addFragment_to_invitedFragment)
            }



        }
        return super.onOptionsItemSelected(item)
    }




}
