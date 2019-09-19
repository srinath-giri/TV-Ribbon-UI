package example.tvribbon;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

/**
 * Created by srinathgiri on 8/17/15.
 */
public class MediaFragment extends Fragment implements View.OnClickListener {

    private static final String POSITION = "position";
    private static final String DRAWABLE_ID = "drawable_id";
    private static final String STARRED = "starred";

    private int position;
    private int drawableId;
    private boolean starred;
    private boolean flipped = false;

    private ViewGroup coverFlipper;
    private ToggleButton starredButton;


    public static MediaFragment newInstance(int position, int drawableId) {
        MediaFragment mediaFragment = new MediaFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        args.putInt(DRAWABLE_ID, drawableId);
        args.putBoolean(STARRED, false);
        mediaFragment.setArguments(args);
        return mediaFragment;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        position = getArguments() != null ? getArguments().getInt(POSITION) : -1;
        drawableId = getArguments() != null ? getArguments().getInt(DRAWABLE_ID) : -1;
        starred = getArguments() != null ? getArguments().getBoolean(STARRED) : false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        ViewGroup media = (ViewGroup) inflater.inflate(R.layout.media_fragment, container, false);
        coverFlipper = (ViewGroup) media.findViewById(R.id.cover_flipper);
        coverFlipper.setOnClickListener(this);

        starredButton = (ToggleButton) media.findViewById(R.id.favorited);
        starredButton.setChecked(starred);
        starredButton.setOnClickListener(this);
        return media;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.cover_flipper, (!flipped) ? CoverFrontFragment.newInstance(drawableId) : CoverBackFragment.newInstance(drawableId))
                .commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle args = getArguments();
        args.putInt(POSITION, position);
        args.putInt(DRAWABLE_ID, drawableId);
        args.putBoolean(STARRED, starred);
    }

    @Override
    public void onClick(View view) {
        if(view == starredButton) {
            starred = starredButton.isChecked();
        }
        else if(view == coverFlipper) {
            flipped = !flipped;
            getChildFragmentManager()
                    .beginTransaction()
                    //.setCustomAnimations(R.animator.book_flip_in, R.animator.book_flip_out)
                    .replace(R.id.cover_flipper, (!flipped) ? CoverFrontFragment.newInstance(drawableId) : CoverBackFragment.newInstance(drawableId))
                    .commit();
        }
    }
}