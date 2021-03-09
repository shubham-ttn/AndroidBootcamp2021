package com.example.androidbootcamp2021

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context, private val employeeData: ArrayList<EmployeeDataClass>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private val databaseManager = SQLiteDatabaseManager(context)

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.empNameTextView)
        val contactTextView: TextView = view.findViewById(R.id.empContactTextView)
        val addressTextView: TextView = view.findViewById(R.id.empAddressTextView)
        val editDataImgBtn: ImageButton = view.findViewById(R.id.editEmpDetailsBtn)
        val deleteDataImgBtn: ImageButton = view.findViewById<ImageButton>(R.id.deleteEmpDetailsBtn)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employee_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = employeeData.size

    // Replace the contents of a view (invoked by the layout manager)
    // Used to replace/update views at a specific position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTextView.text = employeeData[position].name
        holder.contactTextView.text = employeeData[position].contact
        holder.addressTextView.text = employeeData[position].address

        val empId = employeeData[position].id

        holder.deleteDataImgBtn.setOnClickListener {
            databaseManager.deleteAnEmployeeData(empId!!)
        }

        holder.editDataImgBtn.setOnClickListener {
            // Open the activity where
            // User can edit and update
            // details
        }


    }
}