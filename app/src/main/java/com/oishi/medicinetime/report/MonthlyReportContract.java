package com.oishi.medicinetime.report;

import com.oishi.medicinetime.BasePresenter;
import com.oishi.medicinetime.BaseVieww;
import com.oishi.medicinetime.data.source.History;
import java.util.List;



public interface MonthlyReportContract {

    interface Vieww extends BaseVieww<Presenter> {

        void setLoadingIndicator(boolean active);

        void showHistoryList(List<History> historyList);

        void showLoadingError();

        void showNoHistory();

        void showTakenFilterLabel();

        void showIgnoredFilterLabel();

        void showAllFilterLabel();

        void showNoTakenHistory();

        void showNoIgnoredHistory();

        boolean isActive();

        void showFilteringPopUpMenu();

    }

    interface Presenter extends BasePresenter {

        void loadHistory(boolean showLoading);

        void setFiltering(FilterType filterType);

        FilterType getFilterType();
    }
}
