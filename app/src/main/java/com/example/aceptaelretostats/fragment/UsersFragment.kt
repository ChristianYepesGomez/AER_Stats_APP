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
import com.example.aceptaelretostats.customClass.User
import com.example.aceptaelretostats.databinding.FragmentUsersBinding

class UsersFragment : Fragment() {

    private var userUtils: RecursosAPI = RecursosAPI()
    private lateinit var tableUsers: TableLayout
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private lateinit var usuarios: List<User>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        usuarios = userUtils.getUsers("getUsers")!!
        println(usuarios)
        if (usuarios != null) {
            println(usuarios[0])
        }
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

}