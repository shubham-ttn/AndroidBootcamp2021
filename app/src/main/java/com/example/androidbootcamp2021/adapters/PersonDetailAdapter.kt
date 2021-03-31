package com.example.androidbootcamp2021.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbootcamp2021.R
import com.example.androidbootcamp2021.PersonDataClass
import kotlinx.android.synthetic.main.item_person_view.view.*

class PersonDetailAdapter(
    private val context: Context,
    private val personsDataset: ArrayList<PersonDataClass>
): RecyclerView.Adapter<PersonDetailAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val personNameTextView: TextView = view.personName_TV
        val personContactTextView: TextView = view.personContact_TV
        val personAddressTextView: TextView = view.personAddress_TV
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_person_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = personsDataset.size

    // Replace the contents of a view (invoked by the layout manager)
    // Used to replace/update views at a specific position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val personID = personsDataset[position].personId
        val personName = personsDataset[position].personName
        val personContact = personsDataset[position].personContact
        val personAddress = personsDataset[position].personAddress

        holder.personNameTextView.text = personName
        holder.personContactTextView.text = personContact
        holder.personAddressTextView.text = personAddress
    }
}