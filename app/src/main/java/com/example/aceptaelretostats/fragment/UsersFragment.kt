package com.example.aceptaelretostats.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aceptaelretostats.fragment.adapter.UserListAdapter
import com.example.aceptaelretostats.databinding.FragmentUsersBinding
import com.example.aceptaelretostats.ui.viewmodel.StatsViewModel


class UsersFragment : Fragment() {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private val statsViewModel: StatsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        statsViewModel.onCreate()


        statsViewModel.statsModel.observe(this, Observer {

            binding.idUserList.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = LinearLayoutManager(activity)
                // set the custom adapter to the RecyclerView

                adapter = UserListAdapter(it.users)

            }

        })

        binding.idBuscarUsuarios.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    statsViewModel.getUsersFilteredBy(newText)
                }
                return false
            }

        })


        binding.lookingForButtonUsers.setOnClickListener {
            if (binding.idBuscarUsuarios.isVisible) {
                binding.idBuscarUsuarios.visibility = View.GONE
            } else {
                binding.idBuscarUsuarios.visibility = View.VISIBLE
                binding.idBuscarUsuarios.requestFocus()
                binding.idBuscarUsuarios.setIconifiedByDefault(false)
                val imm =
                    context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(
                    InputMethodManager.SHOW_FORCED,
                    InputMethodManager.HIDE_IMPLICIT_ONLY
                )

            }
        }

        statsViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}


