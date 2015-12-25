# SproutCycleGenerator

@(Android)

![alt_text](http://www.25sprout.com/images/logo_max.png)

An inteliJ Plugin about creating [SproutCycle](https://25sprout.gitbooks.io/25sprout-appdept-devbook/content/sproutcycle.html) base class. (It can install on Android Studio,too)

這是一個專門建立 SproutCycle 所需 BaseClass 的 inteliJ 套件（也可以使用在 Android Studio 上）。


### Source Code Dependency
本套件的程式碼部分來源使用以下 Repository：
> 1. [android-codegenerator-library](https://github.com/tmorcinek/android-codegenerator-library)
> 2. [android-codegenerator-plugin-intellij](https://github.com/tmorcinek/android-codegenerator-plugin-intellij)


### How to Use Plugin
1. 加入 SproutCycle Library，有兩種方法：
  * 在 build.gradle 加上 SproutCycle Library
  * 加上[此文](https://25sprout.gitbooks.io/25sprout-appdept-devbook/content/sproutcycle.html)中的`SproutActivityCycle` 與 `SproutFragmentCycle` Interface 檔案

2. 安裝 Plugin，先下載 [SproutCycleGenerator.zip](https://github.com/25sprout/SproutCycleGenerator/raw/master/SproutCycleGenerator/SproutCycleGenerator.zip) 檔案 （不需要解壓縮）
在「Settings」 > 「Plugins」的面板中選擇「`Install plugin from disk...`」，檔案選擇剛剛下載的 zip 檔案

  ![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450935487315.png)

<br>
3. 安裝成功就會在`Menu`與`Toolbar`上出現可愛的小新芽啦！

  ![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450936210868.png)

<br>

4. 點下 Create 就會在 Package 中產生 base 資料夾與相關 Class


-----
 <br>
### "How To Make A Plugin" Tutorial

這段落是撰寫關於開發這個 Plugin 一點點的心得與教學，雖然有大部分 Code 都是來自於前述兩個 Project

>官方開發文件：[IntelliJ Platform SDK DevGuide](http://www.jetbrains.org/intellij/sdk/docs/index.html)

####a. Build Environment
<br>
1. **需要先下載 [inteliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows) (Community 或 Ultimate 都可以)**
  IntelliJ IDEA CE source code 可以不必要下載，Source Code 是拿來特別 debug 用

<br>
2. **建立 Plugin Project**
  Project SDK 請選擇你的 IDEA 安裝路徑： `JetBrains\IntelliJ IDEA Community Edition 15.0.1`

  ![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450943875821.png)

  命名 Project Name

  ![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450944044114.png)

<br>
> 如果是第二次建立 Project，以下步驟就不用再次設定囉。

3. **設定 Project Module Settings**
  在 SDKs 頁籤中加入 JDK
  ![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450944205888.png)

  再加入 Plugin SDK，一樣選擇你的 IDEA 安裝路徑： `JetBrains\IntelliJ IDEA Community Edition 15.0.1`
  ![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450944263649.png)

　回到 Project 頁籤把 Project SDK 設定成 IDEA
  ![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450944331647.png)

<br>
4. **建立 Plugin Module**
  在 New 中點選 `New Module`
  ![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450944898804.png)

  命名 Plugin

  ![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450944981028.png)

<br><br>
####b. Project Directory Introduction
![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450949464414.png)

Plugin Project 的目錄主要兩個
1. `META_INF/plugin.iml` ： Plugin 設定檔，如基本資訊、開發更新 Log、各種 Action 與 Service 等等的元件定義
2. `src` ： 放置元件的資料夾，如：Action、Service、Swing介面或 icon 圖檔

<br><br>
####c. Create First Action
Action 是在 Plugin 上最常見的元件，不管是按下 Menu Item 或 Toolbar
1. 在 `src` 上點選右鍵 > 「New」 > 「Action」
  ![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450950803420.png)

<br>
2. 設定要註冊的 Action
  * ID：Action ID
  * Class Name：放在 src 的 class name
  * Name：在 Menu 或 Toolbar 上顯示的文字，字母前加上底線代表快捷鍵
  * Description：滑鼠停留在按鈕上顯示的說明
  * Groups：選擇要把這個 Action 加在哪個按鈕組合中，如 Toolbar 或 Menu 下的任何一個類別等等，右邊則是選擇要加在哪個按鈕的前面或後面

  ![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1450952397122.png)

<br>
3. 建立完成
  * 會在 plugin.xml 下註冊 Action 的資訊
```xml
<actions>
  <!-- Add your actions here -->
  <action id="CreateFirstAction" class="CreateFirstAction" text="_Create First" description="Create the first action">
    <add-to-group group-id="WindowMenu" anchor="first"/>
  </action>
</actions>
```
<br>
  * src 目錄出現的 Class
```java
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class CreateFirstAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
    }
}
```

<br>
####d. Debug Plugin
首先在 Run Configurations 新增一個 Plugin
![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1451039456523.png)

並在 `Use classpath of module` 中選擇你建立的 Plugin
![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1451039517713.png)

執行你剛剛所建立的 Run Config
![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1451039610809.png)

最後會開啟一個新的 InteliJ 程式，你可以開一個新的 Project 測試你的 Plugin 功能，這個 Project 是會實際保存的狀態的，會存在你的 'IDEA Project` 當中
![Alt text](https://github.com/25sprout/SproutCycleGenerator/blob/master/images/.1451039741566.png)





<br>
####e. About Plugin
**Thread Rule**
在 Plugin 運作當中，因為 I/O 讀寫的動作跟 Thread 有關，所以有幾個 Thread Rule 需要遵守：
* Read Thread：在 UI Thread 讀取檔案
```java
ApplicationManager.getApplication().runReadAction(new Runnable());
```
* Write：在 UI Thread 寫入檔案
```java
ApplicationManager.getApplication().runWriteAction(new Runnable());
```
* InvokeLater：在 Background Thread 執行的動作，譬如關閉 dialog 才執行動作
```java
ApplicationManager.getApplication().invokeLater(new Runnable());
```
> new Runnable() 則是你要做的事情。

<br>
**Architectural Element**
* [Virtual Files](http://www.jetbrains.org/intellij/sdk/docs/basics/architectural_overview/virtual_file.html)：代表一個專案中的 File，可以是 java、jar、任何檔案等等，也負責 File I/O 的功能
* [Document](http://www.jetbrains.org/intellij/sdk/docs/basics/architectural_overview/documents.html)：負責檔案內容的編輯
* [PSI Files](http://www.jetbrains.org/intellij/sdk/docs/basics/architectural_overview/psi_files.html)：以樹狀結構的方式操作檔案內容，譬如 PsiJavaFile 這類別可以直接取得 Import List、Package Name 元件等等
* [PSI Elements](http://www.jetbrains.org/intellij/sdk/docs/basics/architectural_overview/psi_elements.html)：PSI File 中的最小單位是 PSI Elements，可以操作 Source Code 中的內容或尋找子節點
* [File View Provider](http://www.jetbrains.org/intellij/sdk/docs/basics/architectural_overview/file_view_providers.html)
* [Project](http://www.jetbrains.org/intellij/sdk/docs/basics/project_structure.html)：專案中的 SourceCode、Library、Build instructions 等 Context 都封裝在 Project 中

因為官方文件寫的範例比較少，而在 `android-codegenerator-plugin-intellij` 專案中的 [Utils Package](https://github.com/tmorcinek/android-codegenerator-plugin-intellij/tree/master/src/com/morcinek/android/codegenerator/plugin/utils) 有寫了幾個很棒的 Helper 幫助取得 Package Name、File、Path 等等，如：[ProjectHelper](https://github.com/tmorcinek/android-codegenerator-plugin-intellij/blob/master/src/com/morcinek/android/codegenerator/plugin/utils/ProjectHelper.java)、[PathHelper](https://github.com/tmorcinek/android-codegenerator-plugin-intellij/blob/master/src/com/morcinek/android/codegenerator/plugin/utils/PathHelper.java)，可以直接參考使用。

<br>
#### f. My Plugin Development
本專案的 Source Code 因為只有兩個寫入檔案的動作，所以執行的過程方法都是一樣的，首先將要寫檔的 Method 放在 UI Thread 上執行。
```java
application.runWriteAction(new Runnable() {
            @Override
            public void run() {
                main();
            }
        });
```

`main()` 方法定義要寫入的檔案名稱、路徑、內容，如果有 Override 檔案的狀況，則會跳出 Dialog 再次確認，這邊比較重要的是 Try-Catch 區塊，如果有發生未知的 Exception，而沒有 catch 到的話，則 Plugin Deploy 的時候，會在右上角跳出 Error 通知，並建議使用者關閉此 Plugin，所以建議要多測試看看有沒有 Exception 的問題哦。
```java
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
```

`generateFile()` 主要是利用 `android-codegenerator-library` 來產生程式碼，在`android-codegenerator-library`中有放幾個 Code Template 可供修改，除此之外，更新完 File 後也記得要 Refresh，才會在 Project Explorer 中出現。
```java
private void generateFile(String path, String fileName) throws IOException {
    //create base file
    VirtualFile createdFile = projectHelper.createOrFindFile(project, fileName, path);

    //generate code
    TemplateCodeGenerator generator = new TemplateCodeGenerator(getTemplateName(), getResourceFactory(), TemplateSettings.getInstance());
    String generatedCode = "package " + getPackageName() + ";\n\n";
    generatedCode += generator.generateCode(new ArrayList<Resource>(), fileName.replace(".java", ""));


    //set file content
    projectHelper.setFileContent(project, createdFile, generatedCode);

  //refresh
    VirtualFile vf = LocalFileSystem.getInstance().findFileByIoFile(new File(path));
    vf.refresh(true, false);
}
```





<br>
-----
### Reference
* [IntelliJ Platform SDK DevGuide](http://www.jetbrains.org/intellij/sdk/docs/basics/persisting_state_of_components.html)
* [IntelliJ IDEA插件开发手册](http://www.360doc.com/content/14/1107/13/16650130_423318501.shtml)
* [Intellij IDEA插件开发入门 ](http://blog.csdn.net/dc_726/article/details/14139155)


















