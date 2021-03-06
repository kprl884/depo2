package com.example.lastversion;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.lastversion.databinding.FragmentDetailsBinding;
import com.example.lastversion.models.ProjectsModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class
DetailsFragment extends BaseFragment {

    public static String TAG = DetailsFragment.class.getSimpleName();

    private FragmentDetailsBinding binding;
    private ProjectsModel projectsModel;

    public static DetailsFragment newInstance(ProjectsModel project) {

        Bundle args = new Bundle();

        args.putParcelable("ProjectsInfo", project);

        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false);
            Bundle bundle = getArguments();
            if (bundle != null) {
                projectsModel = bundle.getParcelable("ProjectsInfo");
                binding.setDataDetail(projectsModel);
            }
        }
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        setToolbarVisibility();
    }

    private void setToolbarVisibility() {
        String titleProject = projectsModel.getTitle();
        if (titleProject != null) {
            setToolbarVisibility(titleProject, View.VISIBLE);
        }
    }
}
