package com.example.pets

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pets.Model.WalkerModel
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_profile.view.*
import kotlinx.android.synthetic.main.activity_search.view.*
import kotlinx.android.synthetic.main.activity_walker.view.*

class WalkerFragment : Fragment() {

    //etiqueta para el log
    private val TAG = "Actividad walkers"

    //configurar base de datos
    private var firestoreDB: FirebaseFirestore? = null

    private var adaptadorLista: AdaptadorLista? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater!!.inflate(R.layout.activity_walker, container, false)
        firestoreDB = FirebaseFirestore.getInstance()
        var walker: WalkerModel? = WalkerModel()

        firestoreDB!!.collection("walker")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (doc in task.result!!.documents) {
                        walker = doc.toObject<WalkerModel>(WalkerModel::class.java)
                        view.namewTextView.text = walker!!.name
                        view.commentwTextView.text = walker!!.comment
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.exception)
                }
            }

        return view
    }
}



