package com.example.encoraassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.encoraassignment.databinding.ListItemBinding
import com.example.encoraassignment.listeners.CallbackListener
import com.example.encoraassignment.localDB.SongsModel

import com.example.encoraassignment.model.Entry
import com.squareup.picasso.Picasso


class ListAdapter(dataList: List<SongsModel>, listener: CallbackListener) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private val mDataList: List<SongsModel>
    private val mListener: CallbackListener

    init {
        mDataList = dataList
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ListItemBinding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data: SongsModel = mDataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    inner class MyViewHolder(binding: ListItemBinding) : ViewHolder(binding.getRoot()) {
        private val binding: ListItemBinding

        init {
            this.binding = binding
        }

        fun bind(data: SongsModel) {
            data.image170?.let {
                Picasso.get().load(it).into(binding.item)
            }
            binding.title.text = data.name ?: ""
            binding.item.setOnClickListener {
                mListener.demoItemClick(data)
            }
        }
    }
}

