package com.example.androidbootcamp2021

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyCustomAdapter(private val context: Context, private val listViewType: List<Int>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Creating companion object
    // to identify the view
    companion object {
        const val TEXT_OFFER_VIEW = 0
        const val IMAGE_OFFER_VIEW = 1
        const val IMAGE_WITH_BANNER_VIEW = 2
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolderText(view: View) : RecyclerView.ViewHolder(view) {
        val textOfferView: TextView = view.findViewById(R.id.bannerOfferTextView)
    }

    class ViewHolderImage(view: View) : RecyclerView.ViewHolder(view) {
        val imageOfferView: ImageView = view.findViewById(R.id.imageOfferImageView)
    }

    class ViewHolderImageWithText(view: View) : RecyclerView.ViewHolder(view) {
        val bannerWithImageBannerView: TextView =
            view.findViewById(R.id.imageWithBannerOfferTextView)
        val imageWithImageBannerView: ImageView = view.findViewById(R.id.imageWithBannerImageView)
    }

    override fun getItemViewType(position: Int): Int = listViewType[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        // Create a new view, which defines the UI of the list item
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TEXT_OFFER_VIEW -> ViewHolderText(inflater.inflate(R.layout.row_text_view, parent, false))
            IMAGE_OFFER_VIEW -> ViewHolderImage(inflater.inflate(R.layout.row_image_view, parent, false))
            IMAGE_WITH_BANNER_VIEW -> ViewHolderImageWithText(inflater.inflate(R.layout.row_text_image_view, parent, false))
            else -> throw IllegalArgumentException("No ViewHolder")
        }
    }

    override fun getItemCount(): Int = listViewType.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(listViewType[position]) {
            TEXT_OFFER_VIEW -> {
                val viewHolderText = holder as ViewHolderText
                viewHolderText.textOfferView.text = context.getString(R.string.dummy_offer)
            }
            IMAGE_OFFER_VIEW -> {
                val viewHolderImage = holder as ViewHolderImage
                viewHolderImage.imageOfferView.setImageResource(R.drawable.amazon_image_offer1)
            }
            IMAGE_WITH_BANNER_VIEW -> {
                val viewHolderImage = holder as ViewHolderImageWithText
                viewHolderImage.imageWithImageBannerView.setImageResource(R.drawable.amazon_banner_image)
                viewHolderImage.bannerWithImageBannerView.text = context.getString(R.string.offer_for_image_text_banner)
            }
        }
    }

}