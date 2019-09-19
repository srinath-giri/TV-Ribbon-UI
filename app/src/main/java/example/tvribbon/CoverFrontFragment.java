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
public class CoverFrontFragment extends Fragment {

    private static final String DRAWABLE_ID = "drawable_id";
    private ImageView coverFrontImage;
    private int drawableId;

    public static CoverFrontFragment newInstance(int drawableId) {
        CoverFrontFragment coverFrontFragment = new CoverFrontFragment();
        Bundle args = new Bundle();
        args.putInt(DRAWABLE_ID,drawableId);
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
        ViewGroup coverFront = (ViewGroup) inflater.inflate(R.layout.cover_front_fragment, container, false);
        coverFrontImage = (ImageView) coverFront.findViewById(R.id.cover_front);
        coverFrontImage.setImageResource(drawableId);
        return coverFront;
    }
}
