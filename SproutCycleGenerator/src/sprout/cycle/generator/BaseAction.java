package sprout.cycle.generator;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.morcinek.android.codegenerator.codegeneration.TemplateCodeGenerator;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import sprout.cycle.generator.dialog.DialogsFactory;
import sprout.cycle.generator.setting.Settings;
import sprout.cycle.generator.setting.TemplateSettings;
import sprout.cycle.generator.util.PackageHelper;
import sprout.cycle.generator.util.PathHelper;
import sprout.cycle.generator.util.ProjectHelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by GTW on 2015/12/14.
 */
public abstract class BaseAction extends AnAction {
    private final ProjectHelper projectHelper = new ProjectHelper();
    private final PathHelper pathHelper = new PathHelper();
    private final PackageHelper packageHelper = new PackageHelper();
    private Project project;
    private PsiFile psi;
    Settings settings;
    AnActionEvent event;

    @Override
    public void actionPerformed(AnActionEvent e) {
        Application application = ApplicationManager.getApplication();
        project = getEventProject(e);
        psi = e.getData(LangDataKeys.PSI_FILE);
        settings = Settings.getInstance(project);
        event = e;

        application.runWriteAction(new Runnable() {
            @Override
            public void run() {
                main();
            }
        });
    }

    private void main() {
        String fileType = ".java";
        String fileName = getFileName() + fileType;
        String path = getFolderPath();


        try {
            if (!projectHelper.fileExists(project, fileName, path)) {
                generateFile(path, fileName);
            } else {
                if (DialogsFactory.openOverrideFileDialog(project, path, fileName)) {
                    generateFile(path, fileName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void generateFile(String path, String fileName) throws IOException {
        //create base file
        VirtualFile createdFile = projectHelper.createOrFindFile(project, fileName, path);

        //generate code
        TemplateCodeGenerator generator = new TemplateCodeGenerator(getTemplateName(), getResourceFactory(), TemplateSettings.getInstance());
        String generatedCode = "package " + getPackageName() + ";\n\n";
        generatedCode += generator.generateCode(new ArrayList<Resource>(), fileName.replace(".java", ""));


        //set file content
        projectHelper.setFileContent(project, createdFile, generatedCode);

        VirtualFile vf = LocalFileSystem.getInstance().findFileByIoFile(new File(path));
        vf.refresh(true, false);
    }

    private String getFolderPath() {
        String sourcePath = "/app/src/main/java";
        String packageName = packageHelper.getPackageName(project, event) + ".base";
        return pathHelper.getFolderPath(sourcePath, packageName);
    }

    private String getPackageName() {
        return packageHelper.getPackageName(project, event) + ".base";
    }

    private void log(String msg) {
        System.out.println(msg);
    }

    protected abstract String getFileName();

    protected abstract String getTemplateName();

    protected abstract ResourceProvidersFactory getResourceFactory();
}
