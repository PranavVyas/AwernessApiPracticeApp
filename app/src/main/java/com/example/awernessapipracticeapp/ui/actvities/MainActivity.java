package com.example.awernessapipracticeapp.ui.actvities;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.awernessapipracticeapp.R;
import com.example.awernessapipracticeapp.ui.fragments.MainFragment;
import com.example.awernessapipracticeapp.utils.NavigationUtils;
import com.example.awernessapipracticeapp.viewmodels.MainFragmentViewModel;
import com.mikepenz.materialdrawer.Drawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationUtils.OnNavigationItemClickListener {

    @BindView(R.id.frame_main_fragment_holder)
    FrameLayout frameHolder;
    @BindView(R.id.toolbar_main)
    Toolbar toolbar;

    private MainFragmentViewModel viewModel;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpViewModel();
        drawer = NavigationUtils.getDrawer(this, toolbar);
        executeActivity(viewModel.getCurrentFragment());
    }

    private void setUpViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainFragmentViewModel.class);
    }

    private void executeActivity(int ID) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (ID) {
            case 1:
                MainFragment mainFragment = new MainFragment();
                fragmentTransaction.replace(R.id.frame_main_fragment_holder, mainFragment)
                        .commit();
                viewModel.setCurrentFragment(ID);
                break;
        }
    }


    @Override
    public void OnNavigationItemClicked(int ID) {
        executeActivity(viewModel.getCurrentFragment());
    }
}
