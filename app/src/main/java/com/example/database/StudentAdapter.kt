package com.example.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class StudentAdapter(list: ArrayList<StudentsModel>) :
    RecyclerView.Adapter<StudentAdapter.StudentHolder>() {
    var list=list

    class StudentHolder(itemView: View) :ViewHolder(itemView) {
      var txtid=itemView.findViewById<TextView>(R.id.txtid)
      var txtname=itemView.findViewById<TextView>(R.id.txtname)
      var txtsurname=itemView.findViewById<TextView>(R.id.txtsurname)
        var txtaddress=itemView.findViewById<TextView>(R.id.txtaddress)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        return  StudentHolder(LayoutInflater.from(parent.context).inflate(R.layout.std_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {

        holder.txtid.text=list.get(position).id.toString()
        holder.txtname.text=list.get(position).name.toString()
        holder.txtsurname.text=list.get(position).surname.toString()
        holder.txtaddress.text=list.get(position).address.toString()


    }

}


