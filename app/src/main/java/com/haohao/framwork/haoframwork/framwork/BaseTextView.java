package com.haohao.framwork.haoframwork.framwork;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import android.util.AttributeSet;


/**
 * @author hao
 * @date 2017-1-18
 * @package com.ft.database.base
 * @description TextView基类
 */
public class BaseTextView extends AppCompatTextView {
    private int currentTextColor;
    private boolean isFeedBack;

    public BaseTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public BaseTextView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        init(context, attrs, 0);
    }

    public BaseTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {

    }

}
