package com.theviciousgames.refreshratechecker.ui.main.view

import android.os.Build
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.theviciousgames.refreshratechecker.databinding.FragmentMenuBinding
import com.theviciousgames.refreshratechecker.databinding.ItemDisplayModeBinding

class ModeAdapter():RecyclerView.Adapter<ModeAdapter.ModeViewHolder>() {
    inner class ModeViewHolder(private val binding:ItemDisplayModeBinding):RecyclerView.ViewHolder(binding.root){
        @RequiresApi(Build.VERSION_CODES.M)
        fun bind(mode:Mode)
        {
            with(binding)
            {
                textviewRefreshRateMode.text="Mode $position: ${mode.refreshRate}"
            }
        }
    }

    private val differCallback=object :DiffUtil.ItemCallback<Mode>(){
        @RequiresApi(Build.VERSION_CODES.M)
        override fun areItemsTheSame(oldItem: Mode, newItem: Mode): Boolean {
            return oldItem.modeId==newItem.modeId
        }

        override fun areContentsTheSame(oldItem: Mode, newItem: Mode): Boolean {
           return oldItem==newItem
        }
    }
    val differ=AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeViewHolder {
        val binding =
            ItemDisplayModeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ModeViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }
}