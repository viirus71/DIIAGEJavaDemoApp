package diiage.potherat.demo.demoapp3.ui.home;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import diiage.potherat.demo.demoapp3.common.Event;
import diiage.potherat.demo.demoapp3.dal.repository.QuoteRepository;
import diiage.potherat.demo.demoapp3.model.Quote;

public class HomeViewModel extends ViewModel {
    QuoteRepository quoteRepository;
    ExecutorService executorService;
    private LiveData<Integer> quoteCount = new MutableLiveData<>();
    private LiveData<Quote> lastCote = new MutableLiveData<>();
    private LiveData<Integer> countSource = new MutableLiveData<>();


    @Inject
    @ViewModelInject
    public HomeViewModel(ExecutorService executorService, QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
        this.executorService = executorService;
        this.quoteCount = this.quoteRepository.getCountQuote();
        this.lastCote = this.quoteRepository.getLastQuote();
        this.countSource = this.quoteRepository.getCountSource();
    }

    public LiveData<Integer> getQuoteCount() {
        return quoteCount;
    }
    public LiveData<Quote> getLastQuote() {
        return lastCote;
    }
    public LiveData<Integer> getCountSource() {
        return countSource;
    }


}