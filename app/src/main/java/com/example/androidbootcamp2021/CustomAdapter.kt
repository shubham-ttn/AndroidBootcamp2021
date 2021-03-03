package com.example.androidbootcamp2021

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val dataSet: ArrayList<DataClass>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleTextView: TextView
        val addressTextView: TextView
        val imageView: ImageView
        val ratingBar: RatingBar
        val numOfReviewsTextView: TextView
        val dateTextView: TextView
        val amountTextView: TextView

        // attach reference of views
        init {
            titleTextView = view.findViewById(R.id.titleTextView1)
            addressTextView = view.findViewById(R.id.subtitleTextView1)
            imageView = view.findViewById(R.id.imageView1)
            ratingBar = view.findViewById(R.id.ratingBar1)
            numOfReviewsTextView = view.findViewById(R.id.numOfReviewsTV)
            dateTextView = view.findViewById(R.id.dateTextView)
            amountTextView = view.findViewById(R.id.amountTextView)
        }

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {

        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    // Replace the contents of a view (invoked by the layout manager)
    // Used to replace/update views at a specific position
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.titleTextView.text = dataSet[position].title
        holder.addressTextView.text = dataSet[position].address
        holder.imageView.setImageResource(dataSet[position].imageID)
        holder.ratingBar.numStars = dataSet[position].numOfStarRatings
        holder.numOfReviewsTextView.text = dataSet[position].numOfReview
        holder.dateTextView.text = dataSet[position].date
        holder.amountTextView.text = dataSet[position].amount

    }

}