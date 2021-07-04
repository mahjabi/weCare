package com.oishi.medicinetime.addmedicine;

import androidx.annotation.NonNull;

import com.oishi.medicinetime.data.source.MedicineAlarm;
import com.oishi.medicinetime.data.source.MedicineDataSource;
import com.oishi.medicinetime.data.source.Pills;

import java.util.List;

public class AddMedicinePresenter implements AddMedicineContract.Presenter, MedicineDataSource.GetTaskCallback {

    @NonNull
    private final MedicineDataSource mMedicineRepository;

    private final AddMedicineContract.Vieww mAddMedicineView;

    private int mMedicineId;

    private boolean mIsDataMissing;

    public AddMedicinePresenter(int mMedicineId, @NonNull MedicineDataSource mMedicineRepository, AddMedicineContract.Vieww mAddMedicineView, boolean mIsDataMissing) {
        this.mMedicineId = mMedicineId;
        this.mMedicineRepository = mMedicineRepository;
        this.mAddMedicineView = mAddMedicineView;
        this.mIsDataMissing = mIsDataMissing;

        mAddMedicineView.setPresenter(this);
    }

    private boolean isNewTask() {
        return mMedicineId <= 0;
    }

    @Override
    public void start() {

    }

    @Override
    public void saveMedicine(MedicineAlarm alarm, Pills pills) {
        mMedicineRepository.saveMedicine(alarm, pills);
    }

    @Override
    public boolean isDataMissing() {
        return mIsDataMissing;
    }

    @Override
    public boolean isMedicineExits(String pillName) {
        return mMedicineRepository.medicineExits(pillName);
    }

    @Override
    public long addPills(Pills pills) {
        return mMedicineRepository.savePills(pills);
    }

    @Override
    public Pills getPillsByName(String pillName) {
        return mMedicineRepository.getPillsByName(pillName);
    }

    @Override
    public List<MedicineAlarm> getMedicineByPillName(String pillName) {
        return mMedicineRepository.getMedicineByPillName(pillName);
    }

    @Override
    public List<Long> tempIds() {
        return mMedicineRepository.tempIds();
    }

    @Override
    public void deleteMedicineAlarm(long alarmId) {
        mMedicineRepository.deleteAlarm(alarmId);
    }

    @Override
    public void onTaskLoaded(MedicineAlarm medicineAlarm) {

    }

    @Override
    public void onDataNotAvailable() {
        if (mAddMedicineView.isActive()) {
            mAddMedicineView.showEmptyMedicineError();
        }
    }
}
