package seb;

import felixstuff.Lookup;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileEntry;

import java.util.Map;

public class LookupImpl implements Lookup {

    private final Map<String, String> lookupMap = Map.of("key", "bundleOne",
            "seb", "dev");

    @Override
    public Object lookup(String s) {
        try {
            FileEntry fileEntry = null;
        } catch (Exception e) {
            System.out.println("Failed to create a new FileUtils from commons io library");
        }
        return lookupMap.get(s);
    }
}
