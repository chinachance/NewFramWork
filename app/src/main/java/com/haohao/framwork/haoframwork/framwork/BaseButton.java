package com.haohao.framwork.haoframwork.framwork;

import android.content.Context;
import androidx.appcompat.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * @author hao
 * @date 2017-1-18
 * @package com.ft.database.base
 * @description Button基类
 */
public class BaseButton extends AppCompatButton {
	public BaseButton(Context context) {
		super(context);
		init();
	}

	public BaseButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public BaseButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {

	}
}
