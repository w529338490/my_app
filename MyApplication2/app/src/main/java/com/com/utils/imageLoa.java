package com.com.utils;

import android.content.Context;

import com.example.administrator.myapplication.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

/**
 * Created by Administrator on 2016/5/27.
 */
public class imageLoa {


    private DisplayImageOptions options;

    public imageLoa(Context context) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .memoryCache(new WeakMemoryCache())
                .build();
        ImageLoader.getInstance().init(config);

        options = new DisplayImageOptions.Builder()
                .showStubImage(0)
                .showImageOnLoading(R.drawable.logo)
                .cacheOnDisk(false)
                .showImageForEmptyUri(R.drawable.logo)
                .showImageOnFail(R.drawable.logo)
                .cacheInMemory().cacheOnDisc()
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
                .bitmapConfig(android.graphics.Bitmap.Config.RGB_565)
                .build();
    }

    public DisplayImageOptions getOptions() {
        return options;
    }

    public void setOptions(DisplayImageOptions options) {
        this.options = options;
    }


}
