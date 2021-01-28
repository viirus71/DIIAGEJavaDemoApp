package diiage.potherat.demo.demoapp3.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import diiage.potherat.demo.demoapp3.R;
import diiage.potherat.demo.demoapp3.databinding.FragmentHomeBinding;
import diiage.potherat.demo.demoapp3.databinding.FragmentQuoteEditBinding;
import diiage.potherat.demo.demoapp3.ui.edit.QuoteEditViewModel;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    @Inject
    HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    TextView textViewCount;
    TextView textDistinctSources;
     TextView txtQuote;
     TextView txtSource;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        textViewCount = binding.getRoot().findViewById(R.id.txtNumberOfQuotes);
        textDistinctSources = binding.getRoot().findViewById(R.id.txtDistinctSources);

        txtQuote =  binding.getRoot().findViewById(R.id.txtQuote);
        txtSource = binding.getRoot().findViewById(R.id.txtSource);

        ready();
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homeViewModel = new ViewModelProvider(this,getDefaultViewModelProviderFactory()).get(HomeViewModel.class);
        ready();
    }

    private void ready(){
        if (binding != null && homeViewModel != null){
            binding.setLifecycleOwner(this);
            homeViewModel.getQuoteCount().observe(getViewLifecycleOwner(), integer -> {
                textViewCount.setText(integer.toString());
            });
            homeViewModel.getCountSource().observe(getViewLifecycleOwner(), integer -> {
                textDistinctSources.setText(integer.toString());
            });
            homeViewModel.getLastQuote().observe(getViewLifecycleOwner(), quote -> {
                if(quote != null) {
                    txtQuote.setText(quote.getQuote());
                    txtSource.setText(quote.getSource());
                }
            });

            binding.setViewmodel(homeViewModel);
        }
    }
}