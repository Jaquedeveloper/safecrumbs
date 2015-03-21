package hackfsu.safecrumbs;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.app.ProgressDialog;
import android.database.Cursor;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.provider.ContactsContract;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.Display;
import android.content.res.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import hackfsu.safecrumbs.ContactPicker.G_Contact;
import hackfsu.safecrumbs.ContactPicker.G_ContactList;

/**
 * Created by jaqueline on 3/21/15.
 */
public class AsyncContactLoader extends AsyncTask{

    ContactListAdapter cla;
    ProgressDialog pgdlg;

    AsyncContactLoader(ContactListAdapter adap)
    {
        //init AsyncLoader with the ListView Adapter
        cla = adap;
    }

    protected void onPreExecute()
    {
        //Show a pop up message
        pgdlg = ProgressDialog.show(ContactPicker.this, "Please Wait", "Loading Contacts with Phone Numbers",true);
    }


//Loading Contacts

    @Override
    protected G_ContactList doInBackground(String... filters )
    {
        G_ContactList glst=null;

//Filter = text in search textbox
        Context c = new Context() {
            @Override
            public AssetManager getAssets() {
                return null;
            }

            @Override
            public Resources getResources() {
                return null;
            }

            @Override
            public PackageManager getPackageManager() {
                return null;
            }

            @Override
            public ContentResolver getContentResolver() {
                return null;
            }

            @Override
            public Looper getMainLooper() {
                return null;
            }

            @Override
            public Context getApplicationContext() {
                return null;
            }

            @Override
            public void setTheme(int i) {

            }

            @Override
            public Resources.Theme getTheme() {
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                return null;
            }

            @Override
            public String getPackageName() {
                return null;
            }

            @Override
            public ApplicationInfo getApplicationInfo() {
                return null;
            }

            @Override
            public String getPackageResourcePath() {
                return null;
            }

            @Override
            public String getPackageCodePath() {
                return null;
            }

            @Override
            public SharedPreferences getSharedPreferences(String s, int i) {
                return null;
            }

            @Override
            public FileInputStream openFileInput(String s) throws FileNotFoundException {
                return null;
            }

            @Override
            public FileOutputStream openFileOutput(String s, int i) throws FileNotFoundException {
                return null;
            }

            @Override
            public boolean deleteFile(String s) {
                return false;
            }

            @Override
            public File getFileStreamPath(String s) {
                return null;
            }

            @Override
            public File getFilesDir() {
                return null;
            }

            @Override
            public File getNoBackupFilesDir() {
                return null;
            }

            @Nullable
            @Override
            public File getExternalFilesDir(String s) {
                return null;
            }

            @Override
            public File[] getExternalFilesDirs(String s) {
                return new File[0];
            }

            @Override
            public File getObbDir() {
                return null;
            }

            @Override
            public File[] getObbDirs() {
                return new File[0];
            }

            @Override
            public File getCacheDir() {
                return null;
            }

            @Override
            public File getCodeCacheDir() {
                return null;
            }

            @Nullable
            @Override
            public File getExternalCacheDir() {
                return null;
            }

            @Override
            public File[] getExternalCacheDirs() {
                return new File[0];
            }

            @Override
            public File[] getExternalMediaDirs() {
                return new File[0];
            }

            @Override
            public String[] fileList() {
                return new String[0];
            }

            @Override
            public File getDir(String s, int i) {
                return null;
            }

            @Override
            public SQLiteDatabase openOrCreateDatabase(String s, int i, SQLiteDatabase.CursorFactory cursorFactory) {
                return null;
            }

            @Override
            public SQLiteDatabase openOrCreateDatabase(String s, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
                return null;
            }

            @Override
            public boolean deleteDatabase(String s) {
                return false;
            }

            @Override
            public File getDatabasePath(String s) {
                return null;
            }

            @Override
            public String[] databaseList() {
                return new String[0];
            }

            @Override
            public Drawable getWallpaper() {
                return null;
            }

            @Override
            public Drawable peekWallpaper() {
                return null;
            }

            @Override
            public int getWallpaperDesiredMinimumWidth() {
                return 0;
            }

            @Override
            public int getWallpaperDesiredMinimumHeight() {
                return 0;
            }

            @Override
            public void setWallpaper(Bitmap bitmap) throws IOException {

            }

            @Override
            public void setWallpaper(InputStream inputStream) throws IOException {

            }

            @Override
            public void clearWallpaper() throws IOException {

            }

            @Override
            public void startActivity(Intent intent) {

            }

            @Override
            public void startActivity(Intent intent, Bundle bundle) {

            }

            @Override
            public void startActivities(Intent[] intents) {

            }

            @Override
            public void startActivities(Intent[] intents, Bundle bundle) {

            }

            @Override
            public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {

            }

            @Override
            public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) throws IntentSender.SendIntentException {

            }

            @Override
            public void sendBroadcast(Intent intent) {

            }

            @Override
            public void sendBroadcast(Intent intent, String s) {

            }

            @Override
            public void sendOrderedBroadcast(Intent intent, String s) {

            }

            @Override
            public void sendOrderedBroadcast(Intent intent, String s, BroadcastReceiver broadcastReceiver, Handler handler, int i, String s2, Bundle bundle) {

            }

            @Override
            public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {

            }

            @Override
            public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, String s) {

            }

            @Override
            public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String s, BroadcastReceiver broadcastReceiver, Handler handler, int i, String s2, Bundle bundle) {

            }

            @Override
            public void sendStickyBroadcast(Intent intent) {

            }

            @Override
            public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String s, Bundle bundle) {

            }

            @Override
            public void removeStickyBroadcast(Intent intent) {

            }

            @Override
            public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {

            }

            @Override
            public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i, String s, Bundle bundle) {

            }

            @Override
            public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {

            }

            @Nullable
            @Override
            public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
                return null;
            }

            @Nullable
            @Override
            public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String s, Handler handler) {
                return null;
            }

            @Override
            public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {

            }

            @Nullable
            @Override
            public ComponentName startService(Intent intent) {
                return null;
            }

            @Override
            public boolean stopService(Intent intent) {
                return false;
            }

            @Override
            public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
                return false;
            }

            @Override
            public void unbindService(ServiceConnection serviceConnection) {

            }

            @Override
            public boolean startInstrumentation(ComponentName componentName, String s, Bundle bundle) {
                return false;
            }

            @Override
            public Object getSystemService(String s) {
                return null;
            }

            @Override
            public int checkPermission(String s, int i, int i2) {
                return 0;
            }

            @Override
            public int checkCallingPermission(String s) {
                return 0;
            }

            @Override
            public int checkCallingOrSelfPermission(String s) {
                return 0;
            }

            @Override
            public void enforcePermission(String s, int i, int i2, String s2) {

            }

            @Override
            public void enforceCallingPermission(String s, String s2) {

            }

            @Override
            public void enforceCallingOrSelfPermission(String s, String s2) {

            }

            @Override
            public void grantUriPermission(String s, Uri uri, int i) {

            }

            @Override
            public void revokeUriPermission(Uri uri, int i) {

            }

            @Override
            public int checkUriPermission(Uri uri, int i, int i2, int i3) {
                return 0;
            }

            @Override
            public int checkCallingUriPermission(Uri uri, int i) {
                return 0;
            }

            @Override
            public int checkCallingOrSelfUriPermission(Uri uri, int i) {
                return 0;
            }

            @Override
            public int checkUriPermission(Uri uri, String s, String s2, int i, int i2, int i3) {
                return 0;
            }

            @Override
            public void enforceUriPermission(Uri uri, int i, int i2, int i3, String s) {

            }

            @Override
            public void enforceCallingUriPermission(Uri uri, int i, String s) {

            }

            @Override
            public void enforceCallingOrSelfUriPermission(Uri uri, int i, String s) {

            }

            @Override
            public void enforceUriPermission(Uri uri, String s, String s2, int i, int i2, int i3, String s3) {

            }

            @Override
            public Context createPackageContext(String s, int i) throws PackageManager.NameNotFoundException {
                return null;
            }

            @Override
            public Context createConfigurationContext(Configuration configuration) {
                return null;
            }

            @Override
            public Context createDisplayContext(Display display) {
                return null;
            }
        };
        String filter = filters[0];
        ContentResolver cr = Context.getContentResolver();
        int count=0;

        //Code to fetch contacts...

        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        //Fields to select from database
        String[] projection = new String[]{
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.HAS_PHONE_NUMBER
        };

        /*Querying database (Select fields in projection from database where contact name like 'filter%', sort by name, in ascending order)*/
        Cursor cursor = cr.query(uri, projection,  ContactsContract.Contacts.DISPLAY_NAME + " LIKE ?", new  String[] {filter.toString()},  ContactsContract.Contacts.DISPLAY_NAME+ " ASC");

        //Log.v("", "Contacts : "+cursor.getCount());
        if(cursor.getCount()>0)
        {

            glst=new G_ContactList();

            while(cursor.moveToNext())
            {

//Filtering Contacts with Phone Numbers

                if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))>0)
                {

                    String id =  cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

//Phone numbers lies in a separate table. Querying that table with Contact ID

                    Cursor ph_cur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID +"=?", new String[] {id}, null);
                    while(ph_cur.moveToNext())
                    {

                        String phId = ph_cur.getString(ph_cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));

//Label eg : home, office etc. They are stored as int values

                        String customLabel = ph_cur.getString(ph_cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.LABEL));
                        String label = (String)ContactsContract.CommonDataKinds.Phone.getTypeLabel(getResources(),ph_cur.getInt(ph_cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE)),customLabel);
                        String ph_no = ph_cur.getString(ph_cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        G_Contact tmp = new G_Contact(phId,name,ph_no,label);
                        glst.addContact(tmp);
                        count++;


//Refresh ListView upon loading 100 Contacts

                        if(count==100)
                        {
                            publishProgress(glst);
                            count=0;
                        }

                    }
                    ph_cur.close();
                }


            }
            cursor.close();

        }


        return glst;
    }

//Code to refresh list view

    @Override
    protected void onProgressUpdate(G_ContactList... glsts )
    {
        if(pgdlg.isShowing())
            pgdlg.dismiss();
        cla.gcl = glsts[0];
        cla.notifyDataSetChanged();
//Log.v("Progress", cla.getCount()+" loaded");
    }

    @Override
//Loading contacts finished, refresh list view to load any missed out contacts

    protected void onPostExecute(G_ContactList result)
    {
        if(pgdlg.isShowing())
            pgdlg.dismiss();
        cla.gcl=result;
        cla.notifyDataSetChanged();
//Log.v("Progress ::", cla.getCount()+" total loaded");
//Toast.makeText(ContactPicker.this, cla.getCount()+" Contact(s) Found", Toast.LENGTH_LONG).show();
    }


}
