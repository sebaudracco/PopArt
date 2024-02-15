package com.example.poparticlestest.core.base.view

import IOnItemClickViewHolder
import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.poparticlestest.main.datasource.entity.Results

abstract class BaseViewHolder<T>(
    binding: ViewBinding,
    private val onItemClickListener: IOnItemClickViewHolder? = null
) : RecyclerView.ViewHolder(binding.root) {
    lateinit var dataList: Results
    init {
        binding.root.setOnClickListener {
            if (isActionEnable()) onItemClickListener?.onItemClick(it, adapterPosition, dataList)
        }
    }

    var data: T? = null
        private set

    open fun bindingDataInHolder(data: T) {
        this.data = data
    }

    private var mLastClickTime: Long = 0

    protected fun isActionEnable(): Boolean {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return false
        }
        mLastClickTime = SystemClock.elapsedRealtime()
        return true
    }

}