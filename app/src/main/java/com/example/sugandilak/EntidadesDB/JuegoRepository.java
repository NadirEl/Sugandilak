package com.example.sugandilak.EntidadesDB;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class JuegoRepository {
    private final LiveData<List<Juego>> mJuegos;
    private final JuegoDao mJuegoDao;

    public JuegoRepository(Context context) {
        JuegoDatabase db = JuegoDatabase.getInstance(context);
        mJuegoDao = db.JuegoDao();
        mJuegos = mJuegoDao.getAll();
    }

    public LiveData<List<Juego>> getAllJuegos() {
        return mJuegos;
    }

    public void insert(Juego juego) {
        JuegoDatabase.dbExecutor.execute(
                () -> mJuegoDao.insert(juego)
        );
    }


}