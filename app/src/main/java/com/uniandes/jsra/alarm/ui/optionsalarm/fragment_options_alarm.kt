package com.uniandes.jsra.alarm.ui.optionsalarm

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
import com.uniandes.jsra.alarm.databinding.FragmentHomeBinding
import com.uniandes.jsra.alarm.ui.home.HomeViewModel

class fragment_options_alarm : Fragment() {

    companion object {
        fun newInstance() = fragment_options_alarm()
    }

    private var _binding: FragmentFragmentOptionsAlarmBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: FragmentOptionsAlarmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val homeViewModel =
            ViewModelProvider(this).get(FragmentOptionsAlarmViewModel::class.java)

        _binding = FragmentFragmentOptionsAlarmBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val options: Button = binding.button3
        options.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.navigation_home, null))

//        return inflater.inflate(R.layout.fragment_fragment_options_alarm, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentOptionsAlarmViewModel::class.java)
        // TODO: Use the ViewModel
    }

}