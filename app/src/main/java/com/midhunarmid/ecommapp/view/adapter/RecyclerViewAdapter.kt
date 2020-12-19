package com.midhunarmid.ecommapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.midhunarmid.ecommapp.R
import com.midhunarmid.ecommapp.repository.model.Banner
import com.midhunarmid.ecommapp.repository.model.Carousel
import com.midhunarmid.ecommapp.repository.model.Products
import com.midhunarmid.ecommapp.repository.model.ResponseData
import com.squareup.picasso.Picasso
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class RecyclerViewAdapter(context: Context, var responseData: ResponseData) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_BANNER = 1
        const val VIEW_TYPE_PRODUCT = 2
        const val VIEW_TYPE_CAROUSEL = 3
    }

    private val context: Context = context
    private val list = getListFromResponseData(responseData)


    private inner class BannerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var bannerImage: ImageView = itemView.findViewById(R.id.imgBanner)
        fun bind(position: Int) {
            val recyclerViewModel = list[position] as Banner
            Picasso.get().load(recyclerViewModel.items?.get(0) ?: "").into(bannerImage)
        }
    }

    private inner class ProductsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var img1: ImageView = itemView.findViewById(R.id.imgProduct1)
        var img2: ImageView = itemView.findViewById(R.id.imgProduct2)
        var img3: ImageView = itemView.findViewById(R.id.imgProduct3)
        var img4: ImageView = itemView.findViewById(R.id.imgProduct4)

        var txt1: TextView = itemView.findViewById(R.id.txtProduct1)
        var txt2: TextView = itemView.findViewById(R.id.txtProduct2)
        var txt3: TextView = itemView.findViewById(R.id.txtProduct3)
        var txt4: TextView = itemView.findViewById(R.id.txtProduct4)

        var subTxt1: TextView = itemView.findViewById(R.id.txtProductSub1)
        var subTxt2: TextView = itemView.findViewById(R.id.txtProductSub2)
        var subTxt3: TextView = itemView.findViewById(R.id.txtProductSub3)
        var subTxt4: TextView = itemView.findViewById(R.id.txtProductSub4)

        fun bind(position: Int) {
            val recyclerViewModel = list[position] as Products
            Picasso.get().load(recyclerViewModel.items?.get(0)?.image ?: "").into(img1)
            Picasso.get().load(recyclerViewModel.items?.get(1)?.image ?: "").into(img2)
            Picasso.get().load(recyclerViewModel.items?.get(2)?.image ?: "").into(img3)
            Picasso.get().load(recyclerViewModel.items?.get(3)?.image ?: "").into(img4)

            txt1.text = recyclerViewModel.items?.get(0)?.title
            txt2.text = recyclerViewModel.items?.get(1)?.title
            txt3.text = recyclerViewModel.items?.get(2)?.title
            txt4.text = recyclerViewModel.items?.get(3)?.title

            subTxt1.text = recyclerViewModel.items?.get(0)?.subtitle
            subTxt2.text = recyclerViewModel.items?.get(1)?.subtitle
            subTxt3.text = recyclerViewModel.items?.get(2)?.subtitle
            subTxt4.text = recyclerViewModel.items?.get(3)?.subtitle
        }
    }

    private inner class CarouselViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var carousel: ImageCarousel = itemView.findViewById(R.id.carousel)
        val carouselItemList = mutableListOf<CarouselItem>()

        fun bind(position: Int) {
            val recyclerViewModel = list[position] as Carousel
            recyclerViewModel.items?.map {
                carouselItemList.add(
                    CarouselItem(
                        imageUrl = it.image
                    )
                )
            }

            carousel.addData(carouselItemList)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_BANNER) {
            return BannerViewHolder(
                LayoutInflater.from(context).inflate(R.layout.banner_widget, parent, false)
            )
        } else if (viewType == VIEW_TYPE_PRODUCT) {
            return ProductsViewHolder(
                LayoutInflater.from(context).inflate(R.layout.products_widget, parent, false)
            )
        } else if (viewType == VIEW_TYPE_CAROUSEL) {
            return CarouselViewHolder(
                LayoutInflater.from(context).inflate(R.layout.carousel_widget, parent, false)
            )
        } else {
            return BannerViewHolder(
                LayoutInflater.from(context).inflate(R.layout.banner_widget, parent, false)
            )
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (list[position] is Banner) {
            (holder as BannerViewHolder).bind(position)
        } else if (list[position] is Products) {
            (holder as ProductsViewHolder).bind(position)
        } else if (list[position] is Carousel) {
            (holder as CarouselViewHolder).bind(position)
        } else {
            (holder as BannerViewHolder).bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is Banner -> VIEW_TYPE_BANNER
            is Products -> VIEW_TYPE_PRODUCT
            is Carousel -> VIEW_TYPE_CAROUSEL
            else -> VIEW_TYPE_BANNER
        }
    }

    fun getListFromResponseData(responseData: ResponseData): List<Any?> {
        val list: ArrayList<Any?> = ArrayList()
        /* TODO: Have to implement sorting login here based on the 'order' here */
        if (responseData.carousel != null) list.add(responseData.carousel)
        if (responseData.products != null) list.add(responseData.products)
        if (responseData.banner != null) list.add(responseData.banner)
        return list
    }
}