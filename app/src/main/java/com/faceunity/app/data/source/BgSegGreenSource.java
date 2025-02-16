package com.faceunity.app.data.source;

import com.faceunity.app.DemoConfig;
import com.faceunity.app.R;
import com.faceunity.core.controller.bgSegGreen.BgSegGreenParam;
import com.faceunity.core.entity.FUBundleData;
import com.faceunity.core.model.bgSegGreen.BgSegGreen;
import com.faceunity.ui.entity.BgSegGreenBackgroundBean;
import com.faceunity.ui.entity.BgSegGreenBean;
import com.faceunity.ui.entity.ModelAttributeData;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * DESC：绿幕抠像数据构造
 * Created on 2021/3/25
 */
public class BgSegGreenSource {


    private static double SIMILARITY = 0.45;//相似度
    private static double SMOOTHNESS = 0.3;//平滑度
    private static double TRANSPARENCY = 0.2;//透明度

    /**
     * 构造绿幕抠像对象
     * @return
     */
    public static BgSegGreen buildBgSegGreen() {
        BgSegGreen bgSegGreen = new BgSegGreen(new FUBundleData(DemoConfig.BUNDLE_BG_SEG_GREEN));
        bgSegGreen.setSimilarity(BgSegGreenSource.SIMILARITY);
        bgSegGreen.setSmoothness(BgSegGreenSource.SMOOTHNESS);
        bgSegGreen.setTransparency(BgSegGreenSource.TRANSPARENCY);
        return bgSegGreen;
    }

    /**
     * 获取模型属性扩展数据
     *
     * @return HashMap<String, ModelAttributeData>
     */
    public static HashMap<String, ModelAttributeData> buildModelAttributeRange() {
        HashMap<String, ModelAttributeData> params = new HashMap<String, ModelAttributeData>();
        params.put(BgSegGreenParam.SIMILARITY, new ModelAttributeData(SIMILARITY, 0.0, 0.0, 1.0));
        params.put(BgSegGreenParam.SMOOTHNESS, new ModelAttributeData(SMOOTHNESS, 0.0, 0.0, 1.0));
        params.put(BgSegGreenParam.TRANSPARENCY, new ModelAttributeData(TRANSPARENCY, 0.0, 0.0, 1.0));
        return params;
    }

    /**
     * 绿幕抠像功能列表
     *
     * @return
     */
    public static ArrayList<BgSegGreenBean> buildBgSegGreenAction() {
        ArrayList<BgSegGreenBean> actions = new ArrayList<BgSegGreenBean>();
        actions.add(new BgSegGreenBean(BgSegGreenParam.RGB_COLOR, R.string.bg_seg_green_key_color, R.drawable.icon_green_color_selector, R.drawable.icon_green_color_selector, 0));
        actions.add(new BgSegGreenBean(BgSegGreenParam.SIMILARITY, R.string.bg_seg_green_similarity, R.drawable.icon_green_similarityr_close_selector, R.drawable.icon_green_similarityr_open_selector, 1));
        actions.add(new BgSegGreenBean(BgSegGreenParam.SMOOTHNESS, R.string.bg_seg_green_smooth, R.drawable.icon_green_smooth_close_selector, R.drawable.icon_green_similarityr_open_selector, 1));
        actions.add(new BgSegGreenBean(BgSegGreenParam.TRANSPARENCY, R.string.bg_seg_green_alpha, R.drawable.icon_green_transparency_close_selector, R.drawable.icon_green_transparency_open_selector, 1));
        return actions;
    }

    /**
     * 绿幕抠像背景列表
     *
     * @return
     */
    public static ArrayList<BgSegGreenBackgroundBean> buildBgSegGreenBackground() {
        ArrayList<BgSegGreenBackgroundBean> backgroundBeans = new ArrayList<>();
        String fileDir = "bg_seg_green" + File.separator + "sample" + File.separator;
        backgroundBeans.add(new BgSegGreenBackgroundBean(R.string.cancel, R.mipmap.icon_control_none, null));
        backgroundBeans.add(new BgSegGreenBackgroundBean(R.string.bg_seg_green_science, R.mipmap.icon_green_science, fileDir + "science.mp4"));
        backgroundBeans.add(new BgSegGreenBackgroundBean(R.string.bg_seg_green_beach, R.mipmap.icon_green_bg_beach, fileDir + "beach.mp4"));
        backgroundBeans.add(new BgSegGreenBackgroundBean(R.string.bg_seg_green_classroom, R.mipmap.icon_green_bg_classroom, fileDir + "classroom.mp4"));
        backgroundBeans.add(new BgSegGreenBackgroundBean(R.string.bg_seg_green_ink, R.mipmap.icon_green_ink_painting, fileDir + "ink_painting.mp4"));
        backgroundBeans.add(new BgSegGreenBackgroundBean(R.string.bg_seg_green_forest, R.mipmap.icon_green_bg_forest, fileDir + "forest.mp4"));
        return backgroundBeans;
    }


}
