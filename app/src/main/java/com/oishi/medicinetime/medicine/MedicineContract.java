package com.oishi.medicinetime.medicine;

import android.content.Context;

import com.oishi.medicinetime.BasePresenter;
import com.oishi.medicinetime.BaseVieww;
import com.oishi.medicinetime.data.source.MedicineAlarm;

import java.util.List;

/**
 * Created by gautam on 13/07/17.
 */

public interface MedicineContract {

    interface Vieww extends BaseVieww<Presenter> {

        void showLoadingIndicator(boolean active);

        void showMedicineList(List<MedicineAlarm> medicineAlarmList);

        void showAddMedicine();

        void showMedicineDetails(long medId, String medName);

        void showLoadingMedicineError();

        void showNoMedicine();

        void showSuccessfullySavedMessage();

        void  showMedicineDeletedSuccessfully();

        boolean isActive();


    }

    interface Presenter extends BasePresenter{

        void onStart(int day);

        void reload(int day);

        void result(int requestCode, int resultCode);

        void loadMedicinesByDay(int day, boolean showIndicator);

        void deleteMedicineAlarm(MedicineAlarm medicineAlarm, Context context);

        void addNewMedicine();

    }
}
