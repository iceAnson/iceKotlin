package com.meiyou.icekotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.meiyou.icekotlin.R

/**
 * Created by mu on 18/3/21.
 */
class AboutFragment:Fragment(){
    //静态方法
    companion object {
        fun newInstance(): AboutFragment {
            val fragment = AboutFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater?.inflate(R.layout.activity_about,null)
        var text = view?.findViewById<TextView>(R.id.text)
        text?.text="${text?.text} \n  Kotlin "
        return view
    }

}