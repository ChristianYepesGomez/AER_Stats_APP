package com.example.aceptaelretostats.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import com.example.aceptaelretostats.databinding.FragmentUsersBinding
import android.widget.TableRow
import android.widget.TextView

class UsersFragment : Fragment() {

    private lateinit var tableUsers: TableLayout

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val tableUsers = binding.tableUsers
        var tr = TableRow(activity)
        var tv1 = TextView(activity)
        tv1.text = "usuarios[0].id";
        tv1.setTextColor(Color.BLACK);
        tv1.textSize = 20F;
        tv1.setPadding(5, 5, 5, 5);
        tr.addView(tv1);
        tableUsers.addView(tr)

    }


}