package com.uniandes.jsra.alarm.ui.home

import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.uniandes.jsra.alarm.R
import com.uniandes.jsra.alarm.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var hora: String = ""
    var minutos: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val timePicker: TextInputEditText = binding.textEditHour
        val inputDatePicker: TextInputEditText = binding.textEditDate
        val spinnerSongs: Spinner = binding.spinner
        val spinnerPower: Spinner = binding.spinner2

        timePicker.setOnClickListener { openTimePicker(binding) }
        inputDatePicker.setOnClickListener { openDatePicker(binding) }

        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.songs_array,
            android.R.layout.simple_spinner_dropdown_item
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerSongs.adapter = adapter
            }

        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.powerLevels_array,
            android.R.layout.simple_spinner_dropdown_item
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerPower.adapter = adapter
            }

        val options: Button = binding.button
        options.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.fragment_options_alarm,
                null
            )
        )

        spinnerSongs.onItemSelectedListener = this

        return root
    }

    private fun openDatePicker(binding: FragmentHomeBinding) {
        val datePicker = MaterialDatePicker.Builder
            .datePicker()
            .setTitleText("Calendario")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
        datePicker.show(childFragmentManager, "tag")

        datePicker.addOnPositiveButtonClickListener { binding.textDate.editText?.setText(datePicker.headerText) }
    }

    private fun openTimePicker(binding: FragmentHomeBinding) {
        val isSystem24Hour = is24HourFormat(requireContext())
        val clockFormat = if (isSystem24Hour) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H

        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(clockFormat)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Hora")
            .build()
        picker.show(childFragmentManager, "tag")

        picker.addOnPositiveButtonClickListener {
            hora = picker.hour.toString()
            minutos = picker.minute.toString()
            binding.textHour.editText?.setText(hora + ":" + minutos)
            Toast.makeText(requireContext(), "Hora" + picker.hour, Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // on below line we are displaying toast message for selected item.
//        Toast.makeText(requireContext(), "" + parent?.getItemAtPosition(position) + " Selected..", Toast.LENGTH_SHORT)
//            .show()
        if (parent?.getItemAtPosition(position)?.equals("Personalizar sonido") == true) {
//            Toast.makeText(requireContext(), "entro"  + " Selected..", Toast.LENGTH_SHORT)
//                .show()
            findNavController().navigate(R.id.fragmentSearchSong, null)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }

}