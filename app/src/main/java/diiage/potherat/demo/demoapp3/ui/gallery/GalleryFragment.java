package diiage.potherat.demo.demoapp3.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import diiage.potherat.demo.demoapp3.R;
import diiage.potherat.demo.demoapp3.databinding.FragmentGalleryBinding;
import diiage.potherat.demo.demoapp3.model.sw.People;

// https://developer.android.com/topic/libraries/architecture/paging/v3-paged-data#guava-livedata

@AndroidEntryPoint
public class GalleryFragment extends Fragment {

    @Inject
    GalleryViewModel galleryViewModel;
    private QuoteAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FragmentGalleryBinding binding = FragmentGalleryBinding.inflate(inflater, container, false);

        binding.lstQuotes.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new QuoteAdapter();
        binding.lstQuotes.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        galleryViewModel =
                new ViewModelProvider(this,getDefaultViewModelProviderFactory()).get(GalleryViewModel.class);

        galleryViewModel.getQuotes().observe(getViewLifecycleOwner()
                ,quotePagingData -> adapter.submitData(getLifecycle(),quotePagingData));

        galleryViewModel.getPoeples().observe(getViewLifecycleOwner(),people -> {
            if (people != null) {
                for (People people1:people
                     ) {

                    Log.d("debug", "" + people1.name);
                }
            }
        });

    }

}