package com.meiyou.icekotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment

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
}