package com.meiyou.icekotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ListView
import com.meiyou.icekotlin.R
import com.meiyou.icekotlin.adapter.ImageGridAdapter
import com.meiyou.icekotlin.adapter.ImageListAdapter
import com.meiyou.icekotlin.controller.ImageListLazyController

/**
 * Created by mu on 18/3/21.
 */
class GirlFragment:Fragment(){
    //静态方法
    companion object {
        fun newInstance(): GirlFragment {
            val fragment = GirlFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }


    private var mGridView: GridView?=null;
    private var mAdapter: ImageGridAdapter?=null;
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater?.inflate(R.layout.activity_grid,null)
        initView(view)
        fillView()
        return view
    }

    fun initView(view: View?){
        mGridView = view?.findViewById(R.id.gridview_image)
        mGridView?.numColumns=2
        mGridView?.horizontalSpacing=5
        mGridView?.verticalSpacing=5
    }

    fun fillView(){
        var listItemData = ImageListLazyController.instance.getGirlData()
        mAdapter = ImageGridAdapter(listItemData,context)
        mGridView?.adapter = mAdapter;
        mAdapter?.notifyDataSetChanged()
    }
}