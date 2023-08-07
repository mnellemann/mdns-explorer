package biz.nellemann.mdexpl.view;

import biz.nellemann.mdexpl.App;
import com.gluonhq.charm.glisten.afterburner.AppView;
import com.gluonhq.charm.glisten.afterburner.AppViewRegistry;
import com.gluonhq.charm.glisten.afterburner.Utils;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.image.Image;

import java.util.Locale;
import java.util.Objects;

import static com.gluonhq.charm.glisten.afterburner.AppView.Flag.*;

public class AppViewManager {

    public static final AppViewRegistry REGISTRY = new AppViewRegistry();

    // Shown in drawer
    public static final AppView PRIMARY_VIEW = view("Explorer", MainPresenter.class, MaterialDesignIcon.HOME, SHOW_IN_DRAWER, HOME_VIEW, SKIP_VIEW_STACK);
    public static final AppView ABOUT_VIEW = view("About", AboutPresenter.class, MaterialDesignIcon.HELP, SHOW_IN_DRAWER);



    private static AppView view(String title, Class<?> presenterClass, MaterialDesignIcon menuIcon, AppView.Flag... flags ) {
        return REGISTRY.createView(name(presenterClass), title, presenterClass, menuIcon, flags);
    }

    private static String name(Class<?> presenterClass) {
        return presenterClass.getSimpleName().toUpperCase(Locale.ROOT).replace("PRESENTER", "");
    }

    public static void registerViewsAndDrawer() {
        for (AppView view : REGISTRY.getViews()) {
            view.registerView();
        }

        NavigationDrawer.Header header = new NavigationDrawer.Header("mDNS Explorer",
            "Multicast DNS Explorer",
            new Avatar(48, new Image(Objects.requireNonNull(App.class.getResourceAsStream("/icon.png"))))
        );

        Utils.buildDrawer(AppManager.getInstance().getDrawer(), header, REGISTRY.getViews());

        //NavigationDrawer.Footer footer = new NavigationDrawer.Footer("Bla");
        //AppManager.getInstance().getDrawer().setFooter(footer);
    }

}
