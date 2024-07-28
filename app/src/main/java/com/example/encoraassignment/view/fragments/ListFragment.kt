package com.example.encoraassignment.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.encoraassignment.R
import com.example.encoraassignment.adapter.ListAdapter
import com.example.encoraassignment.databinding.ActivityListBinding
import com.example.encoraassignment.listeners.CallbackListener
import com.example.encoraassignment.localDB.SongsModel
import com.example.encoraassignment.utility.Utility
import com.example.encoraassignment.utility.Utility.goToDetailFrag
import com.example.encoraassignment.view.activity.MainActivity

class ListFragment : Fragment(), CallbackListener {
    //https://jsonplaceholder.typicode.com/photos
    lateinit var binding: ActivityListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.activity_list, container, false
        )
        binding.lifecycleOwner=viewLifecycleOwner
        setData()
        return binding.root
    }

    fun setData() {


        Utility.getTopActivity()?.let {
            if(it is MainActivity){
                it.model._list.observe(viewLifecycleOwner, Observer { entries ->
                    val adapter=ListAdapter(entries, this)
                    binding.list.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                    binding.list.adapter = adapter
                })
                it.model.hitAPI()
            }
        }
    }

    override fun demoItemClick(item: SongsModel) {
item.goToDetailFrag()
    }
}