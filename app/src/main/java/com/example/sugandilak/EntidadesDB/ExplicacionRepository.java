package com.example.sugandilak.EntidadesDB;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ExplicacionRepository {
    private final LiveData<List<Explicacion>> mExplicaciones;
    private final ExplicacionDao mExplicacionDao;

    public ExplicacionRepository(Context context) {
        Database db = Database.getInstance(context);
        mExplicacionDao = db.ExplicacionDao();
        mExplicaciones = mExplicacionDao.getAll();
    }

    public LiveData<List<Explicacion>> getAllExplicaciones() {
        return mExplicaciones;
    }

    public void insert(Explicacion explicacion) {
        Database.dbExecutor.execute(
                () -> mExplicacionDao.insert(explicacion)
        );
    }


}