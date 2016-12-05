package com.lagoru.forex.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lagoru.forex.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by lagoru on 22.09.16.
 */
@EViewGroup(R.layout.single_attribute_view)
public class SingleAttributeView extends RelativeLayout {

    @ViewById
    TextView attributeName, attributeValueTextView;

    InformationAttribute informationAttribute;

    public SingleAttributeView(Context context) {
        super(context);
    }

    public SingleAttributeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SingleAttributeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setData(InformationAttribute informationAttribute) {
        this.informationAttribute = informationAttribute;
        attributeName.setText(informationAttribute.getAttributeName());
        attributeValueTextView.setText(informationAttribute.getAttributeValue());
    }

    @Click(R.id.wholeLayout)
    void click() {
        //TODO
    }
}
