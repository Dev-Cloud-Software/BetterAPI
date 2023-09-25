/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.utils;

import java.util.Locale;
import java.util.ResourceBundle;
import lombok.extern.java.Log;

@Log(topic = "BetterAPI")
public class Localizer {

    private final ResourceBundle language;

    public Localizer(String configuredLanguage) {
        String[] langCode = langSplitter(configuredLanguage);
        Locale locale = new Locale(langCode[0], langCode[1]);
        this.language = ResourceBundle.getBundle("languages/language", locale);
        log.info(get("plugin.localizer.loaded"));
    }

    public String get(String key) {
        return language.getString(key);
    }

    private String[] langSplitter(String lang) {
        return lang.split("_");
    }
}
