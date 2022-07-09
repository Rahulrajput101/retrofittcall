package com.example.android.retrofittcall

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.retrofittcall.adapter.MyAdapter
import com.example.android.retrofittcall.databinding.FragmentMainBinding
import com.example.android.retrofittcall.viewModel.MainViewModel


class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var adapter : MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        adapter = MyAdapter()
        binding.recylerView.adapter = adapter
        binding.recylerView.layoutManager = LinearLayoutManager(requireContext())

        val option: HashMap<String, String> = HashMap()
        option["_sort"] = "id"
        option["_order"] = "desc"


        binding.get.setOnClickListener {
            val myNumber = binding.editText.text.toString()
            viewModel.getMyCustomResponse2(Integer.parseInt(myNumber), option)
            viewModel.myCustomResponse2.observe(viewLifecycleOwner) {
                if (it.isSuccessful) {
                    Toast.makeText(requireContext(), "Successful", Toast.LENGTH_SHORT).show()
                    adapter.setList(it.body()!!)

                } else {
                    Toast.makeText(requireContext(), it.code(), Toast.LENGTH_SHORT).show()
                }
            }


        }
        return binding.root


    }

}