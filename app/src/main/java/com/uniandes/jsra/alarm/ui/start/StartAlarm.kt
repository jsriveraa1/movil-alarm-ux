package com.uniandes.jsra.alarm.ui.start

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uniandes.jsra.alarm.R

class StartAlarm : Fragment() {

    companion object {
        fun newInstance() = StartAlarm()
    }

    private lateinit var viewModel: StartAlarmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start_alarm, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StartAlarmViewModel::class.java)
        // TODO: Use the ViewModel
    }

}