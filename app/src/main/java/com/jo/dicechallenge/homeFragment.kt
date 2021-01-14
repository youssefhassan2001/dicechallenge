package com.jo.dicechallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.jo.dicechallenge.databinding.FragmentHomeBinding

class homeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
binding.button.setOnClickListener {
    view?.findNavController()?.navigate(R.id.action_homeFragment_to_gameSignup)
}

        return binding.root
    }

}