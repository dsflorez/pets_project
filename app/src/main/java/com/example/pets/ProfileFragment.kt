package com.example.pets

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pets.Model.ProfileModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_profile.view.*

class ProfileFragment : Fragment() {


    //etiqueta para el log
    private val TAG = "Actividad Profile"

    //configurar base de datos
    private var firestoreDB: FirebaseFirestore? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        firestoreDB = FirebaseFirestore.getInstance()

        var view = inflater!!.inflate(R.layout.activity_profile, container, false)
        var profile: ProfileModel? = ProfileModel()
        try {
            // some code

            var docRef: DocumentReference? = firestoreDB!!.collection("profile").document("8F3Y7yLEuNuYiY2LTnez")

            docRef!!.get().addOnCompleteListener() { task ->

                var document: DocumentSnapshot = task.result!!
                if (task.isSuccessful) {
                    profile = document.toObject<ProfileModel>(ProfileModel::class.java)
                    view.walkTextView.text = profile!!.walk
                    view.cellPhoneTextView.text = profile!!.cellPhone
                    view.videoTextView.text = profile!!.videos
                    view.followingTextView.text = profile!!.following
                    view.mailTextView.text = profile!!.mail
                    view.commentTextView.text = profile!!.comment
                } else {
                    Log.d(TAG, "get failed with ", task.exception)
                }

            }.addOnFailureListener { e ->
                print(e.stackTrace)
            }

        } catch (e: Exception) {
            print(e.stackTrace)
        }


        return view
    }

}
