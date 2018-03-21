package com.meiyou.icekotlin.controller

import com.meiyou.icekotlin.data.ItemData
import java.util.*

/**
 * 内部类单例懒加载模式
 * Created by mu on 18/3/19.
 */
class ImageListLazyController private constructor(){

    companion object {
        var instance = Holder.INSTANCE;
    }

    private object Holder{
        val INSTANCE =  ImageListLazyController();
    }

    fun getData():List<ItemData>{
        var listItemData = ArrayList<ItemData>();
        for(i in 1..20){
            var item = ItemData()
            item.title="Yesterday you said tommrow${i}"
            item.content="想去吃，想去浪，想做天上忽暗忽明的云".plus(i)
            if(i<mImageList.size){
                item.image =mImageList[i];
            }else{
                item.image ="http://7xi8d6.com1.z0.glb.clouddn.com/20180129074038_O3ydq4_Screenshot.jpeg";
            }
            listItemData.add(item)
        }
        return listItemData;
    }
    private val mImageList = Arrays.asList(
            "http://ws1.sinaimg.cn/large/610dc034ly1foowtrkpvkj20sg0izdkx.jpg"
            ,"http://7xi8d6.com1.z0.glb.clouddn.com/20180129074038_O3ydq4_Screenshot.jpeg"
            ,"http://7xi8d6.com1.z0.glb.clouddn.com/20180122090204_A4hNiG_Screenshot.jpeg"
            ,"http://7xi8d6.com1.z0.glb.clouddn.com/20180115085556_8AeReR_taeyeon_ss_15_1_2018_7_58_51_833.jpeg"
            ,"http://7xi8d6.com1.z0.glb.clouddn.com/20180109085038_4A7atU_rakukoo_9_1_2018_8_50_25_276.jpeg");



    fun getGirlData():List<ItemData>{
        var listItemData = ArrayList<ItemData>();
        for(i in 1..20){
            var item = ItemData()
            item.title="Yesterday you said tommrow${i}"
            item.content="想去吃，想去浪，想做天上忽暗忽明的云".plus(i)
            if(i<mImageList.size){
                item.image =mImageList[i];
            }else{
                item.image ="http://7xi8d6.com1.z0.glb.clouddn.com/20180129074038_O3ydq4_Screenshot.jpeg";
            }

            listItemData.add(item)
        }
        return listItemData;
    }



}