package se.i18n;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author zhangyaowen
 */
public class LocaleUse {
    public static void main(String[] args) {
        LocaleUse localeUse = new LocaleUse();
        localeUse.dumpDefaultLocal();
    }

    private void dumpAvailableLocal() {
        Arrays.asList(Locale.getAvailableLocales()).forEach(System.out::println);
        System.out.println(Arrays.asList(Locale.getAvailableLocales()).size());
        Arrays.asList(NumberFormat.getAvailableLocales()).forEach(System.out::println);
    }

    private void dumpDefaultLocal() {
        System.out.println(Locale.getDefault().getDisplayName());
    }


}
