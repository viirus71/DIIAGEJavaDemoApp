package diiage.potherat.demo.demoapp3.ui.edit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import diiage.potherat.demo.demoapp3.R;
import diiage.potherat.demo.demoapp3.common.EventObserver;
import diiage.potherat.demo.demoapp3.databinding.FragmentQuoteEditBinding;

@AndroidEntryPoint
public class QuoteEditFragment extends Fragment {

    @Inject
    QuoteEditViewModel viewModel;
    private FragmentQuoteEditBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentQuoteEditBinding.inflate(inflater,container,false);


        ready();

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = new ViewModelProvider(this,getDefaultViewModelProviderFactory()).get(QuoteEditViewModel.class);



        ready();
    }

    private void ready(){
        if (binding != null && viewModel != null){

            binding.btnValid.setOnClickListener(view -> {
                viewModel.create();
            });

            viewModel.getDismiss().observe(getViewLifecycleOwner(),new EventObserver<>(data -> {
                if (data != null && data){
                    Navigation.findNavController(binding.getRoot()).navigate(R.id.action_nav_quote_edit_pop2);
                }
            }));

            binding.setViewmodel(viewModel);
        }
    }
}
