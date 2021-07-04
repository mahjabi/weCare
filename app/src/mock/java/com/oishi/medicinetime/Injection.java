package com.oishi.medicinetime;

import android.content.Context;
import androidx.annotation.NonNull;

import com.oishi.medicinetime.data.source.MedicineRepository;
import com.oishi.medicinetime.data.source.local.MedicinesLocalDataSource;


public class Injection {

    public static MedicineRepository provideMedicineRepository(@NonNull Context context) {
        return MedicineRepository.getInstance(MedicinesLocalDataSource.getInstance(context));
    }
}
