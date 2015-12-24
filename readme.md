# SproutCycleGenerator
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

  會在 plugin.xml 下註冊 Action 的資訊
```xml
<actions>
  <!-- Add your actions here -->
  <action id="CreateFirstAction" class="CreateFirstAction" text="_Create First" description="Create the first action">
    <add-to-group group-id="WindowMenu" anchor="first"/>
  </action>
</actions>
```

src 目錄出現的 Class
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








