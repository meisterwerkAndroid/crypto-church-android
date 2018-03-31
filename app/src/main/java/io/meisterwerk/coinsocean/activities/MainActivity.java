package io.meisterwerk.coinsocean.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import io.meisterwerk.coinsocean.R;
import io.meisterwerk.coinsocean.fragments.ConverterFragment;
import io.meisterwerk.coinsocean.fragments.DashboardFragment;
import io.meisterwerk.coinsocean.fragments.TopListFragment;
import io.meisterwerk.coinsocean.fragments.NotificationFragment;
import io.meisterwerk.coinsocean.utils.Util;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavigationView = findViewById(R.id.navigation);
        Util.disableShiftMode(mNavigationView);
        mNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void changeFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.main_container, fragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                changeFragment(new TopListFragment());
                break;
            case R.id.navigation_dashboard:
                changeFragment(new DashboardFragment());
                break;
            case R.id.navigation_notifications:
                changeFragment(new NotificationFragment());
                break;
            case R.id.navigation_converter:
                changeFragment(new ConverterFragment());
                break;
            default:
                break;
        }
        return true;
    }
}
