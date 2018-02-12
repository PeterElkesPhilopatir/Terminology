package com.example.peter.terminology;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.CollapsibleActionView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class CreditFragment extends Fragment {

    View rootView;
    String credit;

    public CreditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_credit, container, false);
        credit = "Mario Zakaria" + "\n" +
                "Mohamed Amr" + "\n" +
                "Mohamed Hisham" + "\n" +
                "Ramez George" + "\n" +
                "Omar Shamroukh" + "\n" +
                "Omar Mashhour";
        final TextView textView = (TextView) rootView.findViewById(R.id.creditTextview);
        textView.setVisibility(View.INVISIBLE);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.groupImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(credit);
                textView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.INVISIBLE);
            }
        });
        return rootView;
    }

    @Override
    public void onDestroy() {

        Toast.makeText(getContext(), "Thanks", Toast.LENGTH_SHORT).show();
        super.onDestroy();

    }

    private void fadeOutAndHideImage(final ImageView img, final TextView text) {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000);

        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                img.setVisibility(View.GONE);
//                text.setVisibility(View.);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });

        img.startAnimation(fadeOut);
    }

}
