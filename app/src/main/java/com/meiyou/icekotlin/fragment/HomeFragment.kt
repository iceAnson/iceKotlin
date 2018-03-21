package com.meiyou.icekotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.meiyou.icekotlin.R
import com.meiyou.icekotlin.adapter.ImageListAdapter
import com.meiyou.icekotlin.controller.ImageListLazyController

/**
 * Created by mu on 18/3/21.
 */
class HomeFragment:Fragment(){

    //静态方法
    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var mListView: ListView?=null;
    private var mAdapter: ImageListAdapter?=null;
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater?.inflate(R.layout.activity_image_list,null)
        initView(view)
        fillView()
        return view
    }

    fun initView(view:View?){
        mListView = view?.findViewById(R.id.listview_image)
    }

    fun fillView(){
        var listItemData = ImageListLazyController.instance.getData()
        mAdapter = ImageListAdapter(listItemData,context)
        mListView?.adapter = mAdapter;
        mAdapter?.notifyDataSetChanged()
    }
}