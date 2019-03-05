package binar.abika.binarcodechallange.feature

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import binar.abika.binarcodechallange.R
import kotlinx.android.synthetic.main.item_android.view.*

class AndroidAdapter : RecyclerView.Adapter<AndroidAdapter.ViewHolder>() {
    private val androidlist = mutableListOf<Android>()
    private lateinit var ctx: Context

    fun addAndroidList(androids: MutableList<Android>) {
        androidlist.clear()
        androidlist.addAll(androids)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        ctx = viewGroup.context
        val itemView = LayoutInflater.from(ctx).inflate(R.layout.item_android, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return androidlist.count()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                Toast.makeText(ctx, "Android Clicked $adapterPosition", Toast.LENGTH_SHORT).show()
            }
        }


        fun bind(position: Int) {
            val andro = androidlist[position]
            itemView.tv_item_android_android.text = andro.android
            itemView.tv_item_android_version.text = andro.version
            itemView.tv_item_android_level.text = andro.level
        }
    }

}