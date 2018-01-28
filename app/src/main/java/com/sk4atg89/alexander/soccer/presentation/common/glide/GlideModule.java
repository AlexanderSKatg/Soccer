package com.sk4atg89.alexander.soccer.presentation.common.glide;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.module.AppGlideModule;
import com.caverock.androidsvg.SVG;

import java.io.InputStream;

@com.bumptech.glide.annotation.GlideModule(glideName = "GlideSoccer")
public class GlideModule extends AppGlideModule {

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        registry.register(SVG.class, PictureDrawable.class, new SvgDrawableTranscoder())
                .append(InputStream.class, SVG.class, new SvgDecoder());
    }

    // Disable manifest parsing to avoid adding similar modules twice.
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }

}

//        GlideRequests glideRequests = GlideSoccer.with(view);
//        glideRequests.clear(view);
//        GlideSoccer.get(view.getContext()).clearMemory();
//        File cacheDir = Preconditions.checkNotNull(Glide.getPhotoCacheDir(view.getContext()));
//        if (cacheDir.isDirectory()) {
//            for (File child : cacheDir.listFiles()) {
//                if (!child.delete()) {
//                    Log.w("BindingAdapter", "cannot delete: " + child);
//                }
//            }
//        }