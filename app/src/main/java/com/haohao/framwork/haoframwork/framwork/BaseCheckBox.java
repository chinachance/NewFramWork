package com.haohao.framwork.haoframwork.framwork;

import android.content.Context;
import androidx.appcompat.widget.AppCompatCheckBox;
import android.util.AttributeSet;

/**
 * @author hao
 * @date 2017-1-18
 * @package com.ft.database.base
 * @description CheckBox基类
 */
public class BaseCheckBox extends AppCompatCheckBox {
	public BaseCheckBox(Context context) {
		super(context);
		init(context);
	}

	public BaseCheckBox(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public BaseCheckBox(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	private void init(Context context) {

	}

}
