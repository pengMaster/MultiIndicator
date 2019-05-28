package com.example.multiindicator.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.multiindicator.R;

/**
 * <pre>
 *     author : Wp
 *     e-mail : 1101313414@qq.com
 *     time   : 2019/5/28 4:22 PM
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class TestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_test,null);
    }
}
