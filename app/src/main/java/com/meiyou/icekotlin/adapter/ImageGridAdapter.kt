package com.meiyou.icekotlin.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.meiyou.icekotlin.R
import com.meiyou.icekotlin.data.ItemData
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

/**
 * Created by mu on 18/3/21.
 */
class ImageGridAdapter(var listItemData:List<ItemData>,var mContext: Context): BaseAdapter() {

    private val TAG:String="ImageGridAdapter"
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
            view = View.inflate(mContext, R.layout.item_grid, null);
            viewHolder = ViewHolder(view)
            view.tag = viewHolder;
        } else {
            view = p1;
            viewHolder = view.tag as ViewHolder
        }
        val item = getItem(p0)
        if(item is ItemData){
            //viewHolder.title.text = item.title;
            //viewHolder.content.text = item.content;
            viewHolder.imageview.loadImage(item.image)
        }

        return view!!

    }
    fun ImageView.loadImage(url:String){
        //Picasso.with(context).load(url).into(this)

        Picasso.get().load(url).into(this,object: Callback {
            override fun onSuccess() {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Log.d(TAG,"加载成功")
            }

            override fun onError(e: Exception?) {
                Log.e(TAG,"加载失败："+e?.message)
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    class ViewHolder(viewItem: View){
        //var title: TextView = viewItem.findViewById(R.id.title);
        //var content: TextView = viewItem.findViewById(R.id.content)
        var imageview: ImageView = viewItem.findViewById(R.id.imageview)
    }
}