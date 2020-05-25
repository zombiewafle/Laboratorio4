package com.example.laboratorio4.ViewModelFragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.laboratorio4.R
import com.example.laboratorio4.User
import com.example.laboratorio4.databinding.FragmentListBindingImpl
import kotlinx.android.synthetic.main.fragment_add_guest.*


class ListFragment : Fragment() {


    val invitedPeople: MutableList<User> = mutableListOf(
        User(
            name = "Javier Salazar",
            phoneNumber = "12345678",
            email = "correo@gmail.com"
        )
    )


    lateinit var actualInvitedPerson: User
    private var person = 0
    private var user = User()


    companion object {
        fun newInstance() =
            ListFragment()
    }


    private lateinit var viewModel: ListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {val binding = DataBindingUtil.inflate<FragmentListBindingImpl>(inflater,
        R.layout.fragment_list, container, false)
        binding.user = user


        binding.apply {
            binding.invalidateAll()
            txtName.text = invitedPeople[person].name
            txtPhoneNumber.text = "Phone: " + invitedPeople[person].phoneNumber
            txtEmail.text = "email: " + invitedPeople[person].email
        }


        if(person in 0..20){

        }
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        // TODO: Use the ViewModel
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.answer_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        person += 1
        when(item.itemId){
            R.id.check_button -> {
                if(person in 3..20){
                    txtName.text = invitedPeople[person].name
                    txtPhoneNumber.text = "Phone Numer: " + invitedPeople[person].phoneNumber
                    txtEmail.text = "Email: " + invitedPeople[person].email
                }else{
                    Toast.makeText(activity, "No hay más invitados", Toast.LENGTH_SHORT).show()
                }
            }


            R.id.save_button -> {
                if(person in 3..20){
                    txtName.text = invitedPeople[person].name
                    txtPhoneNumber.text = "Phone Numer: " + invitedPeople[person].phoneNumber
                    txtEmail.text = "Email: " + invitedPeople[person].email
                }else{
                    Toast.makeText(activity, "No hay más invitados", Toast.LENGTH_SHORT).show()
                }
            }
        }


        return super.onOptionsItemSelected(item)
    }

}
