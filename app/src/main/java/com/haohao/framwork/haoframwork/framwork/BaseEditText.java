package com.haohao.framwork.haoframwork.framwork;

import android.content.Context;
import android.util.AttributeSet;

/**
 * @author hao
 * @date 2017-1-18
 * @package com.ft.database.base
 * @description EditText基类
 */
public class BaseEditText extends androidx.appcompat.widget.AppCompatEditText {
	public BaseEditText(Context context) {
		super(context);
		init();
	}

	public BaseEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public BaseEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {

	}
}
