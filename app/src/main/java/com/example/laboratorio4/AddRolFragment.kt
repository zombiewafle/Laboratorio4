package com.example.laboratorio4

import android.os.Bundle
import android.view.*
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratorio4.databinding.FragmentAddRolBinding
import kotlinx.android.synthetic.main.fragment_add_rol.*

/**
 * A simple [Fragment] subclass.
 */
class AddRolFragment : Fragment() {

    private lateinit var binding: FragmentAddRolBinding
    private lateinit var viewModel: AddListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentAddRolBinding>(inflater,
            R.layout.fragment_add_rol, container, false)

        viewModel = activity?.run {
            ViewModelProviders.of(this)[AddListViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.bar.max = 10
        binding.bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textView2.text = "Orden: "+ progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                binding.textView2.text = "Orden: "+ binding.bar.progress
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                binding.textView2.text = "Orden: "+ binding.bar.progress
            }

        })



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
                viewModel.rolelist.value += "\nRol " + "\nNombre: " + nameView.text.toString()+ "\nDescripción: "+ descriptionView.text.toString()+ "\nOrden: " + binding.bar.progress.toString()
                view?.findNavController()?.navigate(R.id.action_addrolFragment_to_rolFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }



}
