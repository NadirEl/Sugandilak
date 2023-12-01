package com.example.sugandilak.EntidadesDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ExplicacionViewModel extends AndroidViewModel {

    private final ExplicacionRepository mRepository;

    private final LiveData<List<Explicacion>> mExplicaciones;

    public ExplicacionViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ExplicacionRepository(application);
        mExplicaciones = mRepository.getAllExplicaciones();
    }



    public LiveData<List<Explicacion>> getJuegos() {
        return mExplicaciones;
    }

    public void insert(Explicacion explicacion) {
        mRepository.insert(explicacion);
    }

}
