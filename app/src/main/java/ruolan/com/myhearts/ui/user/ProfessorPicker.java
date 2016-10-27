package ruolan.com.myhearts.ui.user;

import android.app.Activity;

import cn.qqtheme.framework.picker.OptionPicker;

/**
 * Created by Administrator on 2016/10/27.
 */

public class ProfessorPicker extends OptionPicker {
    /**
     * Instantiates a new Constellation picker.
     *
     * @param activity the activity
     */
    public ProfessorPicker(Activity activity) {
        super(activity, new String[]{
                "A",
                "B",
                "AB",
                "0",
                "UnKnow"
        });
        setLabel("UnKnow");
    }


}
