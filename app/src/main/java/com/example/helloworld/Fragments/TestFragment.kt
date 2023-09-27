package com.example.helloworld.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.asadullo.wordsapp.R
import com.asadullo.wordsapp.databinding.FragmentTestBinding
import com.example.helloworld.DB.DbHelperWords
import com.example.helloworld.Models.UserWords

class TestFragment : Fragment() {
    private val binding by lazy { FragmentTestBinding.inflate(layoutInflater) }
    var javob1 = true
    var javob2 = true
    var javob3 = true
    var javob4 = true
    private lateinit var dbHelperWords: DbHelperWords
    private lateinit var list:ArrayList<UserWords>
    var count = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list = bundleOf().getSerializable("keyList") as ArrayList<UserWords>

        list.shuffle()


        binding.javob1.setOnClickListener {
            if (javob1){
                binding.javob1.setBackgroundResource(R.drawable.r_1)
                binding.javob2.setBackgroundResource(R.drawable.r_2)
                binding.javob3.setBackgroundResource(R.drawable.r_2)
                binding.javob4.setBackgroundResource(R.drawable.r_2)
            }
        }

        binding.javob2.setOnClickListener {
            if (javob2){
                binding.javob1.setBackgroundResource(R.drawable.r_2)
                binding.javob2.setBackgroundResource(R.drawable.r_1)
                binding.javob3.setBackgroundResource(R.drawable.r_2)
                binding.javob4.setBackgroundResource(R.drawable.r_2)
            }
        }

        binding.javob3.setOnClickListener {
            if (javob3){
                binding.javob1.setBackgroundResource(R.drawable.r_2)
                binding.javob2.setBackgroundResource(R.drawable.r_2)
                binding.javob3.setBackgroundResource(R.drawable.r_1)
                binding.javob4.setBackgroundResource(R.drawable.r_2)
            }
        }

        binding.javob4.setOnClickListener {
            if (javob4){
                binding.javob1.setBackgroundResource(R.drawable.r_2)
                binding.javob2.setBackgroundResource(R.drawable.r_2)
                binding.javob3.setBackgroundResource(R.drawable.r_2)
                binding.javob4.setBackgroundResource(R.drawable.r_1)
            }
        }

        return binding.root
    }

    fun writeQuestion(){
        binding.textWord.text = list[count].eng
    }

}