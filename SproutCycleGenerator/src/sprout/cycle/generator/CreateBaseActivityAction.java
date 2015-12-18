package sprout.cycle.generator;

import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.ActivityResourceProvidersFactory;

/**
 * Created by GTW on 2015/12/10.
 */
public class CreateBaseActivityAction extends BaseAction {

    @Override
    protected String getFileName() {
        return "BaseActivity";
    }

    @Override
    protected String getTemplateName() {
        return "Activity_template";
    }

    @Override
    protected ResourceProvidersFactory getResourceFactory() {
        return new ActivityResourceProvidersFactory();
    }
}
