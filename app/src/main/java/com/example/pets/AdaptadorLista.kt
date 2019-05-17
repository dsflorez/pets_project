package com.example.pets

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pets.Model.WalkerModel
import com.google.firebase.firestore.FirebaseFirestore

class AdaptadorLista(
    private val listaRegistro: MutableList<WalkerModel>,
    private val contexto: Context,
    private val firestoreDB: FirebaseFirestore
) : RecyclerView.Adapter<AdaptadorLista.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0!!.context).inflate(R.layout.activity_walker, p0, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val registro = listaRegistro[p1]

        p0!!.name.text = registro.name
        p0.comment.text = registro.comment
    }


    override fun getItemCount(): Int {
        return listaRegistro.size
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var name: TextView
        internal var comment: TextView

        init {
            name = view.findViewById(R.id.namewTextView)
            comment = view.findViewById(R.id.commentwTextView)
        }
    }
}
