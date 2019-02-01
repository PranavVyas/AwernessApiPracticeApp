package com.example.awernessapipracticeapp.viewmodels;

import android.app.Application;

import com.example.awernessapipracticeapp.repositories.MainFragmentRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainFragmentViewModel extends AndroidViewModel {

    private MainFragmentRepository repository;
    private int currentFragment;

    public MainFragmentViewModel(@NonNull Application application) {
        super(application);
        repository = new MainFragmentRepository(application);
        currentFragment = 1;
    }

    public int getCurrentFragment() {
        return currentFragment;
    }

    public void setCurrentFragment(int currentFragment) {
        this.currentFragment = currentFragment;
    }
}
