package com.caihong.javathinking.myinterface;

public class FilterAdapter implements Processor {
    // 持有被适配的对象
    private Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public WaveForm process(Object input) {
        return filter.process((WaveForm) input);
    }
}
