package com.example.aceptaelretostats.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.Toast
import com.example.aceptaelretostats.R
import com.example.aceptaelretostats.RecursosAPI
import com.example.aceptaelretostats.databinding.FragmentUsersBinding

class UsersFragment : Fragment() {

    private var userUtils: RecursosAPI = RecursosAPI()
    private lateinit var tableUsers: TableLayout
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        userUtils.getUsers("getUsers")
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

}