package com.example.laboratorio4

import com.example.laboratorio4.databinding.FragmentListBinding
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil

import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class listFragment : Fragment() {




    private val invitedPeople: MutableList<User> = mutableListOf(
        User(name = "Javier Salazar", phoneNumber = "12345678", email = "correo@gmail.com"),
        User(name = "Karla De León", phoneNumber = "12345678", email = "correo@gmail.com"),
        User(name = "Rodrigo García", phoneNumber = "12345678", email = "correo@gmail.com")
    )

    lateinit var actualInvitedPerson: User
    private var person = 0
    private var user = User()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentListBinding>(inflater, R.layout.fragment_list, container, false)
        binding.user = user

        binding.apply {
            binding.invalidateAll()
            txtnameView.text = invitedPeople[person].name
            txtPhoneView.text = "Phone: " + invitedPeople[person].phoneNumber
            txtEmailView.text = "email: " + invitedPeople[person].email
        }


        if(person == 3){

        }
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.answer_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        person += 1
        when(item.itemId){
            R.id.check_button -> {
                if(person < 3){
                    txtnameView.text = invitedPeople[person].name
                    txtPhoneView.text = "Phone Numer: " + invitedPeople[person].phoneNumber
                    txtEmailView.text = "Email: " + invitedPeople[person].email
                }else{
                    Toast.makeText(activity, "No hay más invitados", Toast.LENGTH_SHORT).show()


                }
            }


            R.id.deny_button -> {
                if(person < 3){
                    txtnameView.text = invitedPeople[person].name
                    txtPhoneView.text = "Phone Numer: " + invitedPeople[person].phoneNumber
                    txtEmailView.text = "Email: " + invitedPeople[person].email
                }else{
                    Toast.makeText(activity, "No hay más invitados", Toast.LENGTH_SHORT).show()
                }
            }
        }


        return super.onOptionsItemSelected(item)
    }
}
