package io.meisterwerk.coinsocean.utils;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.List;

import io.meisterwerk.coinsocean.events.Coin;

/**
 * Created by xdev on 07.02.18.
 */

public class Util {

    public static int getListStep(List<Coin> listCoinList) {
        int step = 0;
        for (int i = 1; i < listCoinList.size(); i++) {
            if (listCoinList.size() % i == 0 && i < 50) {
                step = i;
            }
        }
        return step;
    }

    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
        }
    }


}
