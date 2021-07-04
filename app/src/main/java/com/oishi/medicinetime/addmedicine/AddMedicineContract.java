package com.oishi.medicinetime.addmedicine;

import com.oishi.medicinetime.BasePresenter;
import com.oishi.medicinetime.BaseVieww;
import com.oishi.medicinetime.data.source.MedicineAlarm;
import com.oishi.medicinetime.data.source.Pills;

import java.util.List;



public interface AddMedicineContract {

    interface Vieww extends BaseVieww<Presenter> {

        void showEmptyMedicineError();

        void showMedicineList();

        boolean isActive();

    }

    interface  Presenter extends BasePresenter{


        void saveMedicine(MedicineAlarm alarm, Pills pills);


        boolean isDataMissing();

        boolean isMedicineExits(String pillName);

        long addPills(Pills pills);

        Pills getPillsByName(String pillName);

        List<MedicineAlarm> getMedicineByPillName(String pillName);

        List<Long> tempIds();

        void deleteMedicineAlarm(long alarmId);

    }
}
