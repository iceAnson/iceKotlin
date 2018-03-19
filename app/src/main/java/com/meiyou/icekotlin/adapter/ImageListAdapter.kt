package com.meiyou.icekotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.meiyou.icekotlin.R
import com.meiyou.icekotlin.data.ItemData
import com.squareup.picasso.Picasso

/**
 * Created by mu on 18/3/19.
 */
class ImageListAdapter(var listItemData:List<ItemData>,var mContext: Context): BaseAdapter() {

   /* var listItemData:List<ItemData>?=null
    var mContext:Context?=null*/
    var mInflater: LayoutInflater? = null
    init {
      /*  this.listItemData = list;
        this.mContext = context;*/
        this.mInflater = LayoutInflater.from(mContext)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getViewTypeCount(): Int {
        return super.getViewTypeCount()
    }
    override fun getCount(): Int {
        return listItemData.size

    }
    override fun getItemId(p0: Int): Long {
        return 0
    }
    override fun getItem(p0: Int): Any {
        return  listItemData.get(p0)

    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var viewHolder: ViewHolder? = null
        var view: View
        if (p1 == null) {
            view = View.inflate(mContext, R.layout.item_image_list, null);
            viewHolder = ViewHolder(view)
            view.tag = viewHolder;
        } else {
            view = p1;
            viewHolder = view.tag as ViewHolder
        }
        val item = getItem(p0)
        if(item is ItemData){
            viewHolder.title.text = item.title;
            viewHolder.content.text = item.content;
            viewHolder.imageview.loadImage(item.image)
        }
        if (item is String) {
            /**
             *直接通过view.text设置文本信息
             */
            viewHolder.title.text = item;
        }
        return view!!

    }
    fun ImageView.loadImage(url:String){
        //Picasso.with(context).load(url).into(this)

        Picasso.get().load(url).into(this)
    }

    class ViewHolder(viewItem:View){
        var title: TextView = viewItem.findViewById(R.id.title);
        var content:TextView = viewItem.findViewById(R.id.content)
        var imageview:ImageView = viewItem.findViewById(R.id.imageview)
    }
}