package com.faceunity.app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.faceunity.app.R;
import com.faceunity.app.base.BaseFaceUnityActivity;
import com.faceunity.app.data.FineStickerDataFactory;
import com.faceunity.app.entity.FunctionEnum;
import com.faceunity.core.enumeration.FUAIProcessorEnum;
import com.faceunity.ui.control.FineStickerView;

import java.util.Arrays;

public class FineStickerActivity extends BaseFaceUnityActivity {

    private FineStickerView fineStickerView;
    private FineStickerDataFactory fineStickerDataFactory;

    @Override
    protected int getStubBottomLayoutResID() {
        return R.layout.layout_control_fine_sticker;
    }

    @Override
    public void initData() {
        super.initData();
        fineStickerDataFactory = new FineStickerDataFactory();
    }

    @Override
    protected void configureFURenderKit() {
        super.configureFURenderKit();
        fineStickerDataFactory.bindCurrentRenderer();
    }

    @Override
    public void initView() {
        super.initView();
        fineStickerView = (FineStickerView) mStubView;
        changeTakePicButtonMargin(getResources().getDimensionPixelSize(R.dimen.x462), getResources().getDimensionPixelSize(R.dimen.x166));
    }

    @Override
    public void bindListener() {
        super.bindListener();
        fineStickerView.bindDataFactory(fineStickerDataFactory);
        fineStickerDataFactory.bindView(fineStickerView);
        fineStickerView.setOnBottomAnimatorChangeListener(showRate -> {
            // 收起 1-->0，弹出 0-->1
            updateTakePicButton(getResources().getDimensionPixelSize(R.dimen.x166), showRate,
                    getResources().getDimensionPixelSize(R.dimen.x156), getResources().getDimensionPixelSize(R.dimen.x364), true);
        });
    }

    @Override
    protected int getFunctionType() {
        return FunctionEnum.FINE_STICKER;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        fineStickerView.hideControlView();
        fineStickerDataFactory.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public void onResume() {
        super.onResume();
        fineStickerDataFactory.acceptEvent();
    }

    @Override
    public void onPause() {
        super.onPause();
        fineStickerDataFactory.refuseEvent();
    }

    @Override
    public void onDestroy() {
        fineStickerDataFactory.releaseAIProcessor();
        super.onDestroy();
    }
}