package diiage.potherat.demo.demoapp3.ui.vehicule;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import diiage.potherat.demo.demoapp3.R;
import diiage.potherat.demo.demoapp3.databinding.FragmentHomeBinding;
import diiage.potherat.demo.demoapp3.databinding.VehiculeFragmentBinding;
import diiage.potherat.demo.demoapp3.ui.home.HomeViewModel;

@AndroidEntryPoint
public class VehiculeFragment extends Fragment {

    @Inject
    VehiculeViewModel vehiculeViewModel ;
    private VehiculeFragmentBinding binding;
    TextView txtName;
    TextView txtModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = VehiculeFragmentBinding.inflate(inflater,container,false);
        txtName =  binding.getRoot().findViewById(R.id.txtName);
        txtModel = binding.getRoot().findViewById(R.id.txtModel);

        ready();
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vehiculeViewModel = new ViewModelProvider(this,getDefaultViewModelProviderFactory()).get(VehiculeViewModel.class);
        ready();
    }

    private void ready(){
        if (binding != null && vehiculeViewModel != null){
            binding.setLifecycleOwner(this);
            vehiculeViewModel.getVehicle().observe(getViewLifecycleOwner(), vehicle -> {
                txtName.setText(vehicle.name);
                txtModel.setText(vehicle.model);
            });
            binding.setViewmodel(vehiculeViewModel);
        }
    }

}