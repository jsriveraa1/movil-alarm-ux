package com.uniandes.jsra.alarm

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.uniandes.jsra.alarm.databinding.FragmentFragmentOptionsAlarmBinding
import com.uniandes.jsra.alarm.databinding.FragmentFragmentSearchSongBinding
import com.uniandes.jsra.alarm.ui.optionsalarm.FragmentOptionsAlarmViewModel

class FragmentSearchSong : Fragment() {

    companion object {
        fun newInstance() = FragmentSearchSong()
    }

    private var _binding: FragmentFragmentSearchSongBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: FragmentSearchSongViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val homeViewModel =
            ViewModelProvider(this).get(FragmentSearchSongViewModel::class.java)

        _binding = FragmentFragmentSearchSongBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val options: Button = binding.button4
        options.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.navigation_home, null))

//        return inflater.inflate(R.layout.fragment_fragment_search_song, container, false)
        return root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentSearchSongViewModel::class.java)
        // TODO: Use the ViewModel
    }

}