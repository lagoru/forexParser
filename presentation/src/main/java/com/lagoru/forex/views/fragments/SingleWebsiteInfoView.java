package com.lagoru.forex.views.fragments;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lagoru.forex.R;
import com.lagoru.forex.data.model.Information;
import com.lagoru.forex.utils.DateUtils;

import butterknife.BindView;

/**
 * Created by lagoru on 30.08.16.
 */
public class SingleWebsiteInfoView extends RelativeLayout {

    @BindView(R.id.clockTextView)
    TextView clockTextView;
    @BindView(R.id.commodityTextView)
    TextView commodityTextView;
    @BindView(R.id.descriptionTextView)
    TextView descriptionTextView;
    @BindView(R.id.actualTextView)
    TextView actualTextView;
    @BindView(R.id.predictionTextView)
    TextView predictionTextView;
    @BindView(R.id.previousTextView)
    TextView previousTextView;

    public SingleWebsiteInfoView(Context context) {
        this(context, null);
    }

    public SingleWebsiteInfoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SingleWebsiteInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SingleWebsiteInfoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    void init(Context context) {
        View.inflate(context, R.layout.single_website_info_view_layout, this);
    }

    public void setupView(Information information) {
        clockTextView.setText(DateUtils.hourAndMinute.format(information.getDate()));
        commodityTextView.setText(information.getCommodity());
        descriptionTextView.setText(information.getDescription());
        switch (Information.Importance.getImpact(information.getWebsiteImportance())) {
            case SMALL:
                descriptionTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.informationSmallImportance));
                break;
            case MEDIUM:
                descriptionTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.informationMediumImportance));
                break;
            case BIG:
                descriptionTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.informationBigImportance));

        }
        actualTextView.setText(information.getActualValue());
        /*if (information.getActualWebsiteImpact() != null) {
            switch (information.getActualWebsiteImpact()) {
                case NEGATIVE:
                    actualTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.informationNegativeImpact));
                    break;
                case NEUTRAL:
                    actualTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.informationNeutralImpact));
                    break;
                case POSITIVE:
                    actualTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.informationPositiveImpact));
                    break;
            }
        }*/
        predictionTextView.setText(information.getPredictedValue()); //TODO nie wiem czy na stronie tego nie ma ale mi się trafilo że nie bylo
        previousTextView.setText(information.getPreviousValue());
    }
}
