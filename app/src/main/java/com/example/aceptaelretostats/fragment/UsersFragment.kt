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
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mvvm.model.UserModel
import com.example.mvvm.ui.viewmodel.UserViewModel


class UsersFragment : Fragment() {

    private lateinit var tableUsers: TableLayout
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        userViewModel.onCreate()

        userViewModel.quoteModel.observe(this, Observer {

            //val tableUsers = binding.tableUsers

//            for (user in it) {
//                var fila = TableRow(activity)
//
//                fila.addView(crearTextView(user.id));
//                fila.addView(crearTextView(user.nick));
//                fila.addView(crearTextView(user.accepteds));
//                fila.addView(crearTextView(user.intents));
//                fila.addView(crearTextView(user.resolved));
//                tableUsers.addView(fila)
//
//            }

        })

        userViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }

    fun crearTextView(value: String): TextView {
        val textView = TextView(activity)
        textView.text = value
        textView.setTextColor(Color.BLACK);
        textView.textSize = 15F;
        textView.setPadding(5, 5, 5, 5);
        return textView
    }


}