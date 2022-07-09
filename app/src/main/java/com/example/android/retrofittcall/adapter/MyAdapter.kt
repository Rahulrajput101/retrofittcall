package com.example.android.retrofittcall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.retrofittcall.databinding.RowLayoutBinding
import com.example.android.retrofittcall.model.Post

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

      private var myList = emptyList<Post>()

    fun setList(post: List<Post>){
        this.myList = post
        notifyDataSetChanged()
    }



     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         holder.bind(myList[position])
     }

     override fun getItemCount(): Int {
        return myList.size
     }


     class MyViewHolder( private val binding: RowLayoutBinding)  :  RecyclerView.ViewHolder(binding.root){


         companion object{

            fun from(parent: ViewGroup): MyViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = RowLayoutBinding.inflate(inflater,parent,false)
                return MyViewHolder(binding)
            }

         }


         fun bind(post: Post) {

             binding.userId.text = post.userId.toString()
             binding.idTxt.text = post.id.toString()
             binding.titleText.text = post.title
             binding.bodyTxt.text = post.body


         }

     }


 }