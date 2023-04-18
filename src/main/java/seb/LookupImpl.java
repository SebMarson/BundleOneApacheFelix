package seb;

import felixstuff.Lookup;
import felixstuff.PluginService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileEntry;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.Map;

public class LookupImpl implements Lookup, BundleActivator {

    private BundleContext context = null;

    public LookupImpl(BundleContext context) {
        this.context = context;
    }

    private final Map<String, String> lookupMap = Map.of("key", "bundleOne",
            "seb", "dev");

    @Override
    public Object lookup(String s) {
        try {
            FileEntry fileEntry = null;
        } catch (Exception e) {
            System.out.println("Failed to create a new FileUtils from commons io library");
        }
        String serviceReferenceString = "";
        ServiceReference<PluginService> serviceReference = context.getServiceReference(PluginService.class);
        if (serviceReference != null) {
            PluginService pluginService = context.getService(serviceReference);

            serviceReferenceString = pluginService.getContent();
        }
        return lookupMap.get(s) + "-" + serviceReferenceString;
    }

    @Override
    public void start(BundleContext context) throws Exception {
        this.context = context;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        this.context = context;
    }
}
