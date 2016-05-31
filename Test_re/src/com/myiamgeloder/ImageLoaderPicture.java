package com.myiamgeloder;

import android.content.Context;

import com.example.test_re.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public class ImageLoaderPicture {
	private DisplayImageOptions options;
	 
    public ImageLoaderPicture(Context context) {
         
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY - 2)
        .denyCacheImageMultipleSizesInMemory()
        .discCacheFileNameGenerator(new Md5FileNameGenerator())
        .tasksProcessingOrder(QueueProcessingType.LIFO) 
        .memoryCache(new WeakMemoryCache()) 
        
        .build();
        ImageLoader.getInstance().init(config);
         
        options = new DisplayImageOptions.Builder()
        .showStubImage(0)
        .showImageForEmptyUri(R.drawable.cao)
        .showImageOnFail(R.drawable.cao)
        .cacheInMemory().cacheOnDisc()
        .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
        .bitmapConfig(android.graphics.Bitmap.Config.RGB_565)
        .showImageOnFail(R.drawable.cao)
        .showImageForEmptyUri(R.drawable.cao)
        
        .build();
    }
 
    public DisplayImageOptions getOptions() {
        return options;
    }
 
    public void setOptions(DisplayImageOptions options) {
        this.options = options;
    }
     

}
