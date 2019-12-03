package app.project.loginregister.helper;

import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputEditText;

public abstract class PhoneMaskHelper {
    private static final String mask8 = "####-####";
    private static final String mask9 = "#####-####";
    private static final String mask10 = "(##) ####-####";
    private static final String mask11 = "(##) #####-####";

    public static TextWatcher insert(final TextInputEditText editText) {
        return new TextWatcher() {
            boolean isUpdating;
            String old = "";

            @Override
            public void beforeTextChanged(CharSequence cs, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence cs, int start, int before, int count) {
                String string = PhoneMaskHelper.unmask(cs.toString());
                String mask;
                String defaultMask = getDefaultMask(string);

                switch (string.length()) {
                    case 9:
                        mask = mask9;
                        break;
                    case 10:
                        mask = mask10;
                        break;
                    case 11:
                        mask = mask11;
                        break;
                    default:
                        mask = defaultMask;
                        break;
                }

                String mascara = "";

                if (isUpdating) {
                    old = string;
                    isUpdating = false;
                    return;
                }

                int i = 0;

                for (char m : mask.toCharArray()) {
                    if ((m != '#' && string.length() > old.length()) || (m != '#' && string.length() < old.length() && string.length() != i)) {
                        mascara += m;
                        continue;
                    }

                    try {
                        mascara += string.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                editText.setText(mascara);
                editText.setSelection(mascara.length());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };
    }

    private static String unmask(String string) {
        return string.replaceAll("[^0-9]*", "");
    }

    private static String getDefaultMask(String string) {
        String defaultMask = mask8;

        if (string.length() > 11){
            defaultMask = mask11;
        }
        return defaultMask;
    }
}
