package example.tvribbon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by srinathgiri on 8/17/15.
 */
public class MediaPagerAdapter extends FragmentStatePagerAdapter {

    private final int[] mediaID = new int[]{R.drawable.book1,R.drawable.book2,R.drawable.book3,R.drawable.book4};

    public MediaPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        Log.d(MainActivity.RIBBON, "getItem:" + String.valueOf(position));
        return (android.support.v4.app.Fragment) MediaFragment.newInstance(position, mediaID[position]);
    }

    @Override
    public int getCount() {
        return mediaID.length;
    }


}
