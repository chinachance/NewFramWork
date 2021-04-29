package com.haohao.framwork.haoframwork.framwork;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import android.util.AttributeSet;


/**
 * @author hao
 * @date 2017-1-18
 * @package com.ft.database.base
 * @description ImageView基类
 */
public class BaseImageView extends AppCompatImageView{

    private boolean isFeedBack;

    public BaseImageView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public BaseImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public BaseImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {

    }

}
