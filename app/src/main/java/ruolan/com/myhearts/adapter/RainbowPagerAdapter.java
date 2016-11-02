//package ruolan.com.myhearts.adapter;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.app.FragmentTransaction;
//import android.view.ViewGroup;
//
//
//import ruolan.com.myhearts.R;
//import ruolan.com.myhearts.ui.fragment.live.CategoryFragment;
//
///**
// * Created by Administrator on 2016/11/2.
// */
//
//public class RainbowPagerAdapter extends FragmentPagerAdapter implements ColourProvider {
//
//    private static final Rainbow[] COLOURS = {
//            Rainbow.Red, Rainbow.Orange, Rainbow.Yellow, Rainbow.Green
////            Rainbow.Blue, Rainbow.Indigo, Rainbow.Violet
//    };
//
//    private static String[] mTitle = new String[]{};
//
//    private final Context mContext;
//
//    public RainbowPagerAdapter(FragmentManager fm, Context context) {
//        super(fm);
//        mContext = context;
//        mTitle = new String[]{mContext.getResources().getString(R.string.recomment),
//                mContext.getResources().getString(R.string.dota2),
//                mContext.getResources().getString(R.string.lol),
//                mContext.getResources().getString(R.string.lushi)};
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        Rainbow color = COLOURS[position];
//        return CategoryFragment.newInstance(mContext, getPageTitle(position), color.getColour());
//    }
//
//    @Override
//    public int getColour(int position) {
//        return COLOURS[position].getColour();
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        FragmentManager manager = ((Fragment) object).getFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.remove((Fragment) object);
//        transaction.commit();
//        super.destroyItem(container, position, object);
//    }
//
//    @Override
//    public int getCount() {
//        return COLOURS.length;
//    }
//
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return mTitle[position];
//    }
//
//    /**
//     * 颜色生成器
//     */
//    private enum Rainbow {
//
//        Red(Color.rgb(0xFF, 0x00, 0x00)),
//        Orange(Color.rgb(0xFF, 0x7F, 0x00)),
//        Yellow(Color.rgb(0xCF, 0xCF, 0x00)),
//        Green(Color.rgb(0x00, 0xAF, 0x00)),
//        Blue(Color.rgb(0x00, 0x00, 0xFF)),
//        Indigo(Color.rgb(0x4B, 0x00, 0x82)),
//        Violet(Color.rgb(0x7F, 0x00, 0xFF));
//
//        private final int colour;
//
//        Rainbow(int colour) {
//            this.colour = colour;
//        }
//
//        public int getColour() {
//            return colour;
//        }
//    }
//}
