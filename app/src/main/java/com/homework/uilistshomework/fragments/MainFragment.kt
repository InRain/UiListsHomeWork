package com.homework.uilistshomework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.homework.uilistshomework.FragmentContentType
import com.homework.uilistshomework.adapters.Adapter
import com.homework.uilistshomework.databinding.FragmentMainBinding
import com.homework.uilistshomework.fakedatasource.FakeDataSource


class MainFragment(private val contentType: FragmentContentType) : Fragment() {

    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        val adapter = Adapter() {
            Toast.makeText(activity, "Position = $it", Toast.LENGTH_SHORT).show()

        }

        when (FragmentContentType.create(contentType.value)) {
            FragmentContentType.TAXI -> adapter.itemList = FakeDataSource.getTaxies()
            FragmentContentType.CARS_AND_MOTORCYCLES -> adapter.itemList =
                FakeDataSource.getCarsAndMotorcycles()
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }


}