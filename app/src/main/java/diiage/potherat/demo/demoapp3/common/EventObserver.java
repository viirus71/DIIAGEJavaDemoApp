package diiage.potherat.demo.demoapp3.common;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

public class EventObserver<T> implements Observer<Event<T>> {
    private final OnEventChanged<T> onEventChanged;

    public EventObserver(OnEventChanged<T> onEventChanged) {
        this.onEventChanged = onEventChanged;
    }

    @Override
    public void onChanged(@Nullable Event<T> tEvent) {
        if (tEvent != null && onEventChanged != null) {
            T content = tEvent.getContentIfNotHandled();
            if (content != null) {
                onEventChanged.onUnhandledContent(content);
            }
        }
    }

    public interface OnEventChanged<T> {
        void onUnhandledContent(T data);
    }
}
