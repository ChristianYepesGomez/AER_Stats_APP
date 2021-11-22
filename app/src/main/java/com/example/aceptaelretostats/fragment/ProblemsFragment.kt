package com.example.aceptaelretostats.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aceptaelretostats.fragment.adapter.ProblemListAdapter
import com.example.aceptaelretostats.databinding.FragmentProblemsBinding
import com.example.aceptaelretostats.ui.viewmodel.StatsViewModel

class ProblemsFragment : Fragment() {
    private var _binding: FragmentProblemsBinding? = null
    private val binding get() = _binding!!
    private val statsViewModel: StatsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProblemsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        statsViewModel.onCreate()

        statsViewModel.statsModel.observe(this, Observer {


            binding.idProblemList.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = LinearLayoutManager(activity)
                // set the custom adapter to the RecyclerView
                adapter =
                    ProblemListAdapter(it.problems)
            }

        })

        statsViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        binding.idBuscarProblemas.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    statsViewModel.getProblemsFilteredBy(newText)
                }
                return false
            }

        })

        binding.lookingForButtonProblems.setOnClickListener {
            if (binding.idBuscarProblemas.isVisible) {
                binding.idBuscarProblemas.visibility = View.GONE
            } else {
                binding.idBuscarProblemas.visibility = View.VISIBLE
                binding.idBuscarProblemas.requestFocus()
                binding.idBuscarProblemas.setIconifiedByDefault(false)
            }
        }

        statsViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })



        return binding.root
    }

}