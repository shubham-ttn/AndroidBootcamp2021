package com.example.androidbootcamp2021.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidbootcamp2021.R
import com.example.androidbootcamp2021.models.DataModel


class PostDetailsAdapter(private val context: Context, private val dataSet: List<DataModel>) :
    RecyclerView.Adapter<PostDetailsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postAuthorTextView: TextView = view.findViewById(R.id.name_TV)
        val postMsgTextView: TextView = view.findViewById(R.id.post_Msg_TV)
        val postImageView: ImageView = view.findViewById(R.id.post_IV)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostDetailsAdapter.ViewHolder {

        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    // Replace the contents of a view (invoked by the layout manager)
    // Used to replace/update views at a specific position
    override fun onBindViewHolder(holder: PostDetailsAdapter.ViewHolder, position: Int) {
        holder.postAuthorTextView.text = dataSet[position].postName
        holder.postMsgTextView.text = dataSet[position].postMessage

        val profileImgURL = dataSet[position].postProfileImgURL
        Glide.with(context).load(profileImgURL).placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.postImageView)

    }
}