package com.jo.dicechallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.jo.dicechallenge.databinding.FragmentGameSignupBinding
import com.jo.dicechallenge.databinding.FragmentHomeBinding

class GameSignup : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentGameSignupBinding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_game_signup,container,false)

        val name=binding.edname.getText()
             binding.btnstart.setOnClickListener{
                 if (name!=null){
            view?.findNavController()?.navigate(GameSignupDirections.actionGameSignupToGame(name.toString()))
             }
                 else{Toast.makeText(requireContext(),"you must enter your name",Toast.LENGTH_LONG).show()}

             }

    return binding.root
    }

    }