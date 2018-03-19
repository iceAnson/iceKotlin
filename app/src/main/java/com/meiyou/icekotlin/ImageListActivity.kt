package com.meiyou.icekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.meiyou.icekotlin.adapter.ImageListAdapter
import com.meiyou.icekotlin.controller.ImageListLazyController


/**
 * Created by mu on 18/3/19.
 */
class ImageListActivity:AppCompatActivity(){

    private var mListView: ListView?=null;
    private var mAdapter: ImageListAdapter?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_list);
        initUI()
        initLogic()
        setListener()
    }
    fun initUI(){
        mListView = findViewById(R.id.listview_image);
    }
    fun initLogic(){
        //var listItemData  = ImageListController.getData()
        var listItemData = ImageListLazyController.instance.getData()
        mAdapter = ImageListAdapter(listItemData,applicationContext)
        mListView?.adapter = mAdapter;
        mAdapter?.notifyDataSetChanged()
    }
    fun setListener(){
        mListView?.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->
            //YOUR CODE HERE}
            Toast.makeText(applicationContext,"i click ${i}",Toast.LENGTH_SHORT).show()
        });
    }
}