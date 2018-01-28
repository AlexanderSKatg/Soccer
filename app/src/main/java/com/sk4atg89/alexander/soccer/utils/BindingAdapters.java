package com.sk4atg89.alexander.soccer.utils;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestBuilder;
import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.presentation.common.glide.GlideSoccer;
import com.sk4atg89.alexander.soccer.presentation.common.glide.SvgSoftwareLayerSetter;

import io.reactivex.functions.Action;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class BindingAdapters {

    @BindingConversion
    public static View.OnClickListener toOnClickListener(final Action listener) {
        if (listener != null) {
            return view -> {
                try {
                    listener.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        } else {
            return null;
        }
    }

    @BindingAdapter(value = {"bind:eventTime", "bind:formatText"})
    public static void bindTextDate(TextView view, long eventTime, String formatText) {
        view.setText(String.format(formatText, SoccerTimeUtil.toRelative(eventTime)));
    }

    @BindingAdapter({"bind:image"})
    public static void bindImage(ImageView view, String url) {
        if (url == null) return;
        if (!url.endsWith("svg")) {
            GlideSoccer.with(view)
                    .load(url)
                    .placeholder(R.mipmap.place_holder)
                    .fitCenter()
                    .into(view);
            return;
        }

        RequestBuilder<PictureDrawable> requestBuilder;
        requestBuilder = GlideSoccer.with(view)
                .as(PictureDrawable.class)
                .error(R.mipmap.place_holder)
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());

        Uri uri = Uri.parse(url);
        requestBuilder.load(uri).into(view);
    }

    @BindingAdapter(value = {"bind:value", "bind:formatText"})
    public static void bindText(TextView view, String value, String formatText) {
        view.setText(String.format(formatText, value));
    }

    @BindingAdapter(value = {"bind:position"})
    public static void bindBackground(TextView view, int position) {
        view.setBackground(ContextCompat.getDrawable(view.getContext(),
                position % 2 == 1 ? R.drawable.background_table_item_black : R.drawable.background_table_item_dark_gray));
    }

}
