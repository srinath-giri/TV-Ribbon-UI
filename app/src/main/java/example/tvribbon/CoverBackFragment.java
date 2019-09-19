package example.tvribbon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by srinathgiri on 8/23/15.
 */
public class CoverBackFragment extends Fragment {

    private static final String DRAWABLE_ID = "drawable_id";
    private ImageView coverBackImage;
    private int drawableId;

    public static CoverBackFragment newInstance(int drawableId) {
        CoverBackFragment coverFrontFragment = new CoverBackFragment();
        Bundle args = new Bundle();
        args.putInt(DRAWABLE_ID, drawableId);
        coverFrontFragment.setArguments(args);
        return coverFrontFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawableId = getArguments() != null ? getArguments().getInt(DRAWABLE_ID) : -1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup coverBack = (ViewGroup) inflater.inflate(R.layout.cover_back_fragment, container, false);
        coverBackImage = (ImageView) coverBack.findViewById(R.id.cover_back);
//        coverBackImage.setImageResource(drawableId);
        return coverBack;
    }
}
