package sprout.cycle.generator;

import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.FragmentResourceProvidersFactory;

/**
 * Created by GTW on 2015/12/14.
 */
public class CreateBaseFragmentAction extends BaseAction {

    @Override
    protected String getFileName() {
        return "BaseFragment";
    }

    @Override
    protected String getTemplateName() {
        return "Fragment_template";
    }

    @Override
    protected ResourceProvidersFactory getResourceFactory() {
        return new FragmentResourceProvidersFactory();
    }
}
