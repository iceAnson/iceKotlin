package com.meiyou.icekotlin.controller

import com.meiyou.icekotlin.data.ItemData

/**
 * 单例
 * Created by mu on 18/3/19.
 */
object  ImageListController {

    fun getData():List<ItemData>{
        var listItemData = ArrayList<ItemData>();
        for(i in 1..20){
            var item = ItemData()
            item.title="title".plus(i)
            item.content="content".plus(i)
            item.image ="https://sc.seeyouyima.com/my_wm_f7419f782befa6edd1efab8cd0625dfc_1080_1920.jpg?imageView2/1/w/324/h/216/format/webp";
            listItemData.add(item)
        }
        return listItemData;
    }
}