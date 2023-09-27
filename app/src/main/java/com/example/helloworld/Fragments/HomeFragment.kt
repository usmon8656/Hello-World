package com.example.helloworld.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.asadullo.wordsapp.R
import com.asadullo.wordsapp.databinding.FragmentHomeBinding
import com.asadullo.wordsapp.databinding.ItemDialogBinding
import com.example.helloworld.Adapter.MyAdapter
import com.example.helloworld.DB.DbHelperWords
import com.example.helloworld.Models.User
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragment : Fragment() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private lateinit var dbHelper: DbHelperWords
    private lateinit var adapter: MyAdapter
    private lateinit var list :ArrayList<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dbHelper = DbHelperWords.getIns(binding.root.context)
        list = dbHelper.dao().getAllGroups() as ArrayList<User>
        adapter = MyAdapter(list, object : MyAdapter.Clikc{
            override fun click(user: User, position: Int, unit: String) {
                findNavController().navigate(R.id.wordsFragment, bundleOf("group" to unit, "keyGroup" to user))
            }
        })
        binding.rv.adapter = adapter

        binding.add.setOnClickListener {
            val item = ItemDialogBinding.inflate(LayoutInflater.from(binding.root.context))
            val dialog = BottomSheetDialog(binding.root.context)
            dialog.setContentView(item.root)

            item.btnAdd.setOnClickListener {
                val user = User(item.edtGroupName.text.toString())
                dbHelper.dao().addGroup(user)
                binding.rv.adapter = adapter
                onResume()
                dialog.dismiss()
            }

            dialog.show()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        adapter.list.clear()
        adapter.list.addAll(dbHelper.dao().getAllGroups())
        adapter.notifyDataSetChanged()
    }


}