package com.meiyou.icekotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.meiyou.icekotlin.fragment.AboutFragment
import com.meiyou.icekotlin.fragment.GirlFragment
import com.meiyou.icekotlin.fragment.HomeFragment
import com.meiyou.icekotlin.view.NoScrollViewPager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var mFragments: MutableList<Fragment>
    private var mViewPager:NoScrollViewPager?=null;
    private var navigationView: android.support.design.widget.BottomNavigationView?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initFragments()
        initView()
        setListener()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun initFragments() {
        mFragments = ArrayList()
        mFragments.add(GirlFragment.newInstance())
        mFragments.add(HomeFragment.newInstance())
        mFragments.add(AboutFragment.newInstance())
        //mFragments.add(HomeFragment.newInstance())
        //mFragments.add(FragmentHolder())
    }

    private fun initView(){
        mViewPager = findViewById(R.id.viewPager)
        /*mViewPager?.adapter =object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int) = mFragments[position]
            override fun getCount() = mFragments.size
        }*/
        mViewPager?.adapter = object:FragmentPagerAdapter(supportFragmentManager){
            override fun getItem(position: Int): Fragment {
                return mFragments[position]
            }
            override fun getCount(): Int {
                return mFragments.size
            }
        }
        mViewPager?.offscreenPageLimit=3


       navigationView =  findViewById(R.id.navigationView)
        navigationView?.setOnNavigationItemSelectedListener { item ->
            var tab = 0
            when (item.itemId) {
                R.id.menu_home -> tab = 0
                R.id.menu_girl -> tab = 1
                R.id.menu_about -> tab = 2
                //R.id.menu_about -> tab = 3
            }
            mViewPager?.currentItem = tab
            false
        }

    }



    fun setListener(){
        /*findViewById<Button>(R.id.btnImageList).setOnClickListener { view ->
            val intent =  Intent()
            intent.setClass(applicationContext,ImageListActivity::class.java)
            startActivity(intent)
            //startActivity<ImageListActivity>()
        };*/
        /*fab.setOnClickListener { view ->
           Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                   .setAction("Action", null).show()
       }*/
    }

}
