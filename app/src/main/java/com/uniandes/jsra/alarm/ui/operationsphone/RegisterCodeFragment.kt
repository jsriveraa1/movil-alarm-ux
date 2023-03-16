package com.uniandes.jsra.alarm.ui.operationsphone

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.uniandes.jsra.alarm.R
import com.uniandes.jsra.alarm.databinding.FragmentRegisterCodeBinding
import com.uniandes.jsra.alarm.databinding.FragmentRegisterPhoneBinding

class RegisterCodeFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterCodeFragment()
    }

    private var _binding: FragmentRegisterCodeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: RegisterCodeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeViewModel =
            ViewModelProvider(this).get(RegisterCodeViewModel::class.java)

        _binding = FragmentRegisterCodeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val options: Button = binding.button7
        options.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.navigation_home, null))

//        return inflater.inflate(R.layout.fragment_register_code, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterCodeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}