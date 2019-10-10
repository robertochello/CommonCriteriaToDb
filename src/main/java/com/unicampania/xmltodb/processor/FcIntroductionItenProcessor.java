package com.unicampania.xmltodb.processor;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.ItemProcessor;

public class FcIntroductionItenProcessor implements ItemProcessor<Fclass, Fclass> {

    @Override
    public Fclass process(Fclass fClass) throws Exception {

        return fClass;

    }


}