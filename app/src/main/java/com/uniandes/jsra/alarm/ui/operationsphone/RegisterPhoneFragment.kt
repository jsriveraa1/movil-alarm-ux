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
import com.uniandes.jsra.alarm.databinding.FragmentFragmentOptionsAlarmBinding
import com.uniandes.jsra.alarm.databinding.FragmentRegisterPhoneBinding
import com.uniandes.jsra.alarm.ui.optionsalarm.FragmentOptionsAlarmViewModel

class RegisterPhoneFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterPhoneFragment()
    }

    private var _binding: FragmentRegisterPhoneBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: RegisterPhoneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeViewModel =
            ViewModelProvider(this).get(RegisterPhoneViewModel::class.java)

        _binding = FragmentRegisterPhoneBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val options: Button = binding.button5
        options.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.registerCodeFragment, null))

//        return inflater.inflate(R.layout.fragment_register_phone, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterPhoneViewModel::class.java)
        // TODO: Use the ViewModel
    }

}