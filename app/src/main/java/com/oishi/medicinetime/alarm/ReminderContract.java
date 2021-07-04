package com.oishi.medicinetime.alarm;

import com.oishi.medicinetime.BasePresenter;
import com.oishi.medicinetime.BaseVieww;
import com.oishi.medicinetime.data.source.History;
import com.oishi.medicinetime.data.source.MedicineAlarm;

public interface ReminderContract {

    interface Vieww extends BaseVieww<Presenter> {

        void showMedicine(MedicineAlarm medicineAlarm);

        void showNoData();

        boolean isActive();

        void onFinish();

    }

    interface Presenter extends BasePresenter {

        void finishActivity();

        void onStart(long id);

        void loadMedicineById(long id);

        void addPillsToHistory(History history);

    }
}
