package EntidadesDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class JuegoViewModel extends AndroidViewModel {

    private final JuegoRepository mRepository;

    private final LiveData<List<Juego>> mJuegos;

    public JuegoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new JuegoRepository(application);
        mJuegos = mRepository.getAllJuegos();
    }



    public LiveData<List<Juego>> getJuegos() {
        return mJuegos;
    }

    public void insert(Juego juego) {
        mRepository.insert(juego);
    }

}
